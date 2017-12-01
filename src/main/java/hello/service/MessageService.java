package hello.service;

import hello.entity.Issue;
import hello.entity.Message;
import hello.entity.User;
import hello.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public Iterable<Message> listByIssue(Issue issue) {
        return messageRepository.findAllByIssue(issue);
    }
    
    public Message create(Message message, Issue issue, User user) {
        message.setUser(user);
        message.setIssue(issue);
        return messageRepository.save(message);
    }
    
}
