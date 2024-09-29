package com.store.storeapi.controller;

import com.store.storeapi.entity.User;
import com.store.storeapi.model.UserDto;
import com.store.storeapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<UserDto> getAllUser() {
        return userService.getUsers();
    }

    @GetMapping("/{email}")
    public UserDto getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewUser(@RequestBody UserDto dto) {
        userService.createUser(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> changeUser(@RequestBody UserDto dto, @PathVariable("id") long id) {
        UserDto userDto = userService.changeUser(dto, id);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }


}
