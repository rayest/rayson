package mobi.rayson.api.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 下午4:04
 *  Description:
 **/
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam("username") String username, @RequestParam("password") String password){
        Identification identification = loginService.authenticate(username, password);
        return ResponseEntity.ok(identification);
    }
}
