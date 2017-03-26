package com.vollino.examples.spring.stream.client;

import com.vollino.examples.spring.stream.api.Ping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PingProducer {

    private Channels channels;
    private int count = 1;

    @Autowired
    public PingProducer(Channels channels) {
        this.channels = channels;
    }

    @Scheduled(fixedDelay = 1000)
    public void produce() {
        Ping ping = new Ping(count++);
        System.out.println(ping);

        channels.processQueue().send(MessageBuilder.withPayload(ping).setHeader("contentType", "application/json").build());
    }
}
