package net.togogo.blogjpathymeleaf.controller;

import net.togogo.blogjpathymeleaf.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ling
 * @date 2018/9/20  20:47
 * @function:
 */
@Controller
public class MainController {


    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(User user){

        if("ling".equals(user.getUsername()) && "123".equals(user.getPassword()))
        {
            return new ModelAndView("redirect:/users");
        }
        else{
            return new ModelAndView("redirect:/register");
        }

    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
