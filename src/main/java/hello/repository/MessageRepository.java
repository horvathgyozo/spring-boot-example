package hello.repository;

import hello.entity.Issue;
import hello.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>  {
    Iterable<Message> findAllByIssue(Issue issue);
}
