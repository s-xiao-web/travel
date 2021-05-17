package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import cn.itcast.travel.utils.PostParamsUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    //声明UserService业务对象
    private UserService service = new UserServiceImpl();

    /*
    * 用户登录
    * */
    public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {

        Map<String, String> postParams = PostParamsUtils.getPostParams(req);

        ResultInfo resultInfo = service.login(postParams);

        Object data = resultInfo.getData();

        req.getSession().setAttribute("user", data);

        writeValue(resultInfo,res);

    }

    /*
    * 用户注册
    * */
    public void register(HttpServletRequest req, HttpServletResponse res) throws IOException {

        Map<String, String> postParams = PostParamsUtils.getPostParams(req);

        User user = new User();

        try {
            BeanUtils.populate(user, postParams);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        boolean flag = new UserServiceImpl().register(user);

        ResultInfo resultInfo = new ResultInfo();

        if (flag) {
            resultInfo.setFlag(true);
            resultInfo.setData("注册成功，请前往邮箱完成账号激活");
        } else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败, 用户名重复");
        }

        writeValue(resultInfo, res);
    }

    /*
    * 用户激活
    * */
    public void active(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String code = req.getParameter("code");
        String json;
        boolean result = new UserServiceImpl().activeUser(code);

        ResultInfo resultInfo = new ResultInfo(true, "null");
        ObjectMapper objectMapper = new ObjectMapper();

        if (result) {
            resultInfo.setData("激活成功");
        } else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("激活失败");
        }

        writeValue(result, res);
    }

    /*
    * 用户退出
    * */
    public void exit(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.getSession().invalidate();

        ResultInfo resultInfo = new ResultInfo(true);
        resultInfo.setData("退出成功");

        writeValue(resultInfo, res);
    }
}
