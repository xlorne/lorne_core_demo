package demo;

import com.lorne.core.framework.utils.config.ConfigHelper;
import com.lorne.core.framework.utils.config.ConfigUtils;
import org.junit.Test;

/**
 * configUtils工具类测试
 *
 * Created by lorne on 2017/6/12.
 */
public class ConfigTest {




    @Test
    public void config(){
        String url = ConfigUtils.getString("quartz.properties","org.quartz.dataSource.myDS.URL");
        System.out.println(url);


        ConfigHelper helper = new ConfigHelper("redis.properties");
        helper.setProperty("new-name","123");
        String name = helper.getStringValue("new-name");
        System.out.println(name);
        helper.setProperty("new-name","1234");
        name = helper.getStringValue("new-name");
        System.out.println(name);

    }


}
