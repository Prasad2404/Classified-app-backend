package com.test.controller;

import com.test.model.Role;
import com.test.model.User;
import com.test.model.UserRole;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class RootController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
