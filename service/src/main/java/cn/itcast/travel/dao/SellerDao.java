package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

public interface SellerDao {

    /*
    * 根据sid获取对应的上家信息
    * */
    public Seller findById(int sid);

}
