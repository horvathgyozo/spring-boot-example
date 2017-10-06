package hello.service;

import hello.entity.Issue;
import hello.entity.User;
import hello.entity.User.Role;
import hello.repository.IssueRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
    
    @Autowired
    private IssueRepository issueRepository;
    
//    public Iterable<Issue> findAll() {
//        return issueRepository.findAll();
//    }
    
    public Iterable<Issue> listByRole(User user) {
        Role role = user.getRole();
        if (role == Role.USER) {
            return issueRepository.findAllByUser(user);
        } 
        else if (role == Role.ADMIN) {
            return issueRepository.findAll();
        }
        return Collections.emptyList();
    }
    
    public Issue create(Issue issue, User user) {
        issue.setStatus(Issue.Status.ADDED);
        issue.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        issue.setUser(user);
        return issueRepository.save(issue);
    }
    
    public Issue update(long id, Issue issue) {
        Issue currentIssue = issueRepository.findOne(id);

//        currentIssue.setStatus(issue.getStatus());
//        currentIssue.setDescription(issue.getDescription());
//        currentIssue.setLocation(issue.getLocation());

//        return issueRepository.save(currentIssue);

        return issueRepository.save(issue);
    }

    public void delete(long id) {
        issueRepository.delete(id);
    }

    public Issue read(long id) {
        return issueRepository.findOne(id);
    }
}
