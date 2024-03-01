package com.jdbc.exam.service;

import com.jdbc.exam.dto.UserDto;
import com.jdbc.exam.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser (UserDto userDto);
    List<UserDto> getAll();
    UserDto getById(Long id);
    void deleteById(Long id);
}
