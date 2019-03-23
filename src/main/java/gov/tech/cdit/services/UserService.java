package gov.tech.cdit.services;

import gov.tech.cdit.repositories.UserRepository;
import gov.tech.cdit.views.UserView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private double validSalaryMax;

    private UserRepository userRepository;

    public UserService(
            @Value("${salary.valid.max}") double validSalaryMax,
            UserRepository userRepository
    ) {
        this.validSalaryMax = validSalaryMax;
        this.userRepository = userRepository;
    }

    public List<UserView> getUsersWithValidSalary() {
        return this.userRepository.findBySalaryBetween(0, validSalaryMax)
                .stream()
                .map(user -> new UserView(user.getName(), user.getSalary()))
                .collect(Collectors.toList());
    }
}
