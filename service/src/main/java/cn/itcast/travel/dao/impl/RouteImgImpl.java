package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RouteImgImpl implements RouteImgDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<RouteImg> findById(int rid) {
        String sql = "select * from tab_route_img where rid = ?";
        return template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
    }
}
