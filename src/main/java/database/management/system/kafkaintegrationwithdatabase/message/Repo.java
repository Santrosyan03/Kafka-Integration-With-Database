package database.management.system.kafkaintegrationwithdatabase.message;

public interface Repo {
    Message addMessage(Message message);
    Message getMessage(Long id);
}
