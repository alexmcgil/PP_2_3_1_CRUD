package su.alexmcgil.crud_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import su.alexmcgil.crud_boot.entity.User;
import su.alexmcgil.crud_boot.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String indexPage() {
        return "index";
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());

        return "users";
    }

    @GetMapping("/users/{id}")
    public String singleUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));

        return "/single";
    }

    @GetMapping("/users/create")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "/create";
    }

    @GetMapping("/users/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));

        return "/edit";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/users";
    }

    @PatchMapping("/users")
    public String update(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteById(id);

        return "redirect:/users";
    }
}
