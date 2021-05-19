package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import cn.itcast.travel.utils.FormatUtils;
import cn.itcast.travel.utils.PostParamsUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/route/*")
public class RouterServlet extends BaseServlet{

    private FormatUtils format = new FormatUtils();
    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();

    /*
    * 查询旅游信息
    * */
    public void queryRoutePage(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int cid = Integer.parseInt(req.getParameter("cid"));
        int pageSize = format.formatNum(req.getParameter("pageSize"), 5);
        int currentPage = format.formatNum(req.getParameter("currentPage"), 1);
        String rname = req.getParameter("rname");
        rname = new String(rname.getBytes("iso-8859-1"),"utf-8");

        ResultInfo resultInfo = new ResultInfo(true);
        PageBean<Route> routePageBean = routeService.pageQuery(cid, currentPage, pageSize, rname);

        resultInfo.setData(routePageBean);

        writeValue(routePageBean, res);

    }

    /*
    * 查询线路详细信息
    * */
    public void queryRouteDetail(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String rid = req.getParameter("rid");
        Route route = routeService.queryDetail(rid);

        ResultInfo resultInfo = new ResultInfo(true);
        resultInfo.setData(route);
        writeValue(resultInfo, res);
    }

    /*
    * 收藏旅游线路
    * */
    public void addFavorite(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Map<String, String> postParams = PostParamsUtils.getPostParams(req);
        int rid = Integer.parseInt(postParams.get("rid"));
        int uid = Integer.parseInt(postParams.get("uid"));

        /*
        * true:  已经收藏
        * false: 没有收藏
        * */
        boolean isFavorite = favoriteService.isFavorite(rid, uid);

        ResultInfo resultInfo = new ResultInfo(true);

        if( isFavorite ) {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("这个线路已经收藏，后续优化");
        } else {
            favoriteService.add(rid, uid);
            resultInfo.setData("收藏成功");
        }

        writeValue(resultInfo, res);

    }

}
