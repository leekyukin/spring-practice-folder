package com.kyukin.usermenagement1.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {
    RESIGNED("탈퇴"),
    JOINED("가입")
    ;

    private final String description;
}
