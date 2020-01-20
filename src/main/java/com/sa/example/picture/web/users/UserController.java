package com.sa.example.picture.web.users;


import com.sa.example.picture.domain.data.User;
import com.sa.example.picture.user.service.SecurityService;
import com.sa.example.picture.user.service.UserService;
import com.sa.example.picture.user.service.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private final UserService userService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);


        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        if(userForm.getUsername().equals("bander")){

            return "redirect:/thymeleaf/admin";
        }
        else {
            return "redirect:/upload";
        }
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/upload"})
    public String upload(Model model) {
        return "upload";
    }

    @RequestMapping("/home")
    public String index(Model model){

        return "thymeleaf/index";
    }
    @RequestMapping("/admin")
    public String admin(Model model){

        return "thymeleaf/admin";
    }
    @RequestMapping("/test")
    public String test(Model model){

        return "thymeleaf/test";
    }

}