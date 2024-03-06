package database.management.system.kafkaintegrationwithdatabase.message;

import org.springframework.stereotype.Service;


@Service
public class RepoImpl implements Repo {

    private final MessageRepository messageRepository;

    public RepoImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message addMessage(Message message) {
        messageRepository.save(message);
        return message;
    }

    @Override
    public Message getMessage(Long id) {
        return messageRepository.getReferenceById(id);
    }
}
