package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.service.impl.UserServiceImpl;
import cn.itcast.travel.utils.PostParamsUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println( "首行" + new ResultInfo(false, "密码不正确") );

        Map<String, String> postParams = PostParamsUtils.getPostParams(req);

        UserServiceImpl userService = new UserServiceImpl();

        ResultInfo resultInfo = userService.login(postParams);

        String json = new ObjectMapper().writeValueAsString(resultInfo);
        
        res.getWriter().write(json);
    }
}
