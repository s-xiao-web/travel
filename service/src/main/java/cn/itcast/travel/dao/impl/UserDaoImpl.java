package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.utils.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    /*查找用户*/
    @Override
    public User findByUsername(String username) {
        return null;
    }

    /*创建用户*/
    @Override
    public void save(User user) {

        String sql = "insert into tab_user " +
                "(username, password, name, birthday, sex, telephone, email, status, code)" +
                "values " +
                "(?,?,?,?,?,?,?,?,?)";

        int update = template.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmil(),
                user.getStatus(),
                user.getCode()
        );

        System.out.println("执行顺序 1");
    }
}
