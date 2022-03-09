package com.kyukin.basicjpatest.repository;

import com.kyukin.basicjpatest.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {

        List<User> userList = new ArrayList<User>();
        userList.add(new User(1L, "Tom"));
        userList.add(new User(2L, "Edward"));
        userList.add(new User(3L, "Tom1"));



        List<User> user = userRepository.saveAll(userList);



        System.out.println(user);

        System.out.println("===============");

        Optional<User> user1 = userRepository.findById(2L);
        System.out.println(user1);


        List<User> userList1 = userRepository.findAll();

        Stream<User> stream = userList1.stream();

        stream.forEach(System.out::println);

        Optional<User> tom = userRepository.findUserByName("Tom");

        System.out.println(tom);

        Optional<List<User>> toms = userRepository.findAllByName("Tom");

        long TomCount = toms.stream().count();

        if (TomCount == 0) {
            System.out.println("There is no Tom!");
        }
        else if (TomCount == 1) {
            System.out.println("There is " + TomCount + " Tom.");
        }
        else {
            System.out.println("There are " + TomCount + " Tom");
        }


    }

}