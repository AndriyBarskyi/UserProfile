package digital.inforce.userprofile.exception;

import digital.inforce.userprofile.dto.RegistrationRequestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailAlreadyTakenException extends IllegalStateException {
    private static final String EMAIL_ALREADY_TAKEN = "email already taken";
    private RegistrationRequestDTO registrationRequestDTO;

    public EmailAlreadyTakenException(String message, RegistrationRequestDTO registrationRequestDTO) {
        super(message.isEmpty() ? EMAIL_ALREADY_TAKEN : message);
        this.registrationRequestDTO = registrationRequestDTO;
    }

    public EmailAlreadyTakenException() {
        super(EMAIL_ALREADY_TAKEN);
    }

}
