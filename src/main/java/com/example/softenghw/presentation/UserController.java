package com.example.softenghw.presentation;

import java.util.ArrayList;
import java.util.List;

import com.example.softenghw.CreateUserDto;
import com.example.softenghw.UserDto;
import com.example.softenghw.persistance.User;
import com.example.softenghw.persistance.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    //localhost:8090/users
    public ResponseEntity<List<UserDto>> getAll() {

        final  Iterable<User> users = userRepository.findAll();
        final ArrayList<UserDto> finalUsers = new ArrayList<>();

        UserDto dto;
        for (User user: users
             ) {
            dto = new UserDto();
            dto.setId(user.getId());
            dto.setUserName(user.getUserName());
            dto.setCountry(user.getCountry());
            finalUsers.add(dto);
        }
        return ResponseEntity.ok(finalUsers);
    }


    @PostMapping
    //localhost:8090/users
    public ResponseEntity<UserDto> create(@RequestBody CreateUserDto dto) {

        final User user = new User();
        user.setUserName(dto.getUserName());
        user.setCountry(dto.getCountry());

        final User savedUser = userRepository.save(user);

        final UserDto responseDto = new UserDto();

        responseDto.setId(savedUser.getId());
        responseDto.setUserName(savedUser.getUserName());
        responseDto.setCountry(savedUser.getCountry());

        return ResponseEntity.ok(responseDto);
    }


}
