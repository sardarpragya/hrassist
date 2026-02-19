package com.hrassist.user_service.controller;

import com.hrassist.user_service.dto.CreateUserRequestDto;
import com.hrassist.user_service.dto.UserResponseDto;
//import com.hrassist.user_service.entity.UserEntity;
import com.hrassist.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){

        this.userService = userService;
    }

//    @GetMapping
//    public List<UserEntity> getAllUsers(){
//        return userService.getAllUsers();
//    }

//    @GetMapping
//    public List<UserResponseDto> getAllUsers(){
//        return userService.getAllUsersDto();
//    }

    @GetMapping
    public Page<UserResponseDto> getUsers(Pageable pageable){

        return userService.getUsers(pageable);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @Valid @RequestBody CreateUserRequestDto request){
        UserResponseDto created = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}
