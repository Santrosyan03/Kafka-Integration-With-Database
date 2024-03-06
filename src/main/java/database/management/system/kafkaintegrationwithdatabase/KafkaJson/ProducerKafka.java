package database.management.system.kafkaintegrationwithdatabase.KafkaJson;

import database.management.system.kafkaintegrationwithdatabase.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerKafka {

    @Value("${spring.kafka.template.default-topic}")
    private String topicName;

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public ProducerKafka(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Message message) {
        kafkaTemplate.send(MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build());
    }
}