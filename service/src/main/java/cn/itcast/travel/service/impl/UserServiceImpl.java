package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.utils.MailUtils;
import cn.itcast.travel.utils.UuidUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /*
    * 注册用户
    * @param User
    * @return boolean
    * */
    @Override
    public boolean register(User user) {

        User u = userDao.findByUsername(user.getUsername());
        System.out.println("用户名是" + user.getUsername());
        System.out.println("获取的用户" + u);
        if ( u == null ) return false;

        user.setCode(UuidUtils.getUuid());
        user.setStatus("N");

        userDao.save(user);

        String content="<a href='http://localhost/travel/activeUserServlet?code="+user.getCode()+"'>点击激活【不知道叫什么的练习网站】</a>";
        String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date().getTime());
        MailUtils.sendMail(user.getEmail(), content, "激活邮件" + currentTime);

        return true;
    }

    /*
    * 根据code查找
    * @param
    * */
    @Override
    public boolean activeUser(String code) {
        User user = userDao.findByCode(code);
        if ( user != null ) {
            int i = userDao.updateStatus(user);
            return i != 0;
        }
        return false;
    }

    /*
    * 用户登录
    * @param String username
    * */
    @Override
    public ResultInfo login(Map<String, String> postParams) throws JsonProcessingException {
        String username = postParams.get("username");
        String password = postParams.get("password");

        User user = new UserDaoImpl().findByUsername(username);

        ResultInfo resultInfo = new ResultInfo(false);

        if ( user == null ) {
            resultInfo.setErrorMsg("该用户未注册");
            return resultInfo;
        }

        if ( !(password.equals(user.getPassword())) ) {
            resultInfo.setErrorMsg("密码不正确");
            return resultInfo;
        }

        if ( user.getStatus().equalsIgnoreCase("n") ) {
            resultInfo.setErrorMsg("当前账号未激活");
            return resultInfo;
        }

        resultInfo.setData(user);

        return resultInfo;
    }
}
