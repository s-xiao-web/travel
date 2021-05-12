package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.utils.MailUtils;
import cn.itcast.travel.utils.UuidUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(User user) {

        User u = userDao.findByUsername(user.getUsername());

        if ( u != null ) return false;

        user.setCode(UuidUtils.getUuid());
        user.setStatus("N");

        userDao.save(user);

        String content="<a href='http://localhost/travel/activeUserServlet?code="+user.getCode()+"'>点击激活【不知道叫什么的练习网站】</a>";
        String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date().getTime());
        MailUtils.sendMail(user.getEmail(), content, "激活邮件" + currentTime);

        return true;
    }
}
