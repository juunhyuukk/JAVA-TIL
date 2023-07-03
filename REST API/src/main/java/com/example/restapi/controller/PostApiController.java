package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserInfoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public String post(
        @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }

    @PostMapping("/userinfo")
    public String userinfo(
        @RequestBody UserInfoRequest userInfoRequest
    ){
        System.out.println(userInfoRequest);
        return userInfoRequest.toString();
    }

}
