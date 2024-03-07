package database.management.system.kafkaintegrationwithdatabase.message;

import database.management.system.kafkaintegrationwithdatabase.KafkaJson.ProducerKafka;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/send/message")
public class Controller {

    private final ProducerKafka kafkaProducer;

    public Controller(ProducerKafka kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Message message) {
        kafkaProducer.sendMessage(Message.builder()
                .value(message.getValue())
                .build());
        return ResponseEntity.ok("Successfully sent :)");
    }

}