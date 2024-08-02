package Primesniper.kafkaReactive.producer;

import Primesniper.kafkaReactive.payload.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User student) {

        Message<User> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "sniper")
                .build();

        kafkaTemplate.send(message);
    }
}