package com.example.practice66ezhikov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Practice66EzhikovApplication {

    public static void main(String[] args) {
        SpringApplication.run(Practice66EzhikovApplication.class, args);
    }

}
