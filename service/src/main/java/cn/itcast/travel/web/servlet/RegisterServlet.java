package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
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

//        Map<String, String> postParams = PostParamsUtils.getPostParams(req);

//        User user = new User();
//
//        try {
//            BeanUtils.populate(user, postParams);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        boolean flag = new UserServiceImpl().register(user);
//
//        ResultInfo resultInfo = new ResultInfo();
//
//        if (flag) {
//            resultInfo.setFlag(true);
//            resultInfo.setData("注册成功，请前往邮箱完成账号激活");
//        } else {
//            resultInfo.setFlag(false);
//            resultInfo.setErrorMsg("注册失败, 用户名重复");
//        }
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(resultInfo);
//
//        res.getWriter().write(json);
    }
}
