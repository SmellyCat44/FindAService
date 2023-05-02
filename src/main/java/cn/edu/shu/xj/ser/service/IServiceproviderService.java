package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Service;
import cn.edu.shu.xj.ser.entity.Serviceprovider;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IServiceproviderService extends IService<Serviceprovider> {
    public Serviceprovider findSpbyId(String pid);

    public int adminVerify(String pid);

    public List<Serviceprovider> verifing_list();

    public int adminReject(String pid);

    public int adminRequest(String pid);
}