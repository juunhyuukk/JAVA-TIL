package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController<string> {

    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            // TODO 대문자로 변환해서 RETURN
            // String 타입의 변수 외에 다른 타입 받아보기
            // boolean, integer
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        System.out.println("echo message : "+msg);
        System.out.println("echo age : "+age);
        System.out.println("echo isMan : "+isMan);
        return msg.toUpperCase();
    }

    // http:localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }

    // TODO Parameter 2가지 받기. int 형태로 받아서 두 수의 덧셈, 곱셈 진행
    // TODO String 타입 boolean 타입도 받아보기

    @GetMapping(path = "/calc/sum/{num1}/{num2}")
    public int calc(
            @PathVariable int num1,
            @PathVariable int num2
    ){
        System.out.println("두 수의 덧셈 : "+(num1+num2));

        var plus = num1+num2;
        return plus;
    }

    @GetMapping(path = "/calc/mul/{num1}/{num2}")
    public int calc2(
            @PathVariable int num1,
            @PathVariable int num2
    ){
        System.out.println("두 수의 곱셈 : "+(num1*num2));

        var mul = num1*num2;
        return mul;
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
        }
    )
    public void delete(
        @PathVariable String userName
    ){
        log.info("user-name : {}", userName);
    }
}
