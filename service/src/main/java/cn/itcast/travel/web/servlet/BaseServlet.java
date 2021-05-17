package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        /*获取请求路径*/
        String requestURI = req.getRequestURI();
        /*获取请求方法*/
        String methodName = requestURI.substring(requestURI.lastIndexOf("/") + 1);

        /*
        * 第一个 参数 是方法名称
        * 第二个 参数 是方法形参
        * */
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            try {
                method.invoke(this, req, res);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void writeValue(Object resultInfo, HttpServletResponse res) throws IOException{
        res.getWriter().write(objectMapper.writeValueAsString(resultInfo));
    }
}
