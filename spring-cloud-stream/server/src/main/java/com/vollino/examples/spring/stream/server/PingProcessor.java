package com.vollino.examples.spring.stream.server;

import com.vollino.examples.spring.stream.api.ChannelNames;
import com.vollino.examples.spring.stream.api.Ping;
import com.vollino.examples.spring.stream.api.Pong;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class PingProcessor {

    @StreamListener(ChannelNames.PROCESS_QUEUE)
    @SendTo(ChannelNames.PROCESSED)
    public Pong process(Ping ping) {
        Pong pong = new Pong(ping.getId());
        System.out.println(pong);

        return pong;
    }
}
