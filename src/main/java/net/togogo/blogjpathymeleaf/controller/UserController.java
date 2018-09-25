package net.togogo.blogjpathymeleaf.controller;

import net.togogo.blogjpathymeleaf.bean.User;
import net.togogo.blogjpathymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ling
 * @date 2018/9/19  14:35
 * @function:
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    private ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return new ModelAndView("/users/list", "userModel", model);
    }

    @GetMapping("/form")
    private ModelAndView createUser(Model model) {
        model.addAttribute("user", new User(null,null,null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    @PostMapping
    private ModelAndView saveOrUpdate(User user){
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping
    private ModelAndView index(){
        return new ModelAndView("redirect:/users/list");
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable Long id, Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户信息");
        return new ModelAndView("users/view","userModel",model);

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users");
    }


    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable Long id,Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户信息");
        return new ModelAndView("users/form","userModel",model);
    }

}
