package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {

    /*
    * 根据 cid 查询总页数
    * */
    public int findTotalCount(int cid);

    /*
    * 根据 cid start pageSize 查询范围内的数据
    * */
    public List<Route> findByRoutePage(int cid, int start, int pageSize);
}
