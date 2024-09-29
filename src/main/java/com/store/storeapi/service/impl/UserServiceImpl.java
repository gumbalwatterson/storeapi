package com.store.storeapi.service.impl;

import com.store.storeapi.entity.User;
import com.store.storeapi.exception.UserNotFoundException;
import com.store.storeapi.model.UserDto;
import com.store.storeapi.repository.UserRepository;
import com.store.storeapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUserByEmail(String email) {
        return mapToUserDto(userRepository.findByEmail(email));
    }

    @Override
    public void createUser(UserDto dto) {
        User user = mapToUser(dto);
        userRepository.save(user);
        log.info("New user with email: {} was added to database", dto.email());
    }

    @Override
    public UserDto changeUser(UserDto dto, long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id:" + id + "not found"));
        user.setAddress(dto.address());
        user.setEmail(dto.email());
        user.setCountry(dto.country());
        user.setPassword(dto.password());
        user.setLastName(dto.lastName());
        user.setFirstName(dto.firstName());
        user.setPhoneNumber(dto.phoneNumber());
        userRepository.save(user);
        return dto;
    }

    @Override
    public void deleteUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id:" + id + "not found"));
        userRepository.delete(user);
        log.info("user with id: {} was deleted", id);
    }


    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(this::mapToUserDto).toList();
    }

    private User mapToUser(UserDto dto) {
        return User.builder()
                .password(dto.password())
                .email(dto.email())
                .lastName(dto.lastName())
                .firstName(dto.firstName())
                .phoneNumber(dto.phoneNumber())
                .address(dto.address())
                .country(dto.country())
                .build();
    }

    private UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .address(user.getAddress())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
