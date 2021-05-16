package cn.itcast.travel.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtils {

    private static JedisPool jedisPool;

    static {

        InputStream rs = JedisUtils.class.getClassLoader().getResourceAsStream("Jedis.properties");

        Properties ps = new Properties();

        try {
            ps.load(rs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(ps.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(ps.getProperty("maxIdle")));

        jedisPool = new JedisPool(config, ps.getProperty("host"), Integer.parseInt(ps.getProperty("port")));

    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
