package hello.service;

import hello.entity.Issue;
import hello.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
    
    @Autowired
    private IssueRepository issueRepository;
    
    public Iterable<Issue> findAll() {
        return issueRepository.findAll();
    }
    
}
