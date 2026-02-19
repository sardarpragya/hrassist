package com.hrassist.user_service.service;

import com.hrassist.user_service.dto.CreateUserRequestDto;
import com.hrassist.user_service.dto.UserResponseDto;
import com.hrassist.user_service.entity.UserEntity;
import com.hrassist.user_service.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers(){

        return userRepository.findAll();
    }

    public List<UserResponseDto> getAllUsersDto(){
        return userRepository.findAll()
                .stream()
//                .map(user -> new UserResponseDto(user.getId()))
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Page<UserResponseDto> getUsers(Pageable pageable){
        return userRepository.findAll(pageable)
//                .map(user -> new UserResponseDto(user.getId()));
                .map(this::mapToDto);

    }


    public UserResponseDto createUser(CreateUserRequestDto request) {

        if (userRepository.existsByUsername(request.getUsername())){
            throw new IllegalArgumentException("Username already exists");
        }
        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setMiddleName(request.getMiddleName());
        user.setRoleId(request.getRoleId());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        UserEntity saved = userRepository.save(user);
        return mapToDto(saved);

    }

    private UserResponseDto mapToDto(UserEntity user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setMiddleName(user.getMiddleName());
        dto.setRoleId(user.getRoleId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

}
