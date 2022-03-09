package com.kyukin.basicjpatest.repository;

import com.kyukin.basicjpatest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByName(String tom);

    Optional<List<User>> findAllByName(String tom);
}
