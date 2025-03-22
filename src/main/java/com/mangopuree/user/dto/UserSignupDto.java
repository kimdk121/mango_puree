package com.mangopuree.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupDto {

    @NotBlank
    private String username;

    @Size(min =6)
    @NotBlank
    private String password;

    @Size(min =6)
    @NotBlank
    private String confirmPassword;

    @NotBlank
    private String name;

    public boolean isPasswordMatching() {
        return password.equals(confirmPassword);
    }
}
