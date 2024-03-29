package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.processing.Generated;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private String last_name;

    public User(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
    }
}
