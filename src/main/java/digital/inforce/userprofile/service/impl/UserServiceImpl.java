package digital.inforce.userprofile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.inforce.userprofile.dto.UserDTO;
import digital.inforce.userprofile.dto.UserNameDTO;
import digital.inforce.userprofile.dto.UserSaveDTO;
import digital.inforce.userprofile.exception.EntityNotExistsException;
import digital.inforce.userprofile.mapper.UserMapper;
import digital.inforce.userprofile.model.User;
import digital.inforce.userprofile.repository.UserRepository;
import digital.inforce.userprofile.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
        UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userMapper.entityToDto(userRepository.findByEmail(email)
            .orElseThrow(EntityNotExistsException::new));
    }

    @Override
    public UserSaveDTO updateUser(String id, UserSaveDTO userSaveDTO) {
        return userRepository.findById(id)
            .map(user -> userMapper.entityToSaveDto(
                updateUser(user, userSaveDTO)))
            .orElseThrow(EntityNotExistsException::new);
    }

    @Override public UserNameDTO getUserNameById(String id) {
        return userRepository.findById(id).map(userMapper::entityToNameDto)
            .orElseThrow(EntityNotExistsException::new);
    }

    @Override public List<UserDTO> getAllUsers() {
        return userMapper.entitiesToDtos(userRepository.findAll());
    }

    User updateUser(User user, UserSaveDTO userSaveDTO) {
        if (userSaveDTO.getFirstName() != null && !userSaveDTO.getFirstName()
            .isBlank()) {
            user.setFirstName(userSaveDTO.getFirstName());
        }
        if (userSaveDTO.getEmail() != null && !userSaveDTO.getEmail()
            .isBlank()) {
            user.setEmail(userSaveDTO.getEmail());
        }
        if (userSaveDTO.getLastName() != null && !userSaveDTO.getLastName()
            .isBlank()) {
            user.setLastName(userSaveDTO.getLastName());
        }
        if (userSaveDTO.getAddress() != null
            && !userSaveDTO.getAddress().isBlank()) {
            user.setAddress(userSaveDTO.getAddress());
        }
        return userRepository.save(user);
    }
}
