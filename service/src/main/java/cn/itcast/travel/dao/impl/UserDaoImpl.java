package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.utils.JdbcUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    /*查找用户*/
    @Override
    public User findByUsername(String username) {
        String sql = "select uid, username, password, name, birthday, sex, telephone, email, status, code " +
                "from " +
                "tab_user " +
                "where username = ? ";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        }catch (Exception e) {
            return null;
        }
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
    }

    /*查找code*/
    @Override
    public User findByCode(String code) {
        System.out.println(code);
        String sql = "select * from tab_user where code = ?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return user;
    }

    /*更新用户状态码*/
    @Override
    public int updateStatus(User user) {
        String sql = "update tab_user set status = 'Y' where code = ?";
        return template.update(sql, user.getCode());
    }
}
