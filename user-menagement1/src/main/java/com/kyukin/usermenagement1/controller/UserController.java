package com.kyukin.usermenagement1.controller;

import com.kyukin.usermenagement1.dto.JoinUser;
import com.kyukin.usermenagement1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
        return userService.joinUser(request);
    }

}
