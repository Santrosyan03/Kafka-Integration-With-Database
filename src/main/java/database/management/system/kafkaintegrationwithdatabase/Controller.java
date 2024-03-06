package database.management.system.kafkaintegrationwithdatabase;

import database.management.system.kafkaintegrationwithdatabase.message.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class Controller {

    private final ProducerKafka producerKafka;

    public Controller(ProducerKafka producerKafka) {
        this.producerKafka = producerKafka;
    }

    @PostMapping
    public void post(@RequestBody Message m) {
        producerKafka.sendMessage(m.getValue());
    }
}
