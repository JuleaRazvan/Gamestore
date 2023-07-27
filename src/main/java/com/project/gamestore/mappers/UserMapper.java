package com.project.gamestore.mappers;

import org.springframework.stereotype.Component;
import com.project.gamestore.dtos.UserDTO;
import com.project.gamestore.entities.User;

@Component
public class UserMapper {

    public UserDTO mapEntityToDTO(User user) {
        return UserDTO.builder()
                .publicIdentifier(user.getPublicIdentifier())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .lastUpdatedAt(user.getLastUpdatedAt())
                .build();
    }

    public User mapDtoToEntity(UserDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .role(userDTO.getRole())
                .build();
    }
}