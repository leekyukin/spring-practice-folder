package com.kyukin.usermenagement1.dto;

import com.kyukin.usermenagement1.code.StatusCode;
import com.kyukin.usermenagement1.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEditDto {

    private String name;
    private String nickName;
    private Integer age;
    //private SimpleDateFormat birthday;
    private String mbti;
    private StatusCode statusCode;

    public static UserEditDto fromEntity(User user) {
        return UserEditDto.builder()
                .nickName(user.getNickName())
                .name(user.getName())
                //.birthday(user.getBirthday())
                .age(user.getAge())
                .mbti(user.getMbti())
                .statusCode(user.getStatusCode())
                .build();
    }
}
