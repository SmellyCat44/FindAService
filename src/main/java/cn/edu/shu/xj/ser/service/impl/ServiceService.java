package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Review;
import cn.edu.shu.xj.ser.entity.Serviceprovider;
import cn.edu.shu.xj.ser.mapper.ServiceMapper;
import cn.edu.shu.xj.ser.service.IServiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ServiceService extends ServiceImpl<ServiceMapper, cn.edu.shu.xj.ser.entity.Service> implements IServiceService {

    @Autowired
    ServiceMapper serviceMapper;

    public List<cn.edu.shu.xj.ser.entity.Service> verified_list(){ return serviceMapper.verified_list();}

    public boolean adminVerify(Integer sid){
        return serviceMapper.adminVerify(sid);
    }

    public List<cn.edu.shu.xj.ser.entity.Service> verifing_list(){ return serviceMapper.verifing_list();};

    public List<cn.edu.shu.xj.ser.entity.Service> searchByName(String sd){
        return serviceMapper.searchByName(sd);
    }

    public List<cn.edu.shu.xj.ser.entity.Service> searchByArea(String sa){
        return serviceMapper.searchByArea(sa);
    }

    public List<cn.edu.shu.xj.ser.entity.Service> searchByAreaCategory(String sa, String sc){
        return serviceMapper.searchByAreaCategory(sa,sc);
    }

    public List<cn.edu.shu.xj.ser.entity.Service> searchByCategory(String sc){
        return serviceMapper.searchByCategory(sc);
    }

    public List<cn.edu.shu.xj.ser.entity.Service> providerList(String pid){
        return serviceMapper.providerList(pid);
    }

    public cn.edu.shu.xj.ser.entity.Service searchById(Integer sid){
        return serviceMapper.searchById(sid);
    }

    public List<LinkedHashMap<Review, cn.edu.shu.xj.ser.entity.Service>> searchByAreaCategoryWithReview(String sa, String sc){
        return serviceMapper.searchByAreaCategoryWithReview(sa,sc);
    }

    public void updateavgScore(){
        serviceMapper.updateavgScore();
    }

}
