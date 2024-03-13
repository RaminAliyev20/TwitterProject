package com.example.twitterproject.controller;

import com.example.twitterproject.model.dto.CommentDto;
import com.example.twitterproject.model.dto.SimpleMessageDto;
import com.example.twitterproject.model.dto.requestDto.CommentRequestDto;
import com.example.twitterproject.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDto> getComments() {
        return commentService.getComments();
    }

    @GetMapping("/{id}")
    public CommentDto getComment(@PathVariable Long id) {
        return commentService.getComment(id);
    }

    @PostMapping
    public SimpleMessageDto addComment(@RequestBody CommentRequestDto commentRequestDto) {
        commentService.addComment(commentRequestDto);
        return new SimpleMessageDto("Successfully added!");
    }

    @PutMapping("/{id}")
    public SimpleMessageDto updateComment(@PathVariable Long id
            , @RequestBody CommentRequestDto commentRequestDto) {
        commentService.updateComment(id, commentRequestDto);
        return new SimpleMessageDto("Successfully updated!");
    }

    @DeleteMapping("/{id}")
    public SimpleMessageDto deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new SimpleMessageDto("Successfully deleted!");
    }
}
