package com.example.team2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class User {
    private int userid;
    private String name;
    private String avatar;
    private String email;
    private String country;
    private String address;
    private String phone;
}
