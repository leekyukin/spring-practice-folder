package com.kujin.japfkpractice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        System.out.println("==============<<< LIST  >>>==============\n");

        userRepository.findAll().forEach(System.out::println);

        System.out.println();
        System.out.println("=========================================\n");
    }
}