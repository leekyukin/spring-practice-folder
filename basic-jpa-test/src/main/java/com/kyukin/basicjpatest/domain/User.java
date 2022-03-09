package com.kyukin.basicjpatest.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@EqualsAndHashCode
@ToString
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;


    private String name;
}
