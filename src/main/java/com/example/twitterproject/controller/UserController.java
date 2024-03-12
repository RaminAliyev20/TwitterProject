package com.example.twitterproject.controller;

import com.example.twitterproject.model.dto.UserDto;
import com.example.twitterproject.model.dto.requestDto.UserRequestDto;
import com.example.twitterproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public String addUser(@RequestBody UserRequestDto userRequestDto) {
        userService.addUser(userRequestDto);
        return "Saved!";
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        userService.updateUser(id, userRequestDto);
        return "Updated!";
    }

    @DeleteMapping("/{id}")
    public String updateUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Deleted!";
    }
}
