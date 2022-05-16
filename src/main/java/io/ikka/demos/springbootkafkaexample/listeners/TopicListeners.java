package io.ikka.demos.springbootkafkaexample.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TopicListeners {
    @Value("${kafka.topic}")
    private String topic;
    @Value("${kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.group-id}")
    public void listenGroupFoo(String message) {
        log.info("Received Message in group " + groupId + "topic : " + message);
    }
}
