package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.entity.Service;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.LinkedHashMap;
import java.util.List;

public interface IOrderService extends IService<Order> {

    public boolean userRequest(String uid, Integer sid, String dt, String d1);

    public List<LinkedHashMap<Object,Object>> requestList(String pid);

    public boolean providerReject(Integer oid);

    public Order searchById(Integer oid);

    public boolean providerAccept(Integer oid);

    public List<LinkedHashMap<Object,Object>> searchByUserId(String uid);

    public boolean userReply1(Integer oid, String des);

    public boolean providerReply2(Integer oid, String des);

    public boolean userReply3(Integer oid, String des);

    public boolean providerReply4(Integer oid, String des);

    public LinkedHashMap<Order, Service> loadService(Integer oid);

    public boolean userConfirmFinish(Integer oid);

    public int getOidNow();
}