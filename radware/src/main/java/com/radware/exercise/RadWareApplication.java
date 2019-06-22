package com.radware.exercise;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RadWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(RadWareApplication.class, args);
    }

}
