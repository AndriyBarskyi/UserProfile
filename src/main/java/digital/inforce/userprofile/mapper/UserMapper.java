package digital.inforce.userprofile.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import digital.inforce.userprofile.dto.RegistrationRequestDTO;
import digital.inforce.userprofile.dto.UserDTO;
import digital.inforce.userprofile.dto.UserNameDTO;
import digital.inforce.userprofile.dto.UserSaveDTO;
import digital.inforce.userprofile.model.User;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    User dtoToEntity(UserDTO userDTO);

    UserDTO entityToDto(User user);

    User dtoSaveToEntity(UserSaveDTO userSaveDTO);

    UserSaveDTO entityToSaveDto(User user);

    User registrationRequestDTOtoEntity(RegistrationRequestDTO request);

    UserNameDTO entityToNameDto(User user);

    List<UserDTO> entitiesToDtos(List<User> all);
}