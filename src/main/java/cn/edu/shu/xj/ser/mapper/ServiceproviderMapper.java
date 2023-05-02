package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Service;
import cn.edu.shu.xj.ser.entity.Serviceprovider;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ServiceproviderMapper extends BaseMapper<Serviceprovider> {

//    @Select("select * from address where user_id =#{uid}")
//    List<Admin> list1(@Param("uid") String uid);

//    @Update("update address set is_default = 0 where user_id = #{uid} ")
//    boolean setDault1(@Param("uid") String uid);

//    @Update("UPDATE address set is_default= 1 where address_id = #{aid}")
//    boolean setDault2(@Param("aid") Integer aid);

    @Select("select * from serviceprovider where provider_id =#{provider_id}")
    Serviceprovider findSpbyId(@Param("provider_id") String providerId);

    @Update("update serviceprovider set verified = 1 where provider_id = #{provider_id}")
    int adminVerify(@Param("provider_id") String pid);

    @Select("select * from serviceprovider where verified=false")
    List<Serviceprovider> verifingList();

    @Update("update serviceprovider set verified = -2 where provider_id = #{provider_id}")
    int adminReject(@Param("provider_id") String pid);

    @Update("update serviceprovider set verified = 2 where provider_id = #{provider_id}")
    int adminRequest(@Param("provider_id")String pid);
}