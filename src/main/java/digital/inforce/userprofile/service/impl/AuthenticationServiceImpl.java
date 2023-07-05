package digital.inforce.userprofile.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import digital.inforce.userprofile.dto.AuthenticationRequestDTO;
import digital.inforce.userprofile.dto.AuthenticationResponseDTO;
import digital.inforce.userprofile.dto.RegistrationRequestDTO;
import digital.inforce.userprofile.exception.EmailAlreadyTakenException;
import digital.inforce.userprofile.mapper.UserMapper;
import digital.inforce.userprofile.model.Role;
import digital.inforce.userprofile.model.User;
import digital.inforce.userprofile.repository.UserRepository;
import digital.inforce.userprofile.security.PasswordConfig;
import digital.inforce.userprofile.service.AuthenticationService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String EMAIL_ALREADY_TAKEN = "Email already taken: ";

    public final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordConfig passwordConfig;

    @Override
    public AuthenticationResponseDTO register(@NotNull RegistrationRequestDTO request) {
        request.setRole(Role.USER);
        User user = userMapper.registrationRequestDTOtoEntity(request);
        String encodedPassword = passwordConfig.passwordEncoder()
                .encode(request.getPassword());
        user.setPassword(encodedPassword);
        boolean userExists = userRepository
                .findByEmail(request.getEmail())
                .isPresent();

        if (userExists) {
            throw new EmailAlreadyTakenException(
                    EMAIL_ALREADY_TAKEN + request.getEmail(), request);
        }
        userRepository.save(user);
        var jwtToken =
                jwtService.generateToken(userMapper.registrationRequestDTOtoEntity(request));
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .isAuth(false)
                .build();
    }

    @Override
    public AuthenticationResponseDTO authenticate(
            AuthenticationRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken =
                jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .isAuth(true)
                .build();
    }
}