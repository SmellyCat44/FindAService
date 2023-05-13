package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.mapper.OrderMapper;
import cn.edu.shu.xj.ser.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    OrderMapper orderMapper;

    public boolean userRequest(String uid, Integer sid, String dt, String d1){
        return orderMapper.userRequest(uid,sid,dt,d1);
    }

    public List<LinkedHashMap<Object,Object>> requestList(String pid){
        return orderMapper.requestList(pid);
    }

    public boolean providerReject(Integer oid){
        return orderMapper.providerReject(oid);
    }

    public Order searchById(Integer oid){
        return orderMapper.searchById(oid);
    }

    public boolean providerAccept(Integer oid){
        return orderMapper.providerAccept(oid);
    }

    public List<LinkedHashMap<Object,Object>> searchByUserId(String uid){
        return orderMapper.searchByUserId(uid);
    }

    public boolean userReply1(Integer oid, String des){
        return orderMapper.userReply1(oid,des);
    }

    public boolean providerReply2(Integer oid, String des){
        return orderMapper.providerReply2(oid,des);
    }

    public boolean userReply3(Integer oid, String des){
        return orderMapper.userReply3(oid,des);
    }

    public boolean providerReply4(Integer oid, String des){
        return orderMapper.providerReply4(oid,des);
    }

    public LinkedHashMap<Order, cn.edu.shu.xj.ser.entity.Service> loadService(Integer oid){
        return orderMapper.loadService(oid);
    }
    public boolean userConfirmFinish(Integer oid){
        return orderMapper.userConfirmFinish(oid);
    }

    public int getOidNow(){
        return orderMapper.getOidNow();
    }

    public List<LinkedHashMap<Object, Object>> userPendingList(String uid){
        return orderMapper.userPendingList(uid);
    }

    public List<LinkedHashMap<Object, Object>> userRejectedList(String uid){
        return orderMapper.userRejectedList(uid);
    }

    public List<LinkedHashMap<Object, Object>> userAcceptedList(String uid){
        return orderMapper.userAcceptedList(uid);
    }

    public List<LinkedHashMap<Object, Object>> userCompletedList(String uid){
        return orderMapper.userCompletedList(uid);
    }

    public List<LinkedHashMap<Object, Object>> rejectedList(String pid){
        return orderMapper.rejectedList(pid);
    }

    public List<LinkedHashMap<Object, Object>> acceptedList(String pid){
        return orderMapper.acceptedList(pid);
    }

    public List<LinkedHashMap<Object, Object>> completedList(String pid){
        return orderMapper.completedList(pid);
    }
}
