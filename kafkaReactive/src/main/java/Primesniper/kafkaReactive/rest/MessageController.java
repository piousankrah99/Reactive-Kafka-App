package Primesniper.kafkaReactive.rest;


import Primesniper.kafkaReactive.payload.User;

import Primesniper.kafkaReactive.producer.KafkaJsonProducer;
import Primesniper.kafkaReactive.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    private final KafkaJsonProducer kafkaJsonProducer;

        @PostMapping
        public ResponseEntity<String> sendMessage(
                @RequestBody String message
        ) {
            kafkaProducer.sendMessage(message);
            return ResponseEntity.ok("Message queued successfully" + message);
        }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(
            @RequestBody User message
    ) {
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully as JSON " + message);
    }
}