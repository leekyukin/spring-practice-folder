package com.kyukin.usermenagement1.service;

import com.kyukin.usermenagement1.code.StatusCode;
import com.kyukin.usermenagement1.dto.JoinUser;
import com.kyukin.usermenagement1.entity.User;
import com.kyukin.usermenagement1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;


    @Transactional
    public JoinUser.Response joinUser(JoinUser.Request request) {

        User user = User.builder()
                .age(request.getAge())
                .birthday(null)
                .career(null)
                .gender(request.getGender())
                .email(request.getEmail())
                .name(request.getName())
                .nickName(request.getNickName())
                .mbti(null)
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .statusCode(StatusCode.JOINED)
                .build();

        userRepository.save(user);
        return JoinUser.Response.formEntity(user);
    }
}
