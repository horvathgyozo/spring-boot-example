package hello.repository;

import hello.entity.Issue;
import hello.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Long> {
//    Iterable<Issue> findAllByUser(User user);
}
