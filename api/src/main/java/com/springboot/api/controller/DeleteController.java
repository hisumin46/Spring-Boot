package com.springboot.api.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/delete-api")

public class DeleteController {
    // http://localhost:8080/api/v1/delete-api/hisumin
    @DeleteMapping("/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
      return variable;
    }

    // http://localhost:8080/api/v1/delete-api/request1?email=value
    @DeleteMapping("/request1")
    public String getRequsetParam1(@RequestParam String email) {
      return "email = " +  email;
    }
  }
