package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public int findTotalCount(int cid, String rname) {

        ArrayList params = new ArrayList();
        String sql = "select count(*) from tab_route where 1=1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        if ( cid != 0 ) {
            stringBuilder.append("and cid = ? ");
            params.add(cid);
        }

        if (rname != null) {
            stringBuilder.append(" and rname = ? ");
            params.add(rname);
        }

        sql = stringBuilder.toString();

        return template.queryForObject(sql, Integer.class, params.toArray());

    }

    @Override
    public List<Route> findByRoutePage(int cid, int start, int pageSize, String rname) {

//        String sql = "select * from tab_route where cid = cid limit ?, ?";
        ArrayList params = new ArrayList();

        String sql = "select * from tab_route where 1=1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);

        if ( cid != 0 ) {
            stringBuilder.append(" and cid = ? ");
            params.add(cid);
        }

        if (rname != null) {
            stringBuilder.append(" and rname = ? ");
            params.add(rname);
        }

        stringBuilder.append(" limit ?, ?");
        params.add(start);
        params.add(pageSize);

        String s = stringBuilder.toString();

        return template.query(s, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());

    }

}
