package P_P_312.controller;

import P_P_312.Service.UserService;
import P_P_312.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getTemplateForPrintAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.findAll());
        return "user-list";
    }

    @GetMapping(value = "/user-create")
    public String getTemplateForCreateUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "user-create";
    }


    @GetMapping("/user-update/{id}")
    public String getTemplateForUpdatingUser(ModelMap modelMap, @PathVariable("id") Long id) {
        User user = userService.findById(id);
        modelMap.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping ("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}