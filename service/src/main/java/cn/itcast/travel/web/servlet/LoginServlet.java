package cn.itcast.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//        Map<String, String> postParams = PostParamsUtils.getPostParams(req);
//
//        UserServiceImpl userService = new UserServiceImpl();
//
//        ResultInfo resultInfo = userService.login(postParams);
//
//        Object data = resultInfo.getData();
//
//        String json = new ObjectMapper().writeValueAsString(resultInfo);
//
//        req.getSession().setAttribute("user", data);
//
//        res.getWriter().write(json);
    }
}
