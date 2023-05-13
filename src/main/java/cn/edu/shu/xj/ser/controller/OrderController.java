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
    public boolean userRequest(@RequestParam(value = "user_id") String uid, @RequestParam(value = "service_id") Integer sid, @RequestParam(value = "detail_time")String dt, @RequestParam(value = "order_detail1")String d1){
        Service oneService = serviceService.searchById(sid);
        if (oneService==null) return false;
        return orderService.userRequest(uid, sid, dt, d1);
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
    public List<LinkedHashMap<Object,Object>> userBrowse(@RequestParam(value = "user_id") String uid){
        return orderService.searchByUserId(uid);
    }

//    @ApiOperation(value = "user_give_description1")
//    @PostMapping("/user_reply1")
//    public boolean userReply1(@RequestParam(value = "order_id") Integer oid, @RequestParam(value = "order_detail1") String des){
//        return orderService.userReply1(oid, des);
//    }

    @ApiOperation(value = "provider_load_order")
    @PostMapping("/provider_read")
    public LinkedHashMap<Order,Service> providerRead(@RequestParam(value = "order_id") Integer oid){
        return orderService.loadService(oid);
    }

    @ApiOperation(value = "provider_give_description2")
    @PostMapping("/provider_reply2")
    public boolean providerReply2(@RequestParam(value = "order_id") Integer oid, @RequestParam(value = "order_detail2") String des){
        return orderService.providerReply2(oid, des);
    }

    @ApiOperation(value = "user_give_description3")
    @PostMapping("/user_reply3")
    public boolean userReply3(@RequestParam(value = "order_id") Integer oid, @RequestParam(value = "order_detail3") String des){
        return orderService.userReply3(oid, des);
    }

    @ApiOperation(value = "provider_give_description4")
    @PostMapping("/provider_reply4")
    public boolean providerReply4(@RequestParam(value = "order_id") Integer oid, @RequestParam(value = "order_detail4") String des){
        return orderService.providerReply4(oid, des);
    }

    @ApiOperation(value = "provider_give_description4")
    @PostMapping("/provider_reply")
    public boolean providerReply(@RequestParam(value = "order_id") Integer oid, @RequestParam(value = "order_detail") String des){
        Order oneOrder = orderService.searchById(oid);
        if(oneOrder==null) return false;
        if(oneOrder.getOrderDetail2()==null) return orderService.providerReply2(oid, des);
        else return providerReply4(oid, des);

    }

    @ApiOperation(value = "provider_confirm_order")
    @PostMapping("/provider_confirm_finish")
    public boolean userConfirmFinish(@RequestParam(value = "order_id") Integer oid){
        Order oneOrder = orderService.getById(oid);
        if (oneOrder==null) return false;
        if (oneOrder.getOrderStatus().equals("accepted")) return orderService.userConfirmFinish(oid);
        else return false;
    }

    @ApiOperation(value = "user_withdraw_request")
    @PostMapping("/user_withdraw")
    public boolean userWithdraw(@RequestParam(value = "order_id") Integer oid){
        Order oneOrder = orderService.getById(oid);
        if (oneOrder==null) return false;
        if (oneOrder.getOrderStatus().equals("pending")) return orderService.userWithdraw(oid);
        else return false;
    }

    //pending, rejected, accepted, completed

    //list for user himself
    @ApiOperation(value = "user_pending_list")
    @PostMapping("/user_pending_list")
    public List<LinkedHashMap<Object,Object>> userPendingList(@RequestParam(value = "user_id") String uid){
        return orderService.userPendingList(uid);
    }

    @ApiOperation(value = "user_rejected_list")
    @PostMapping("/user_rejected_list")
    public List<LinkedHashMap<Object,Object>> userRejectedList(@RequestParam(value = "user_id") String uid){
        return orderService.userRejectedList(uid);
    }

    @ApiOperation(value = "user_accepted_list")
    @PostMapping("/user_accepted_list")
    public List<LinkedHashMap<Object,Object>> userAcceptedList(@RequestParam(value = "user_id") String uid){
        return orderService.userAcceptedList(uid);
    }

    @ApiOperation(value = "user_completed_list")
    @PostMapping("/user_completed_list")
    public List<LinkedHashMap<Object,Object>> userCompletedList(@RequestParam(value = "user_id") String uid){
        return orderService.userCompletedList(uid);
    }

    @ApiOperation(value = "user_withdraw_list")
    @PostMapping("/user_withdraw_list")
    public List<LinkedHashMap<Object,Object>> userWithdrawList(@RequestParam(value = "user_id") String uid){
        return orderService.userWithdrawList(uid);
    }

    //pending, rejected, accepted, completed, withdraw
    //list for provider himself
    @ApiOperation(value = "request_list_for_provider_pending")
    @PostMapping("/request_list")
    public List<LinkedHashMap<Object,Object>> requestList(@RequestParam(value = "provider_id") String pid){
        return orderService.requestList(pid);
    }

    @ApiOperation(value = "provider_rejected_list")
    @PostMapping("/rejected_list")
    public List<LinkedHashMap<Object,Object>> rejectedList(@RequestParam(value = "provider_id") String pid){
        return orderService.rejectedList(pid);
    }

    @ApiOperation(value = "provider_rejected_list")
    @PostMapping("/accepted_list")
    public List<LinkedHashMap<Object,Object>> acceptedList(@RequestParam(value = "provider_id") String pid){
        return orderService.acceptedList(pid);
    }

    @ApiOperation(value = "provider_completed_list")
    @PostMapping("/completed_list")
    public List<LinkedHashMap<Object,Object>> completedList(@RequestParam(value = "provider_id") String pid){
        return orderService.completedList(pid);
    }

    @ApiOperation(value = "provider_withdraw_list")
    @PostMapping("/withdraw_list")
    public List<LinkedHashMap<Object,Object>> withdrawList(@RequestParam(value = "provider_id") String pid){
        return orderService.withdrawList(pid);
    }

}
