package io.ikka.demos.springbootkafkaexample.clr;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CLR1 implements CommandLineRunner {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic newTopic1;

    @Override
    public void run(String... args) {
        kafkaTemplate.send(
                newTopic1.name(),
                UUID.randomUUID().toString(),
                LocalDateTime.now().toString());
    }
}
