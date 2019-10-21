package com.vollino.examples.spring.stream.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(KafkaConfig.class)
@SpringBootApplication
public class ApplicationServer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServer.class, args);
    }
}
