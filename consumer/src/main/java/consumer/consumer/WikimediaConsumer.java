package consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class WikimediaConsumer {

    @KafkaListener(topics = "sniper", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info(format("Consuming the message from sniper Topic:: %s", msg));
        // Please feel free to do anything you want with the data
    }
}
