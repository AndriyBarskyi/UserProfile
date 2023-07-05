package digital.inforce.userprofile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import digital.inforce.userprofile.dto.UserDTO;
import digital.inforce.userprofile.dto.UserNameDTO;
import digital.inforce.userprofile.dto.UserSaveDTO;

@Service
public interface UserService {

    UserDTO getUserByEmail(String email);

    UserSaveDTO updateUser(String id, UserSaveDTO userSaveDTO);

    UserNameDTO getUserNameById(String id);

    List<UserDTO> getAllUsers();
}
