package com.kyukin.usermenagement1.dto;

import com.kyukin.usermenagement1.code.Gender;
import com.kyukin.usermenagement1.entity.User;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

public class JoinUser {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        @NotNull
        @Size(min = 2, max = 50, message = "NickName size must 2~30")
        private String nickName;

        @NotNull
        @Size(min = 2, max = 50, message = "Name size must 2~30")
        private String name;


        @NotNull
        private String email;

        @NotNull
        private String password;

        @NotNull
        @Min(8)
        @Max(99)
        private Integer age;

        @NotNull
        @Length(min = 11, max = 13)
        private String phoneNumber;

        @NotNull
        private Gender gender;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private String nickName;
        private Gender gender;
        private Integer age;
        private String email;

        public static Response formEntity(User user) {
            return Response.builder()
                    .nickName(user.getNickName())
                    .age(user.getAge())
                    .email(user.getEmail())
                    .gender(user.getGender())
                    .build()
                    ;
        }
    }
}
