package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.utils.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(user.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println( date );
        int update = template.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                date,
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
        );

        System.out.println("执行顺序 1");
    }
}
