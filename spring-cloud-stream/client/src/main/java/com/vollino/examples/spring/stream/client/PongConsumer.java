package com.vollino.examples.spring.stream.client;

import com.vollino.examples.spring.stream.api.ChannelNames;
import com.vollino.examples.spring.stream.api.Pong;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class PongConsumer {

    @StreamListener(ChannelNames.PROCESSED)
    public void processMessage(Pong pong) {
        System.out.println(pong);
    }
}
