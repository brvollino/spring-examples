package com.vollino.examples.spring.stream.client;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Channels.class)
public class KafkaConfig {
}