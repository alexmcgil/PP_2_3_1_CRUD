package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.models.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }

    @GetMapping("/{id}")
    public String singleUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));

        return "/single";
    }

    @GetMapping("/create")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));

        return "/edit";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {

        userService.addUser(user);

        return "redirect:/users";
    }

    @PatchMapping()
    public String update(@ModelAttribute("user") User user) {

        userService.updateUser(user);

        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUser(id);

        return "redirect:/users";
    }
}
