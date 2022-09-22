package ru.skypro.course2.coursework.coursework2.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ContextConfigure {

    @Bean
    Random random() {
        return new Random();
    }
}
