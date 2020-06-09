package uk.co.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The purpose of this class is to essentially allow the application to start. 
 * You can think of this as the root file if you like. 
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@EnableWebMvc
@Configuration
@SpringBootApplication
public class Application {

    /**
     * This is the starting point of this spring boot application.
     *
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args) {
        DispatcherServlet.class
                .cast(SpringApplication.run(Application.class, args).getBean("dispatcherServlet"))
                .setThrowExceptionIfNoHandlerFound(true);
    }
}
