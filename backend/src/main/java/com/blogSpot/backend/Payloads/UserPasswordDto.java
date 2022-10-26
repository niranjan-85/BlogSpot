package com.blogSpot.backend.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserPasswordDto {
    private String newPassword;
}
