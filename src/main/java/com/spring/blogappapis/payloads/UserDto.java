package com.spring.blogappapis.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    @NotEmpty
    @Size(min = 4,message = "Username must be min of 4 characters")
    private String name;
    @Email(message = "Email address is not valid !!")
    private String email;

    @NotEmpty
    @Size(min = 3,max = 10,message = "Password must be min of 3 chars and max of 10 chars !!")
    private String password;

    @NotEmpty
    private String about;
}
