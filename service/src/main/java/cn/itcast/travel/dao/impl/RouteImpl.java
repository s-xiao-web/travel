package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RouteImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public int findTotalCount(int cid) {
        String sql = "select count(*) from tab_router where cid = ?";
        Integer integer = template.queryForObject(sql, Integer.class, cid);
        return integer;
    }

    @Override
    public List<Route> findByRoutePage(int cid, int start, int pageSize) {
        String sql = "select * from tab_router where cid = cid limit ?, ?";

        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), start, pageSize);

    }
}
