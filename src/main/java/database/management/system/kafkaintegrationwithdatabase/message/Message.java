package database.management.system.kafkaintegrationwithdatabase.message;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;


@Entity(name = "messages")
@Getter
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "value")
    private String value;
}
