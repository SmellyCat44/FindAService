package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUsersService extends IService<Users> {
    public Users findUserbyId(String uid);
}