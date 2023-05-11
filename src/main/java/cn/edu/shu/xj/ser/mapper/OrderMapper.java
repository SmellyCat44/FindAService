package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public interface OrderMapper extends BaseMapper<Order> {
    @Insert("INSERT INTO orders (service_id, user_id, order_time, order_status, detail_time)\n" +
            "VALUES (#{service_id}, #{user_id}, NOW(),1,#{detail_time});")
    boolean userRequest(@Param("user_id")String uid, @Param("service_id")Integer sid, @Param("detail_time")String dt);
//    , @Param("detail_add")String ad

    @Select("select * from orders a, services b where a.service_id = b.service_id and b.provider_id = #{provider_id}")
    List<Order> requestList(@Param("provider_id")String pid);

//    @Select("select * from address where user_id =#{uid}")
//    List<Admin> list1(@Param("uid") String uid);

//    @Update("update address set is_default = 0 where user_id = #{uid} ")
//    boolean setDault1(@Param("uid") String uid);

//    @Update("UPDATE address set is_default= 1 where address_id = #{aid}")
//    boolean setDault2(@Param("aid") Integer aid);

}