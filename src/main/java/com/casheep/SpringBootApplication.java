package com.casheep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static java.lang.System.exit;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringBootApplication {


    public static void main(String... args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }


    public void run(String... args) throws Exception {
        System.out.println("This is a SpringBoot console application");
        exit(0);
    }


    


    


}
