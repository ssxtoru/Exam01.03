package com.jdbc.exam.service.impl;

import com.jdbc.exam.dto.CreateUserDto;
import com.jdbc.exam.dto.UserDto;
import com.jdbc.exam.entity.User;
import com.jdbc.exam.repo.UserRepo;
import com.jdbc.exam.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;


    @Override
    public CreateUserDto create(CreateUserDto userToCreate) throws RuntimeException{
        User user = User.builder()
                .name(userToCreate.getName())
                .surname(userToCreate.getSurname())
                .build();
        try{
            userRepo.save(user);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return userToCreate;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepo.findAll();

        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : users){
            UserDto userDto = UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .surname(user.getSurname())
                    .build();
            userDtoList.add(userDto);

        }
        return userDtoList;
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Users id not found"));
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .build();

        return userDto;
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }
}
