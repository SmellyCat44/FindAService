package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Users;
import cn.edu.shu.xj.ser.mapper.UsersMapper;
import cn.edu.shu.xj.ser.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Autowired
    UsersMapper userMapper;

    public Users findUserbyId(String uid){
        return userMapper.selectById(uid);}

}
