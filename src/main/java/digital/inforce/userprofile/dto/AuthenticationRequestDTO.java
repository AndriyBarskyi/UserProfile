package digital.inforce.userprofile.dto;

import javax.validation.constraints.NotNull;

import digital.inforce.userprofile.validator.PasswordConstraint;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDTO {
    @NotNull
    @Email
    private String email;

    @NotNull
    @PasswordConstraint
    private String password;
}
