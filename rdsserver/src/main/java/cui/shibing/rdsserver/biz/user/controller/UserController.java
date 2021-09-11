package cui.shibing.rdsserver.biz.user.controller;

import cui.shibing.rdsserver.biz.user.UserService;
import cui.shibing.rdsserver.biz.user.dto.CreateUserParam;
import cui.shibing.rdsserver.biz.user.dto.CreateUserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CreateUserResult createUser(@RequestBody CreateUserParam param) {
        return userService.createUser(param);
    }

}