package pl.gren.advevethesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gren.advevethesis.model.Comment;
import pl.gren.advevethesis.service.CommentService;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin( origins = "*", maxAge = 3600)

public class CommentController {

    @Autowired
    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/users/{userName}/addComment")
    ResponseEntity<Comment> addCommentByUser(@RequestBody Comment comment) {

        LocalDateTime time = LocalDateTime.now();
        comment.setTime(time);
        Comment result = commentService.save(comment);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/comments")
    ResponseEntity<List<Comment>> getComments() {

        return ResponseEntity.ok(commentService.listAll());
    }
}
