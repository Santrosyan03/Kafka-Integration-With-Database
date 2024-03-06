package database.management.system.kafkaintegrationwithdatabase;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listeners {
    @KafkaListener(topics = "santrosyan", groupId = "groupId", containerFactory="factory")
    void listener(String data) {
        System.out.println("Data is:" + data);
    }
}
