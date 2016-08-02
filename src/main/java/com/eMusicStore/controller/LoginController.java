package com.eMusicStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by eccspro on 24/07/16.
 */

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam(required = false)Map<String, String>paramMap, Model model) {

        if(paramMap.containsKey("error")) {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login";
        }

        if(paramMap.containsKey("logout")) {
            model.addAttribute("logoutMessage", "You have been successfully logged out");
            return "login";
        }

        return "login";
    }
}
