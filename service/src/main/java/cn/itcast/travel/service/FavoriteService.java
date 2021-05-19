package cn.itcast.travel.service;

public interface FavoriteService {

    /*
    * 该用户是否收藏
    * */
    public boolean isFavorite(int rid, int uid);

    /*
    * 添加收藏
    * */
    void add(int rid, int uid);

}
