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

    @Select("select * from serviceprovider where provider_id =#{provider_id}")
    Serviceprovider findSpbyId(@Param("provider_id") String providerId);

    @Update("update serviceprovider set verified = 1 where provider_id = #{provider_id}")
    int adminVerify(@Param("provider_id") String pid);

    @Select("select * from serviceprovider where verified=0")
    List<Serviceprovider> verifingList();

    @Update("update serviceprovider set verified = -2 where provider_id = #{provider_id}")
    int adminReject(@Param("provider_id") String pid);

    @Update("update serviceprovider set verified = 2 where provider_id = #{provider_id}")
    int adminRequest(@Param("provider_id")String pid);

    @Update("update serviceprovider set verified = 0,description = #{description} where provider_id = #{provider_id}")
    boolean providerUpdateRequest(@Param("provider_id")String pid, @Param("description")String des);

    @Update("update serviceprovider\n" +
            "INNER JOIN(select AVG(avg_score) a, provider_id\n" +
            "from services\n" +
            "group by provider_id) b ON serviceprovider.provider_id = b.provider_id\n" +
            "SET serviceprovider.avg_score = b.a")
    void updateavgScore();

    @Select("select * from serviceprovider where verified = 1")
    List<Serviceprovider> Verifiedlist();
}