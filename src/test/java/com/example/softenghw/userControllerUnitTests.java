package com.example.softenghw;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.softenghw.presentation.UserController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import com.example.softenghw.persistance.User;
import com.example.softenghw.persistance.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class userControllerUnitTests {


    private UserController userController;


    @Test
    void testUserCreation(){
        userController = new UserController(new UserRepository(){
            public <T extends User> T save(final T entity){
                entity.setId(10L);
                entity.setCountry("Hayastan");
                entity.setUserName("userName1");

                return entity;

            }

            @Override
            public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<User> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<User> findAll() {
                return null;
            }

            @Override
            public Iterable<User> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(User entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> entities) {

            }

            @Override
            public void deleteAll() {

            }


        });

        final ResponseEntity<UserDto> createdUser = userController.create(new CreateUserDto());

        Assertions.assertThat(createdUser.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(createdUser.getBody().getId()).isNotNull().isEqualTo(10L);
        Assertions.assertThat(createdUser.getBody().getCountry()).isEqualTo("Hayastan");
        Assertions.assertThat(createdUser.getBody().getUserName()).isEqualTo("userName1");

    }


    @Test
    void testAllUsersList() {
        userController = new UserController(new UserRepository(){

            @Override
            public <S extends User> S save(S entity) {
                return null;
            }

            @Override
            public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<User> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<User> findAll() {

                ArrayList<User> allUsers = new ArrayList<>();

                User user1 = new User();
                user1.setId(1L);
                user1.setUserName("user1");
                user1.setCountry("Armenia");
                allUsers.add(user1);

                User user2 = new User();
                user2.setId(2L);
                user2.setUserName("user2");
                user2.setCountry("USA");
                allUsers.add(user2);

                User user3 = new User();
                user3.setId(3L);
                user3.setUserName("user3");
                user3.setCountry("USA");
                allUsers.add(user3);

                return allUsers;

            }

            @Override
            public Iterable<User> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(User entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> entities) {

            }

            @Override
            public void deleteAll() {

            }
        });


        final ResponseEntity<List<UserDto>> allUsers =  userController.getAll();
        ArrayList<UserDto> users = (ArrayList<UserDto>) allUsers.getBody();
        UserDto user = users.get(0);

        Assertions.assertThat(allUsers.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(allUsers.getBody()).isNotNull();
        Assertions.assertThat(user.getId()).isEqualTo(1L);
        Assertions.assertThat(user.getUserName()).isEqualTo("user1");
        Assertions.assertThat(user.getCountry()).isEqualTo("Armenia");

    }




};


