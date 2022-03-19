package com.kyukin.usermenagement1.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    MAN("남성"),
    WOMAN("여성")
    ;

    private final String description;
}
