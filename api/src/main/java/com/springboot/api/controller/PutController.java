package com.springboot.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
  // http://localhost:8080/api/v1/put-api/member
  @PutMapping(value="/member")
  public String postMember(@RequestBody Map<String, String> putData) {
    StringBuilder sb = new StringBuilder();
    putData.entrySet().forEach(map -> {
      sb.append(map.getKey() + " " + map.getValue() + "\n");
    });
    return sb.toString();
  }

  @PutMapping("/member1")
  public String postMemberDto1(@RequestBody MemberDto memberDto) {
    return memberDto.toString();
  }

  @PutMapping("/member2")
  public String postMemberDto2(@RequestBody MemberDto memberDto) {
    return memberDto;
  }

}
