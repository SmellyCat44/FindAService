package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.entity.Service;
import cn.edu.shu.xj.ser.service.IAdminService;
import cn.edu.shu.xj.ser.service.IOrderService;
import cn.edu.shu.xj.ser.service.IServiceService;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "OrderInterface")
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;
    IServiceService serviceService;

    @ApiOperation(value = "user_request")
    @PostMapping("/user_request")
    public boolean userRequest(@RequestParam(value = "user_id") String uid, @RequestParam(value = "service_id") Integer sid, @RequestParam(value = "detail_time")String dt, @RequestParam(value = "detail_add")String da){
        Service oneService = serviceService.searchById(sid);
        if(oneService == null) return false;
        return orderService.userRequest(uid,sid,dt,da);
    }

    @ApiOperation(value = "request_list_for_provider")
    @PostMapping("/request_list")
    public List<Order> requestList(@RequestParam(value = "provider_id") String pid){
        return orderService.requestList(pid);
    }

}
