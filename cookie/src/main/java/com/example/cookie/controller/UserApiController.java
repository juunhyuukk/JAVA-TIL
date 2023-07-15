package com.example.cookie.controller;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public UserDto me(
        HttpServletRequest httpServletRequest,

        @CookieValue(name = "authorization-cookie", required = false)
        String authorizationCookie
    ){
        log.info("authorizationCookie : {}", authorizationCookie);

        var optionalUserDto = userRepository.findByID(authorizationCookie);

        return optionalUserDto.get();
/*
        var cookies = httpServletRequest.getCookies();

        if(cookies != null){
            for(Cookie cookie : cookies){
                log.info("key : {}, value : {}", cookie.getName(), cookie.getValue());
            }
        }
*/
    }
}
