package database.management.system.kafkaintegrationwithdatabase.KafkaJson;

import database.management.system.kafkaintegrationwithdatabase.message.Message;
import database.management.system.kafkaintegrationwithdatabase.message.MessageRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerKafka {

    private final MessageRepository messageRepository;

    public ConsumerKafka(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@NotNull Message message) {
        System.out.println("Consumed Data: " + message.getValue());
        Message savedMessage = messageRepository.save(message);
        System.out.println("Saved Message ID: " + savedMessage.getId());
    }
}