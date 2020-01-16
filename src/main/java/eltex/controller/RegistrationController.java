package eltex.controller;

import eltex.entity.Role;
import eltex.entity.User;
import eltex.repository.UserRepository;
import eltex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.net.UnknownServiceException;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Котроллер для регестрации
 *
 * @author "Alexey Derevtsov"
 * @version 1.0.0
 */

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        // Проверка на сходство введенных паролей
        if (!user.getPassword().equals(user.getConfirmPassword())){
            model.put("message", "Passwords isn't equals!");
            return "registration";
        }

        if (userFromDb != null) {
            model.put("message", "Person exists!");
            return "registration";
        }

        userService.registNewUser(user);

        return "redirect:/login";
    }


}
