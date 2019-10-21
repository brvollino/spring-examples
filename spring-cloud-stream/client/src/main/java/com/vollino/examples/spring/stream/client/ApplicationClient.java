package com.vollino.examples.spring.stream.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(KafkaConfig.class)
@SpringBootApplication
public class ApplicationClient {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient.class, args);
    }
}
