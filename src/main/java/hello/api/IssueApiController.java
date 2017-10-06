package hello.api;

import hello.annotation.Role;
import hello.entity.Issue;
import static hello.entity.User.Role.*;
import hello.service.IssueService;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/issue")
public class IssueApiController {
    
    @Autowired
    private IssueService issueService;

    @Autowired
    private UserService userService;
    
    @Role({ADMIN, USER})
    @GetMapping
    public ResponseEntity<Iterable<Issue>> list() {
        return ResponseEntity.ok(issueService.listByRole(userService.getLoggedInUser()));
    }
    
    @Role({ADMIN, USER})
    @PostMapping
    public ResponseEntity<Issue> create(@RequestBody Issue issue) {
        return ResponseEntity.ok(issueService.create(issue, userService.getLoggedInUser()));
    }
    
    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    private ResponseEntity<Issue> read(@PathVariable String id) {
        Issue read = issueService.read(Integer.parseInt(id));
        return ResponseEntity.ok(read);
    }

    @Role(ADMIN)
    @PutMapping("/{id}")
    private ResponseEntity<Issue> update(@PathVariable long id, @RequestBody Issue issue) {
        Issue updated = issueService.update(id, issue);
        return ResponseEntity.ok(updated);
    }

    @Role(ADMIN)
    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable long id) {
        issueService.delete(id);
        return ResponseEntity.ok().build();
    }
}
