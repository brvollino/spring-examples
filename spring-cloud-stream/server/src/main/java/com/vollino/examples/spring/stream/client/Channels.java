package com.vollino.examples.spring.stream.client;

import com.vollino.examples.spring.stream.api.ChannelNames;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Channels {

    @Input(ChannelNames.PROCESS_QUEUE)
    MessageChannel processQueue();

    @Output(ChannelNames.PROCESSED)
    MessageChannel processed();
}
