package cn.edu.bupt.controller;

import cn.edu.bupt.authorization.annotation.Authorization;
import cn.edu.bupt.authorization.annotation.CurrentUser;
import cn.edu.bupt.authorization.manager.TokenManager;
import cn.edu.bupt.authorization.model.TokenModel;
import cn.edu.bupt.domain.User;
import cn.edu.bupt.model.ResultStatus;
import cn.edu.bupt.model.ResultModel;
import cn.edu.bupt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hadoop on 17-5-3.
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(@RequestParam String username, @RequestParam String password) {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");

        User user = userRepository.findByUsername(username);

        if (user == null ||
                !user.getPassword().equals(password)) {
            return  new ResponseEntity(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }

        TokenModel model = tokenManager.createToken(user.getId());
        return new ResponseEntity(ResultModel.ok(model), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Authorization
    public ResponseEntity logout(@CurrentUser User user) {
        tokenManager.deleteToken(user.getId());
        return new ResponseEntity(ResultModel.ok(), HttpStatus.OK);
    }
}
