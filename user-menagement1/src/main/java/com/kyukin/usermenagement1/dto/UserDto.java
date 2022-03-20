package com.kyukin.usermenagement1.dto;

import com.kyukin.usermenagement1.code.StatusCode;
import com.kyukin.usermenagement1.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserDto {
    private String name;
    private String phoneNumber;
    private String nickName;
    private StatusCode statusCode;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .name(user.getName())
                .statusCode(user.getStatusCode())
                .phoneNumber(user.getPhoneNumber())
                .nickName(user.getNickName())
                .build();
    }
}
