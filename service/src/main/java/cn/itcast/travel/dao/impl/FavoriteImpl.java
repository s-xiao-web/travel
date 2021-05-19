package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class FavoriteImpl implements FavoriteDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public Favorite findByRidAndUid(int rid, int uid) {
        String sql = "select * from tab_favorite where rid = ? and uid = ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public int findCountByRid(int rid) {

        String sql = "SELECT COUNT(*) FROM tab_favorite WHERE rid = ?";

        return template.queryForObject(sql,Integer.class,rid);
    }

    @Override
    public void add(int rid, int uid) {
        String sql = "insert into tab_favorite values(?,?,?)";
        template.update(sql,rid,new Date(),uid);
    }
}
