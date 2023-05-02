package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.entity.Service;
import cn.edu.shu.xj.ser.service.IAdminService;
import cn.edu.shu.xj.ser.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "OrderInterface")
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;

    @ApiOperation(value = "user_request")
    @PostMapping("/user_request")
    public boolean userRequest(@RequestParam(value = "user_id") String uid, @RequestParam(value = "service_id") Integer sid){
       //userid, address,date,description,service_category
        
    }

}
