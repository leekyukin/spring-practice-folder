package com.kyukin.usermenagement1.controller;

import com.kyukin.usermenagement1.dto.JoinUser;
import com.kyukin.usermenagement1.dto.UserDto;
import com.kyukin.usermenagement1.dto.UserEditDto;
import com.kyukin.usermenagement1.entity.User;
import com.kyukin.usermenagement1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.rmi.server.LogStream.log;

@Slf4j
@ToString
@RequiredArgsConstructor
@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/join-user")
    public JoinUser.Response joinUser(
            @Valid @RequestBody JoinUser.Request request
    ) {
        log.info("회원가입 요청 발생");
        return userService.joinUser(request);
    }

    @GetMapping("/user-list")
    public List<UserDto> userList() {

        log.info("유저 리스트 요청 발생");
        return userService.userList();
    }

    @PutMapping("/edit-user")
    public UserEditDto editUserInfo(
            @RequestBody UserEditDto userEditDto
    ) {
        log.info("회원 정보 수정 요청");

        User user = userService.editUserInfo(userEditDto);

        return UserEditDto.fromEntity(user);
    }

}
