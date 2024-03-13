package com.example.twitterproject.controller;

import com.example.twitterproject.model.dto.SimpleMessageDto;
import com.example.twitterproject.model.dto.TwitDto;
import com.example.twitterproject.model.dto.requestDto.TwitRequestDto;
import com.example.twitterproject.service.TwitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/twits")
public class TwitController {
    private final TwitService twitService;

    public TwitController(TwitService twitService) {
        this.twitService = twitService;
    }

    @GetMapping
    public List<TwitDto> getTwits() {
        return twitService.getTwits();
    }

    @PostMapping
    public SimpleMessageDto addTwit(@RequestBody TwitRequestDto twitRequestDto) {
        twitService.addTwit(twitRequestDto);
        return new SimpleMessageDto("Successfully added");
    }

    @GetMapping("/{id}")
    public TwitDto getTwit(@PathVariable Long id){
        return twitService.getTwit(id);
    }

    @PutMapping("/{id}")
    public SimpleMessageDto updateTwit(@PathVariable Long id, @RequestBody TwitRequestDto twitRequestDto){
        twitService.updateTwit(id, twitRequestDto);
        return new SimpleMessageDto("Successfully updated!");
    }

    @DeleteMapping("/{id}")
    public SimpleMessageDto deleteTwit(@PathVariable Long id){
        twitService.deleteTwit(id);
        return new SimpleMessageDto("Successfully deleted!");
    }
}
