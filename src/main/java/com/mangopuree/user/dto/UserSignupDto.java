package com.mangopuree.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String telNo;

    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String faxNo;

    public boolean isPasswordMatching() {
        return password.equals(confirmPassword);
    }
}
