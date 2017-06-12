package demo;

import com.lorne.core.framework.utils.redis.RedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * redis工具类测试
 *
 * Created by lorne on 2017/6/12.
 */
public class RedisTest  {



    @Test
    public void redis1(){
        //获取Jedis对象
        Jedis jedis =  RedisUtil.getJedis();
        //设置值
        jedis.set("name1","hello1");
        //查询数据
        String name = jedis.get("name1");
        System.out.println(name);
        //删除值
        jedis.del("name1");
        name = jedis.get("name1");
        System.out.println(name);
        //释放对象
        RedisUtil.returnResource(jedis);
    }




    @Test
    public void redis2(){
        //设置值
        RedisUtil.set("name2","hello2");
        //查询数据
        String name = RedisUtil.get("name2");
        System.out.println(name);
        //删除值
        RedisUtil.del("name2");
        name = RedisUtil.get("name2");
        System.out.println(name);
    }


}
