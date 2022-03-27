package com.example.bookretailsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BookRetailSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookRetailSystemApplication.class, args);
    }

}
