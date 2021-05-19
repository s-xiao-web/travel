package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {

    /*
    * 根据rid获取对应的详情图片
    * */
    public List<RouteImg> findById(int rid);
}
