package dev.nar.projectrackr.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterRequest {

    private String firstname;

    private String lastname;

    private String email;

    private String password;
}
