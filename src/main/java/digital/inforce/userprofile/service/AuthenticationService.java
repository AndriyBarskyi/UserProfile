package digital.inforce.userprofile.service;


import digital.inforce.userprofile.dto.AuthenticationRequestDTO;
import digital.inforce.userprofile.dto.AuthenticationResponseDTO;
import digital.inforce.userprofile.dto.RegistrationRequestDTO;

public interface AuthenticationService {
    AuthenticationResponseDTO register(RegistrationRequestDTO request);

    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
}
