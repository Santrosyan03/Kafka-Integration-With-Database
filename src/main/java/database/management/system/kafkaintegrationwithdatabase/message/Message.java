package database.management.system.kafkaintegrationwithdatabase.message;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Data
@Entity(name = "messages")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    private String value;

}
