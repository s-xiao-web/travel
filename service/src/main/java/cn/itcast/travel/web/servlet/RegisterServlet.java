package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.impl.UserServiceImpl;
import cn.itcast.travel.utils.PostParamsUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ResultInfo resultInfo = new ResultInfo();
        User user = new User();
        user.setUsername("123123123");

        ObjectMapper objectMapper = new ObjectMapper();

        resultInfo.setErrorMsg("我是信息");
        resultInfo.setFlag(true);
        resultInfo.setData(user);

        String json = objectMapper.writeValueAsString(resultInfo);

        res.setContentType("application/json;charset=utf-8");
        res.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Map<String, String> postParams = PostParamsUtils.getPostParams(req);

        User user = new User();

        try {
            BeanUtils.populate(user, postParams);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("看看当前的user是什么： " + user);

        boolean flag = new UserServiceImpl().register(user);

        ResultInfo resultInfo = new ResultInfo();

        if (flag) {
            resultInfo.setFlag(true);
        } else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(flag);

        res.setContentType("application/json;charset=utf-8");
        res.getWriter().write(json);



    }
}
