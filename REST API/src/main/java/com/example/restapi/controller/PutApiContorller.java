package com.example.restapi.controller;


import com.example.restapi.model.UserInfoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiContorller {

    @PutMapping("/put")
    public void put(
        @RequestBody UserInfoRequest userInfoRequest
    ){
        log.info("Request : {}", userInfoRequest);
    }

}
