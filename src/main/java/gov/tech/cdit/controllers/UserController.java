package gov.tech.cdit.controllers;

import gov.tech.cdit.services.UserService;
import gov.tech.cdit.views.UserView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserView> getUsers() {
        return this.userService.getUsersWithValidSalary();
    }
}
