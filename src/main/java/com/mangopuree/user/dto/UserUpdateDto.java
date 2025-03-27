package com.mangopuree.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    private Long userId;
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String telNo;

    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String faxNo;

}
