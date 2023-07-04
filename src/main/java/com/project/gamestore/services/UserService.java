package com.project.gamestore.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamestore.dtos.UserDTO;
import com.project.gamestore.entities.User;
import com.project.gamestore.mappers.UserMapper;
import com.project.gamestore.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

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
        User foundUser = userRepository.findByPublicIdentifier(publicIdentifier).orElseThrow();
        return userMapper.mapEntityToDTO(foundUser);
    }

    public UserDTO update(UserDTO userUpdate, UUID publicIdentifier) {
        User user = userRepository.findByPublicIdentifier(publicIdentifier).orElseThrow();
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