package cn.edu.bupt.controller;

import cn.edu.bupt.domain.User;
import cn.edu.bupt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by PD on 2017/5/3.
 */

@RestController
public class UserController {

    private final UserService userService;
    private User user;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User createUser(@RequestBody @Valid final User user) {
        this.user = userService.save(user);
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser() {
        return user;
    }

}
