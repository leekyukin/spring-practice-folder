package com.kyukin.usermenagement1.service;

import com.kyukin.usermenagement1.code.StatusCode;
import com.kyukin.usermenagement1.dto.JoinUser;
import com.kyukin.usermenagement1.dto.UserDto;
import com.kyukin.usermenagement1.dto.UserEditDto;
import com.kyukin.usermenagement1.entity.User;
import com.kyukin.usermenagement1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public List<UserDto> userList() {

        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<UserDto> ();

        for(User user : users) {
            userDtos.add(UserDto.fromEntity(user));
        }
        return userDtos;
    }


    @Transactional
    public User editUserInfo(UserEditDto userEditDto) {
        User user = userRepository.findByNickName(userEditDto.getNickName());



        User result = user.builder()
                .age(userEditDto.getAge())
                .mbti(userEditDto.getMbti())
                .name(userEditDto.getName())
                //.birthday(userEditDto.getBirthday())
                .statusCode(userEditDto.getStatusCode())
                .build();
        userRepository.deleteById(user.getId());
        userRepository.save(result);

        return result;
    }


}
