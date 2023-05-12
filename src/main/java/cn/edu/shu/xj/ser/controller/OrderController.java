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
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.List;

@Api(tags = "OrderInterface")
@RequestMapping("/order")
@RestController
@CrossOrigin("http://localhost:3000")
public class OrderController {

    @Autowired
    IOrderService orderService;
    @Autowired
    IServiceService serviceService;

    @ApiOperation(value = "user_request")
    @PostMapping("/user_request")
    public boolean userRequest(@RequestParam(value = "user_id") String uid, @RequestParam(value = "service_id") Integer sid, @RequestParam(value = "detail_time")String dt){
        Service oneService = serviceService.searchById(sid);
        if (oneService==null) return false;
        return orderService.userRequest(uid, sid, dt);
    }

    @ApiOperation(value = "request_list_for_provider")
    @PostMapping("/request_list")
    public List<LinkedHashMap<Object,Object>> requestList(@RequestParam(value = "provider_id") String pid){
        return orderService.requestList(pid);
    }

    @ApiOperation(value = "provider_reject_user_request")
    @PostMapping("/provider_reject")
    public boolean providerReject(@RequestParam(value = "order_id") Integer oid){
        //Order oneOrder = orderService.searchById(oid);
        //System.out.println(oneOrder);
//        if (oneOrder==null) return false;
//        if(oneOrder.getOrder_status()!=1) return false;// if order_status != 1 means the order cannot be rejected
        return orderService.providerReject(oid);
    }

    @ApiOperation(value = "provider_accept_user_request")
    @PostMapping("/provider_accept")
    public boolean providerAccept(@RequestParam(value = "order_id") Integer oid){
        return orderService.providerAccept(oid);
    }

    @ApiOperation(value = "user_browse_his_orders")
    @PostMapping("/user_list")
    public List<Order> userBrowse(@RequestParam(value = "user_id") String uid){
        return orderService.searchByUserId(uid);
    }

}
