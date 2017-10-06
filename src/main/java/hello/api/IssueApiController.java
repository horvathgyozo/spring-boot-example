package hello.api;

import hello.annotation.Role;
import hello.entity.Issue;
import static hello.entity.User.Role.*;
import hello.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/issue")
public class IssueApiController {
    
    @Autowired
    private IssueService issueService;

    @Role({ADMIN, USER})
    @GetMapping
    public ResponseEntity<Iterable<Issue>> list() {
        return ResponseEntity.ok(issueService.findAll());
    }
    
}
