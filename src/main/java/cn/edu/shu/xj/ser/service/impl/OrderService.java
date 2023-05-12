package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.mapper.OrderMapper;
import cn.edu.shu.xj.ser.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    OrderMapper orderMapper;

    public boolean userRequest(String uid, Integer sid, String dt){
        return orderMapper.userRequest(uid,sid,dt);
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

    public List<Order> searchByUserId(String uid){
        return orderMapper.searchByUserId(uid);
    }
}
