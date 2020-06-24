package com.example.team2.controller;

import com.example.team2.model.User;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("login/account")
    public JSONObject login(@RequestBody(required = false) LoginParams params) {

        if (params == null || params.userName == null) {
            return null;
        }

        String password = params.password;
        String userName = params.userName;
        Map newAcc = new HashMap();

        if (password.equals("ant.design") && userName.equals("admin")) {
            newAcc.put("status", "ok");
            newAcc.put("currentAuthority", "admin");

            return new JSONObject(newAcc);
        }

        if (password.equals("ant.design") && userName.equals("user")) {
            newAcc.put("status", "ok");
            newAcc.put("currentAuthority", "admin");

            return new JSONObject(newAcc);
        }

        return null;
    }

    @GetMapping("/currentUser")
    public User getCurrentUser() {
        return new User(
                1,
                "Sơn kute",
                "https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png",
                "",
                "",
                "",
                ""
        );
    }
}
