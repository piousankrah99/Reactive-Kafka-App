package Primesniper.kafkaReactive.consumer;

import Primesniper.kafkaReactive.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "sniper", groupId = "myGroup")
    public void consumeMsg(String msg){
        log.info("Consuming message from sniper topic "+ msg);
    }


    @KafkaListener(topics = "sniper", groupId = "myGroup")
    public void consumeJsonMsg(User user){
        log.info("Consuming message from sniper topic "+ user.toString());
    }
}
