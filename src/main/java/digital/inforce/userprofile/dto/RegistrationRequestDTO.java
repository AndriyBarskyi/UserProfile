package digital.inforce.userprofile.dto;

import javax.validation.constraints.NotNull;

import digital.inforce.userprofile.model.Role;
import digital.inforce.userprofile.validator.AddressConstraint;
import digital.inforce.userprofile.validator.NameConstraint;
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
public class RegistrationRequestDTO {
    @NotNull
    @NameConstraint
    private String firstName;

    @NotNull
    @NameConstraint
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @AddressConstraint
    private String address;

    @NotNull
    @PasswordConstraint
    private String password;

    @NotNull
    @PasswordConstraint
    private String repeatPassword;

    @NotNull
    private Role role;
}