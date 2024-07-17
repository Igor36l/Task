package com.naumen.task.controller;

import com.naumen.task.entity.User;
import com.naumen.task.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PutMapping("/update")
    public ResponseEntity<List<User>> updateUsers(@RequestParam Long departmentId, HttpServletRequest request) {
        User admin = (User) request.getUserPrincipal();

        if (!admin.getRole().getName().equals("ADMIN")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        List<User> updatedUsers = userService.updateUsersFromExternalService(departmentId);
        return ResponseEntity.ok(updatedUsers);
    }
}


