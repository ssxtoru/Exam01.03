package com.jdbc.exam.controller;

import com.jdbc.exam.dto.UserDto;
import com.jdbc.exam.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users/")
public class UserController {
    private final UserServiceImpl service;

    @PostMapping("create")
    public UserDto create(UserDto userToCreate){
        return service.createUser(userToCreate);
    }

    @GetMapping("findAll")
    public List<UserDto> getAll(){
        return service.getAll();
    }

    @GetMapping("findById/{id}")
    public UserDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("delete")
    public void deleteById(@RequestParam Long id){
        service.deleteById(id);
    }
}
