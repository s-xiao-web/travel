package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import cn.itcast.travel.utils.FormatUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouterServlet extends BaseServlet{

    private FormatUtils format = new FormatUtils();
    private RouteService routerServlet = new RouteServiceImpl();

    public void queryRoutePage(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int cid = Integer.parseInt(req.getParameter("cid"));
        int pageSize = format.formatNum(req.getParameter("pageSize"), 5);
        int currentPage = format.formatNum(req.getParameter("currentPage"), 1);
        String rname = req.getParameter("rname");
        rname = new String(rname.getBytes("iso-8859-1"),"utf-8");

        ResultInfo resultInfo = new ResultInfo(true);
        PageBean<Route> routePageBean = routerServlet.pageQuery(cid, currentPage, pageSize, rname);

        resultInfo.setData(routePageBean);

        System.out.println( resultInfo );
        writeValue(routePageBean, res);

    }

}
