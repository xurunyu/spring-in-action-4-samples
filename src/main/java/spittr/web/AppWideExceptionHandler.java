package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {

    /**
     * 针对全局的exception控制
     * DuplicateSpittleException
     * @return
     */
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle() {
        return "error/duplicate";
    }
}
