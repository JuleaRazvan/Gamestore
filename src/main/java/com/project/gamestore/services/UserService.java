package com.project.gamestore.services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.project.gamestore.dtos.GameDTO;
import com.project.gamestore.dtos.UserDTO;
import com.project.gamestore.entities.User;
import com.project.gamestore.mappers.GameMapper;
import com.project.gamestore.mappers.UserMapper;
import com.project.gamestore.repositories.UserGameRepository;
import com.project.gamestore.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    private UserGameRepository userGameRepository;

    private GameMapper gameMapper;

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.mapDtoToEntity(userDTO);
        User createdUser = userRepository.save(user);
        log.info("Created user entity with public identifier {}", createdUser.getPublicIdentifier());
        return userMapper.mapEntityToDTO(createdUser);
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.mapEntityToDTO(user))
                .toList();
    }

    public UserDTO getByPublicIdentifier(UUID publicIdentifier) {
        User foundUser = userRepository.findByPublicIdentifierMandatory(publicIdentifier);
        return userMapper.mapEntityToDTO(foundUser);
    }

    public List<GameDTO> getAllGamesByUserOwner(UUID userPublicIdentifier) {
        return userGameRepository.findAllByUser_PublicIdentifier(userPublicIdentifier).stream()
                .map(userGame -> userGame.getGame())
                .map(game -> gameMapper.mapEntityToDTO(game))
                .toList();
    }

    public UserDTO update(UserDTO userUpdate, UUID publicIdentifier) {
        User updateUser = userRepository.findByPublicIdentifierMandatory(publicIdentifier);
        updateUser.setName(userUpdate.getName());
        updateUser.setEmail(userUpdate.getEmail());
        updateUser.setRole(userUpdate.getRole());
        updateUser = userRepository.save(updateUser);

        log.info("Updated user with public identifier {}", updateUser.getPublicIdentifier());
        return userMapper.mapEntityToDTO(updateUser);
    }

    @Transactional
    public void delete(UUID publicIdentifier) {
        userRepository.deleteByPublicIdentifier(publicIdentifier);
        log.info("Deleted user with public identifier {}", publicIdentifier);
    }
}