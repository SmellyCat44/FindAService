package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.entity.Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public interface OrderMapper extends BaseMapper<Order> {

    //pending, rejected, accepted, completed


    @Insert("INSERT INTO orders (service_id, user_id, order_time, order_status, detail_time, order_detail1, detail_add)\n" +
            "VALUES (#{service_id}, #{user_id}, NOW(),'pending',#{detail_time},#{order_detail1},#{detail_add});")
    boolean userRequest(@Param("user_id") String uid, @Param("service_id") Integer sid, @Param("detail_time") String dt, @Param("order_detail1") String d1, @Param("detail_add") String da);

//    @Select("select a.user_id,a.service_id,a.order_time,a.order_status,a.order_id,a.detail_time,b.availability,b.price,b.service_description from orders a, services b where a.service_id = b.service_id and b.provider_id = #{provider_id}")


    //provider can reject all the time while chatting and requesting
    @Update("update orders set order_status= 'rejected' where order_id =#{order_id}")
    boolean providerReject(@Param("order_id")Integer oid);

    @Select("select * from orders where order_id = #{order_id}")
    Order searchById(@Param("order_id")Integer oid);

    @Update("update orders set order_status= 'accepted' where order_id =#{order_id} and order_status = 'pending'")
    boolean providerAccept(@Param("order_id")Integer oid);

    @Select("select * from orders a, services b where a.service_id = b.service_id and a.user_id = #{user_id} ")
    List<LinkedHashMap<Object,Object>> searchByUserId(@Param("user_id")String uid);

    @Update("update orders set order_detail1 = #{order_detail1} where order_id = #{order_id}")
    boolean userReply1(@Param("order_id")Integer oid, @Param("order_detail1")String des);

    @Update("update orders set order_detail2 = #{order_detail2} where order_id = #{order_id}")
    boolean providerReply2(@Param("order_id")Integer oid, @Param("order_detail2")String des);


    @Update("update orders set order_detail3 = #{order_detail3} where order_id = #{order_id}")
    boolean userReply3(@Param("order_id")Integer oid, @Param("order_detail3")String des);

    @Update("update orders set order_detail4 = #{order_detail4} where order_id = #{order_id}")
    boolean providerReply4(@Param("order_id")Integer oid, @Param("order_detail4")String des);

    @Select("select * from orders a, services b where a.service_id = b.service_id and a.order_id=#{order_id}")
    LinkedHashMap<Order, Service> loadService(@Param("order_id")Integer oid);

    @Update("update orders set order_status='completed' where order_id = #{order_id}")
    boolean userConfirmFinish(@Param("order_id")Integer oid);

    @Select("select max(order_id) from orders")
    int getOidNow();

    @Select("select * from orders a, services b where a.service_id = b.service_id and a.order_status='pending'")
    List<LinkedHashMap<Object, Object>> userPendingList(String uid);

    @Select("select * from orders a, services b where a.service_id = b.service_id and a.order_status='rejected'")
    List<LinkedHashMap<Object, Object>> userRejectedList(String uid);

    @Select("select * from orders a, services b where a.service_id = b.service_id and a.order_status='accepted'")
    List<LinkedHashMap<Object, Object>> userAcceptedList(String uid);

    @Select("select * from orders a, services b where a.service_id = b.service_id and a.order_status='completed'")
    List<LinkedHashMap<Object, Object>> userCompletedList(String uid);

    @Select("select * from orders a, services b where a.service_id = b.service_id and a.order_status='withdraw'")
    List<LinkedHashMap<Object, Object>> userWithdrawList(String uid);

    @Select("select * from orders a, services b where a.service_id = b.service_id and b.provider_id = #{provider_id} and order_status='pending'")
    List<LinkedHashMap<Object,Object>> requestList(@Param("provider_id")String pid);

    @Select("select * from orders a, services b where a.service_id = b.service_id and b.provider_id = #{provider_id} and order_status='rejected'")
    List<LinkedHashMap<Object, Object>> rejectedList(@Param("provider_id")String pid);

    @Select("select * from orders a, services b where a.service_id = b.service_id and b.provider_id = #{provider_id} and order_status='accepted'")
    List<LinkedHashMap<Object, Object>> acceptedList(@Param("provider_id")String pid);

    @Select("select * from orders a, services b where a.service_id = b.service_id and b.provider_id = #{provider_id} and order_status='completed'")
    List<LinkedHashMap<Object, Object>> completedList(@Param("provider_id")String pid);

    @Select("select * from orders a, services b where a.service_id = b.service_id and b.provider_id = #{provider_id} and order_status='withdraw'")
    List<LinkedHashMap<Object, Object>> withdrawList(@Param("provider_id")String pid);

    @Update("update orders set order_status='withdraw' where order_id = #{order_id}")
    boolean userWithdraw(@Param("order_id")Integer oid);


//    @Select("select * from address where user_id =#{uid}")
//    List<Admin> list1(@Param("uid") String uid);

//    @Update("update address set is_default = 0 where user_id = #{uid} ")
//    boolean setDault1(@Param("uid") String uid);

//    @Update("UPDATE address set is_default= 1 where address_id = #{aid}")
//    boolean setDault2(@Param("aid") Integer aid);

}