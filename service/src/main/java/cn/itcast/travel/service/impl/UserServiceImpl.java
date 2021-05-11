package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean register(User user) {

        UserDaoImpl userDao = new UserDaoImpl();

        User u = userDao.findByUsername(user.getUsername());

        if ( u != null ) return false;

        userDao.save(user);

        System.out.println("执行顺序 2");

        return true;
    }
}
