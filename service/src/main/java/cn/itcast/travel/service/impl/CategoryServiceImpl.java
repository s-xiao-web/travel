package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.utils.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryImpl = new CategoryImpl();

    @Override
    public List<Category> findAll() {

        List<Category> allCategory = null;

        /* 获取jedis链接 */
        Jedis jedis = JedisUtils.getJedis();

        /* jedis查询 */
        Set<Tuple> jedisCategory = jedis.zrangeWithScores("category", 0, -1);

        if (jedisCategory == null || jedisCategory.size() == 0) {
            allCategory = categoryImpl.findAll();
            for( Category item : allCategory ) {
                jedis.zadd("category", item.getCid(), item.getCname());
            }
        } else {
            allCategory = new ArrayList<Category>();
            for(Tuple tuple : jedisCategory ) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());

                allCategory.add(category);
            }
        }
        return allCategory;
    }
}
