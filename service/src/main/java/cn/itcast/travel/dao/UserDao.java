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

    /*
    * 查找code
    * */
    public User findByCode(String code);

    /*
    * 更新stats
    * */
    public int updateStatus(User user);

    /*
    * 根据用户名查询 user
    * */

}
