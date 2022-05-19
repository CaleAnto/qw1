package kz.narxoz.argo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String account(Model model){
        return "login";
    }

    @GetMapping("/success")
    public String success() {
        return "redirect:/book";
    }

    @GetMapping("/error")
    public String error() {
        return "redirect:/book";
    }

}
