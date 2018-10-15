package com.example.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping(value = "/login.do")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,Model model) {
        if (error != null) {
            model.addAttribute("msg", "用户名或密码错误！");
        }
        if (logout != null) {
            model.addAttribute("msg", "成功退出！");
        }
        return "user/login";
    }
}
