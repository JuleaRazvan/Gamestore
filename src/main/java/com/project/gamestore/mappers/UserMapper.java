package com.project.gamestore.mappers;

import org.springframework.stereotype.Component;

import com.project.gamestore.dtos.UserDTO;
import com.project.gamestore.entities.User;

@Component
public class UserMapper{

    public UserDTO mapEntityToDTO(User user){
       
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        userDTO.setPublicIdentifier(user.getPublicIdentifier());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setLastUpdatedAt(user.getLastUpdatedAt());

        return userDTO; 
    }

    public User mapDtoToEntity(UserDTO userDTO){
        
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setPublicIdentifier(userDTO.getPublicIdentifier());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setLastUpdatedAt(userDTO.getLastUpdatedAt());

        return user;
    }
}