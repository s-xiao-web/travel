package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteImpl();

    @Override
    public boolean isFavorite(int rid, int uid) {
        Favorite byRidAndUid = favoriteDao.findByRidAndUid(rid, uid);

        return byRidAndUid != null;
    }

    @Override
    public void add(int rid, int uid) {
        favoriteDao.add(rid, uid);
    }
}
