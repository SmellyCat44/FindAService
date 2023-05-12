package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.LinkedHashMap;
import java.util.List;

public interface IOrderService extends IService<Order> {

    public boolean userRequest(String uid, Integer sid, String dt);

    public List<LinkedHashMap<Object,Object>> requestList(String pid);

    public boolean providerReject(Integer oid);

    public Order searchById(Integer oid);

    public boolean providerAccept(Integer oid);

    public List<Order> searchByUserId(String uid);
}