package com.store.storeapi.service;

import com.store.storeapi.entity.User;
import com.store.storeapi.model.UserDto;

import java.util.List;


public interface UserService {
    List<UserDto> getUsers();
    UserDto getUserByEmail(String email);
    UserDto getUserDetailsById(long id);
    void createUser(UserDto dto);

    UserDto changeUser(UserDto dto, long id);

    void deleteUser(long id);
}
