package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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

        json = objectMapper.writeValueAsString(resultInfo);
        res.getWriter().write(json);
    }
}
