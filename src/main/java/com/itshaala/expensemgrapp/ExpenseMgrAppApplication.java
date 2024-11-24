package com.itshaala.expensemgrapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ExpenseMgrAppApplication {

    public static void main(String[] args)  {
        SpringApplication.run(ExpenseMgrAppApplication.class, args);
    }
}