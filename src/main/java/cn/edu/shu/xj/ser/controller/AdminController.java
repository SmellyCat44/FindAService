package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "AdminInterface")
@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    IAdminService adminService;

    @ApiOperation(value = "admin_login")
    @PostMapping("/login")
    public int Adminlogin(@RequestParam(value = "admin_id")String aid, @RequestParam(value = "admin_pwd")String apd){
        Admin oneAdmin = adminService.findAdminbyId(aid);
        if (oneAdmin==null) return -1;
        else{
            if(oneAdmin.getAdminPwd().equals(apd)) return 1;
            else return -2;
        }
    }

}
