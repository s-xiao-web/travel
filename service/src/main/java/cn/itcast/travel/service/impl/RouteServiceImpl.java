package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize) {

        PageBean<Route> routePageBean = new PageBean<>();

        int totalCount = routeDao.findTotalCount(cid);

        int pageNum = (currentPage - 1)  * pageSize;

        List<Route> byRoutePage = routeDao.findByRoutePage(cid, pageNum, pageSize);

        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : ( totalCount / pageSize) + 1;

        routePageBean.setCurrentPage(currentPage);
        routePageBean.setPageSize(pageSize);
        routePageBean.setTotalCount(totalCount);
        routePageBean.setList(byRoutePage);
        routePageBean.setTotalPage(totalPage);
        return routePageBean;

    }
}
