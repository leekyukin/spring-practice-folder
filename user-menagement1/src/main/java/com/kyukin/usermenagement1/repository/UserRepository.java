package com.kyukin.usermenagement1.repository;

import com.kyukin.usermenagement1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNickName(String nickName);
}
