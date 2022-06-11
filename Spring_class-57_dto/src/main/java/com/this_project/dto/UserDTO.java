package com.this_project.dto;

import com.this_project.entity.User;
import lombok.Data;

import java.util.Collections;
import java.util.List;
@Data
public class UserDTO {
    private Long id;

    private String name;

    private String password;

    private String email;

    private String location;
}
