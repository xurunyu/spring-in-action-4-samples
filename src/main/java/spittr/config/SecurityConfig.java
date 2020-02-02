package spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import spittr.data.SpitterRepository;
import spittr.security.SpitterUserService;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    SpitterRepository spitterRepository;

    /**
     * 配置用户认证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*内存认证*/
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
        /*数据库认证*/
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, true " +
                "from Spitter where username = ?")
                .authoritiesByUsernameQuery(
                        "select username, 'ROLE_USER' from Spitter where username = ?"
                )
                .passwordEncoder(new BCryptPasswordEncoder());
        /*LDAP认证*/
        auth.ldapAuthentication()
                .userSearchBase("ou=people")
                .userSearchFilter("(uid={0}")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0}")
                .contextSource().url("ldap://habuma.com:389/dc=hubama,dc=com");
//                .passwordCompare()
//                .passwordEncoder(new Md4PasswordEncoder())
//                .passwordAttribute("passcode"));
        /*自定义数据（非关系数据库）*/
        auth.userDetailsService(new SpitterUserService(spitterRepository));
    }

    /**
     * 配置页面认证
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                    .loginPage("/login")
                .and()
                .rememberMe()
                    .tokenValiditySeconds(2419200)
                    .key("spittrKey")
                .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .logoutUrl("/signout")
                .and()
                .authorizeRequests()
                    .antMatchers(("/spitters/me")).hasRole("SPITTER")
                    .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                    .anyRequest().permitAll()
                .and()
                .requiresChannel()
                    .antMatchers("/spitter/form")
                    .requiresSecure();
    }
}
