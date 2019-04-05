package gov.tech.cdit.controllers;

import gov.tech.cdit.services.UserService;
import gov.tech.cdit.views.ValidSalaryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ValidSalaryResponse getUsers() {
        return new ValidSalaryResponse(userService.getUsersWithValidSalary());
    }
}
