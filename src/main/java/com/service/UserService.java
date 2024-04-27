package com.service;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DTO.CreateUserRequestDto;
import com.Entity.User;
import com.repository.UserRepository;
import com.Utils.GeneratePassword;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User createUser(CreateUserRequestDto createUserRequest) {

    User newUser = new User();
    newUser.setEmail(createUserRequest.getEmail());

    // Generate Random Password:
    GeneratePassword generator = new GeneratePassword();
    generator.setNewPassword(2, 4, 1, 1);
    String password = generator.getNewPassword();

    newUser.setUsername(createUserRequest.getUsername());
    newUser.setName(createUserRequest.getName());
    newUser.setGender(createUserRequest.getGender());
    newUser.setAddress(createUserRequest.getAddress());
    newUser.setDob(createUserRequest.getDob());
    newUser.setRole(createUserRequest.getRole());
    newUser.setPassword(password);

    User dbResponse = userRepository.save(newUser);

    return dbResponse;
  }

  public ResponseEntity<?> getUser(ObjectId id) {
    try {
      if (id == null)
        throw new IllegalArgumentException("ID cannot be null");

      Optional<User> userOptional = userRepository.findById(id);
      if (userOptional.isPresent()) {
        return ResponseEntity.ok(userOptional.get());
      } else {
        Map<String, String> response = new HashMap<>();
        response.put("success:", "true");
        response.put("message", "User not found!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
      }
    } catch (IllegalArgumentException e) {
      Map<String, String> errorResponse = new HashMap<>();
      errorResponse.put("success:", "false");
      errorResponse.put("error", e.getMessage());
      return ResponseEntity.badRequest().body(errorResponse);
    }
  }

}
