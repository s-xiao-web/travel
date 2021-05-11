package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {

    /*
    * 查找用户
    * */
    public User findByUsername(String username);

    /*
    * 保存用户
    * */
    public void save(User user);

}
