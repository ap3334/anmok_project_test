package com.lion.youranmok.homepage.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage")
public class HomePageController {

    @GetMapping("/homepage")
    public String homepage() {

        return "homepage/main";

    }

}
