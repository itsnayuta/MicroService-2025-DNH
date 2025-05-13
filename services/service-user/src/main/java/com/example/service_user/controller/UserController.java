package com.example.service_user.controller;

import com.example.service_user.dto.UserDTO;
import com.example.service_user.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.service_user.service.UserService;
import com.example.service_user.util.JWTUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    //login he he he
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody UserDTO userDTO) {
        String token = userService.login(userDTO.getUsername(), userDTO.getPassword());
        if (token != null) {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid username or password"));
        }
    }



    //get infor user
    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        String username = JWTUtils.extractUsername(token.substring(7));

        User userextract = userService.findByUsername(username);

        if(userextract != null) {
            Map<String, String> dataUserResposne = new HashMap<>();
            dataUserResposne.put("username", userextract.getUsername());
            dataUserResposne.put("email", userextract.getEmail());
            dataUserResposne.put("role", userextract.getRole());

            return ResponseEntity.status(HttpStatus.OK).body(dataUserResposne);
        }

        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND USER");
        }

    }


    //register only for admin
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO,HttpServletRequest request) {


        String token = request.getHeader("Authorization");



        String roleuser = JWTUtils.extractRole(token.substring(7));

        if(roleuser.equals("ADMIN")) {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setRole(userDTO.getRole());
            userService.register(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }

        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOW");
        }
    }

    //get list user only for admin
    @GetMapping
    public ResponseEntity<?> getAllUsers(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        String roleuser = JWTUtils.extractRole(token.substring(7));
        if (roleuser.equals("ADMIN")) {
            return  ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
        }
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOW");
        }

    }

    //delete user only for admin
    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username,HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        String roleuser = JWTUtils.extractRole(token.substring(7));
        if (roleuser.equals("ADMIN")) {
            if(userService.deleteUser(username)) {
                return  ResponseEntity.status(HttpStatus.OK).body("DELETED USER SUCCESSFULLY");
            }
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND");
        }
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOW");
        }

    }

}
