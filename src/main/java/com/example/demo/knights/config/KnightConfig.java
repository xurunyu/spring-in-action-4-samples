package com.example.demo.knights.config;

import com.example.demo.knights.BraveKnight;
import com.example.demo.knights.Knight;
import com.example.demo.knights.Minstrel;
import com.example.demo.quest.Quest;
import com.example.demo.quest.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Minstrel minstrel(){ return new Minstrel(System.out); }
}
