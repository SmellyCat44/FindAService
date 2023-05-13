package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Review;
import cn.edu.shu.xj.ser.entity.Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

@Component
public interface ServiceMapper extends BaseMapper<Service> {

//    @Select("select * from address where user_id =#{uid}")
//    List<Admin> list1(@Param("uid") String uid);

//    @Update("update address set is_default = 0 where user_id = #{uid} ")
//    boolean setDault1(@Param("uid") String uid);

//    @Update("UPDATE address set is_default= 1 where address_id = #{aid}")
//    boolean setDault2(@Param("aid") Integer aid);

    @Select("select * from services")
    List<Service> verified_list();

    @Update("update services set verified = true where service_id = #{service_id}")
    boolean adminVerify(@Param("service_id") Integer sid);

    @Select("select * from services where verified=false")
    List<Service> verifing_list();

    @Select("select * from services where service_description like \"%\"#{service_description}\"%\"")
    List<Service> searchByName(@Param("service_description") String sd);

    @Select("select * from services where service_area=#{service_area}")
    List<Service> searchByArea(@Param("service_area")String sa);

    @Select("select * from services where service_area=#{service_area} and service_category=#{service_category}")
    List<Service> searchByAreaCategory(@Param("service_area")String sa, @Param("service_category")String sc);

    @Select("select * from services where service_category=#{service_category}")
    List<Service> searchByCategory(@Param("service_category") String sc);

    @Select("select * from services where provider_id=#{provider_id}")
    List<Service> providerList(@Param("provider_id")String pid);

    @Select("select * from services where service_id = #{service_id}")
    Service searchById(@Param("service_id")Integer sid);

    @Select("select * from review a, services b where a.service_id = b.service_id and b.service_area=#{service_area} and b.service_category=#{service_category}")
    List<LinkedHashMap<Review, Service>> searchByAreaCategoryWithReview(@Param("service_area")String sa, @Param("service_category")String sc);
}