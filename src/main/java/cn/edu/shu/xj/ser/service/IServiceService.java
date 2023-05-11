package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Service;
import cn.edu.shu.xj.ser.entity.Serviceprovider;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IServiceService extends IService<Service> {
    public List<Service> verified_list();
    public boolean adminVerify(Integer sid);
    public List<Service> verifing_list();
    public List<Service> searchByName(String sd);
    public List<Service> searchByArea(String sa);
    public List<Service> searchByAreaCategory(String sa, Integer sc);
    public List<Service> searchByCategory(Integer sc);
    public List<Service> providerList(String pid);
    public Service searchById(Integer sid);
}