package com.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.CreateUserRequestDto;
import com.Entity.User;
import com.service.UserService;

import jakarta.validation.Valid;

@ComponentScan(basePackages = "com.service")

@RestController
@Validated
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/create-user")
  public ResponseEntity<User> addUser(@Valid @RequestBody CreateUserRequestDto createUserRequest) {
    User createdUser = userService.createUser(createUserRequest);
    ResponseEntity<User> response = new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    return response;
  }

  @GetMapping("/fetch/{id}")
  public ResponseEntity<?> getUser(@PathVariable ObjectId id) {
    ResponseEntity<?> x = userService.getUser(id);
    System.out.println("Status Code: " + x.getStatusCode().value());

    // Print the headers
    System.out.println("Headers: " + x.getHeaders());

    // Print the body
    System.out.println("Body: " + x.getBody());
    return x;
  }

}
