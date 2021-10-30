package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CorsController {

    @RequestMapping("/hello")
    //跨網域的前端URL要串接要9090port，測試網頁cors.html要另外創一個專案9090port
    @CrossOrigin(value = "http://localhost:9090")
    @ResponseBody
    public String index( ){
        return "Hello World";
    }
}
