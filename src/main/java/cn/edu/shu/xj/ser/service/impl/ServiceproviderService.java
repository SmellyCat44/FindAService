package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Serviceprovider;
import cn.edu.shu.xj.ser.mapper.ServiceproviderMapper;
import cn.edu.shu.xj.ser.service.IServiceproviderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceproviderService extends ServiceImpl<ServiceproviderMapper, Serviceprovider> implements IServiceproviderService {

    @Autowired
    ServiceproviderMapper serviceproviderMapper;

    public Serviceprovider findSpbyId(String pid){ return serviceproviderMapper.findSpbyId(pid);}

    public int adminVerify(String pid){
        return serviceproviderMapper.adminVerify(pid);
    }

    public List<Serviceprovider> verifing_list(){
        return serviceproviderMapper.verifingList();
    }

    public int adminReject(String pid){
        return serviceproviderMapper.adminReject(pid);
    }

    public int adminRequest(String pid){
        return serviceproviderMapper.adminRequest(pid);
    }
}
