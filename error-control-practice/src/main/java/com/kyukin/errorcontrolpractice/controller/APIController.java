package com.kyukin.errorcontrolpractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIController {

    @GetMapping("/list")
    public List<String> getList() {
        return List.of("leekyukin", "leeharin", "sungjieon", "leesangjun");
    }

    @GetMapping("/{whatever}")
    public String getWhatever(@PathVariable String whatever) {
        return whatever + " -> " + "Is this whatever you want?";
    }

    @GetMapping("/{n1}/{n2}/{operator}")
    public Integer calculator(
            @PathVariable Integer n1,
            @PathVariable Integer n2,
            @PathVariable char operator
    ) {
        return operator == '+' ?
                n1 + n2 :
                operator == '-' ?
                        n1 - n2 :
                        operator == '*' ?
                                n1 * n2 :
                                n1 / n2;
    }
}
