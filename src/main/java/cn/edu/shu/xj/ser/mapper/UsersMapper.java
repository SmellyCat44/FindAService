package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UsersMapper extends BaseMapper<Users> {

//    @Select("select * from address where user_id =#{uid}")
//    List<Admin> list1(@Param("uid") String uid);

//    @Update("update address set is_default = 0 where user_id = #{uid} ")
//    boolean setDault1(@Param("uid") String uid);

//    @Update("UPDATE address set is_default= 1 where address_id = #{aid}")
//    boolean setDault2(@Param("aid") Integer aid);

    @Select("select * from users where user_id =#{user_id}")
    Admin findUserbyId(@Param("user_id") String userId);

}