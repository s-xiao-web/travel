package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SellerImpl implements SellerDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public Seller findById(int sid) {
        String sql = "select * from tab_seller where sid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), sid);
    }
}
