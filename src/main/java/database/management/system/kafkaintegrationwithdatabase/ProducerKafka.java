package database.management.system.kafkaintegrationwithdatabase;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerKafka {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerKafka(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String m) {
        kafkaTemplate.send("santrosyan", m);
    }
}
