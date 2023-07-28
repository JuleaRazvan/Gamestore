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

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    private UserGameRepository userGameRepository;

    private GameMapper gameMapper;

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.mapDtoToEntity(userDTO);
        User createdUser = userRepository.save(user);
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
        User user = userRepository.findByPublicIdentifierMandatory(publicIdentifier);
        user.setName(userUpdate.getName());
        user.setEmail(userUpdate.getEmail());
        user.setRole(userUpdate.getRole());
        user = userRepository.save(user);

        return userMapper.mapEntityToDTO(user);
    }

    @Transactional
    public void delete(UUID publicIdentifier) {
        userRepository.deleteByPublicIdentifier(publicIdentifier);
    }

}