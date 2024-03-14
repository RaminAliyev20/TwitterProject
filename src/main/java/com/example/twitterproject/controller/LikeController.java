package com.example.twitterproject.controller;

import com.example.twitterproject.model.dto.LikeDto;
import com.example.twitterproject.model.dto.SimpleMessageDto;
import com.example.twitterproject.model.dto.requestDto.LikeRequestDto;
import com.example.twitterproject.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<LikeDto> getLikes() {
        return likeService.getLikes();
    }

    @GetMapping("/{id}")
    public LikeDto getLike(@PathVariable Long id) {
        return likeService.getLike(id);
    }

    @PostMapping
    public SimpleMessageDto addLike(@RequestBody LikeRequestDto likeRequestDto) {
        likeService.addLike(likeRequestDto);
        return new SimpleMessageDto("Successfully added!");
    }

    @PutMapping("/{id}")
    public SimpleMessageDto updateLike(@PathVariable Long id, @RequestBody LikeRequestDto likeRequestDto) {
        likeService.updateLike(id, likeRequestDto);
        return new SimpleMessageDto("Successfully updated!");
    }

    @DeleteMapping("/{id}")
    public SimpleMessageDto deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
        return new SimpleMessageDto("Successfully deleted!");
    }
}
