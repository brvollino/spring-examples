package com.vollino.examples.spring.stream.client;

import com.vollino.examples.spring.stream.api.ChannelNames;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Channels {

    @Output(ChannelNames.PROCESS_QUEUE)
    MessageChannel processQueue();

    @Input(ChannelNames.PROCESSED)
    MessageChannel processed();
}
