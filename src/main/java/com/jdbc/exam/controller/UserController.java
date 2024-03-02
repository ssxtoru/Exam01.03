package com.jdbc.exam.controller;

import com.jdbc.exam.dto.CreateUserDto;
import com.jdbc.exam.dto.UserDto;
import com.jdbc.exam.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users/")
public class UserController {
    private final UserServiceImpl service;

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "User has been created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateUserDto.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed to add user to database")
    })
    @Operation(summary = "This road creates user")
    @PostMapping("create")
    public ResponseEntity<CreateUserDto> create(@RequestBody CreateUserDto userToCreate){
        try {
            return new ResponseEntity<>(service.create(userToCreate), HttpStatus.CREATED);
        }catch (RuntimeException runtimeException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
