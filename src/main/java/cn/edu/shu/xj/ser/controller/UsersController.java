package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Service;
import cn.edu.shu.xj.ser.entity.Serviceprovider;
import cn.edu.shu.xj.ser.entity.Users;
import cn.edu.shu.xj.ser.service.IUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "UsersInterface")
@RequestMapping("/users")
@RestController
public class UsersController {

    @Autowired
    IUsersService usersService;

    @ApiOperation(value = "user_login")
    @PostMapping("/login")
    public String Userlogin(@RequestParam(value = "user_id")String uid, @RequestParam(value = "user_pwd")String upd){
        Users oneUser = usersService.findUserbyId(uid);
        if (oneUser==null) return null;
        else{
            if(oneUser.getUserPwd().equals(upd)) return uid ;
            else return "wrong pwd!";
        }
    }

    @ApiOperation(value = "user_changeinfo")
    @PostMapping("/save")
    public boolean save(@RequestBody Users users){
        return usersService.saveOrUpdate(users);
    }

    @ApiOperation(value = "user_register")
    @PostMapping("/register")
    public boolean register(@RequestBody Users users){
        Users oneUser = usersService.findUserbyId(users.getUserId());
        if(oneUser!=null) return false;
        else return usersService.saveOrUpdate(users);
    }

}
