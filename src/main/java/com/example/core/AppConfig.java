package com.example.core;

import com.example.core.ATMController.ATMController;
import com.example.core.ATMController.ATMControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ATMController atmController() {
        return new ATMControllerImpl();
    }

}
