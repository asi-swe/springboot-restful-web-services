package com.sametibis.springbootrestfulwebservices.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;


    @NotNull(message = "First Name cannot be null")
    @NotEmpty(message = "First Name cannot be empty")
    @NotBlank(message = "First Name cannot be blank")
    @Size(max = 10, message = "First Name can not have more than 10 char!")
    private String firstName;

    private String lastName;

    @NotNull(message = "Email can not be null!")
    @Email(message = "Invalid email")
    private String email;
}
