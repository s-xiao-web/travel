package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteImpl;
import cn.itcast.travel.dao.impl.RouteImgImpl;
import cn.itcast.travel.dao.impl.RouteImpl;
import cn.itcast.travel.dao.impl.SellerImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteImpl();
    private SellerDao sellerDao = new SellerImpl();
    private RouteImgDao routeImgDao = new RouteImgImpl();
    private FavoriteDao favoriteDao = new FavoriteImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {

        PageBean<Route> routePageBean = new PageBean<>();

        int totalCount = routeDao.findTotalCount(cid, rname);

        int pageNum = (currentPage - 1)  * pageSize;

        List<Route> byRoutePage = routeDao.findByRoutePage(cid, pageNum, pageSize, rname);

        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : ( totalCount / pageSize) + 1;

        routePageBean.setCurrentPage(currentPage);
        routePageBean.setPageSize(pageSize);
        routePageBean.setTotalCount(totalCount);
        routePageBean.setList(byRoutePage);
        routePageBean.setTotalPage(totalPage);
        return routePageBean;

    }

    @Override
    public Route queryDetail(String rid) {
        Route route = routeDao.findOne(Integer.parseInt(rid));
        Seller seller = sellerDao.findById(route.getSid());
        List<RouteImg> routeImgs = routeImgDao.findById(route.getRid());
        int countByRid = favoriteDao.findCountByRid(Integer.parseInt(rid));

        route.setSeller(seller);
        route.setRouteImgList(routeImgs);
        route.setCount(countByRid);

        return route;
    }
}
