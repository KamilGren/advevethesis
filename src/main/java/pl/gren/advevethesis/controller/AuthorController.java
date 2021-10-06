package pl.gren.advevethesis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gren.advevethesis.model.Author;
import pl.gren.advevethesis.model.Event;
import pl.gren.advevethesis.service.AuthorService;


import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // This means that this class is a Controller
@RequestMapping(path="/authors") // This means URL's start with /demo (after Application path)

public class AuthorController {

    private AuthorService authorService;

    private static final Logger logger  = LoggerFactory.getLogger(AuthorController.class);

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    ResponseEntity<Author> postAuthor(@RequestBody @Valid Author authorBody) {

        authorService.save(authorBody);

        return authorService.findById(authorBody.getId())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/all")
    ResponseEntity<List<Author>> readAllUsers(Pageable pageable) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(authorService.listAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Author> readAuthorId(@PathVariable int id) {
        return authorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{authorName}")
    ResponseEntity<List<Author>> readAuthorName(@PathVariable String authorName) {

        List<Author> author = new ArrayList<>();

        authorService.findByName(authorName).forEach(author::add);
        return ResponseEntity.ok(author);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> toggleEvent(@PathVariable int id){

        if(!authorService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Event> DeleteEvent(@PathVariable int id)
    {
        if(!authorService.existsById(id))
        {
            return ResponseEntity.noContent().build();
        }
        authorService.deleteById(id);
        return ResponseEntity.notFound().build();
    }
}