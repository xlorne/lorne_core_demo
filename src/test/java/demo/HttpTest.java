package demo;

import com.lorne.core.framework.utils.http.HttpUtils;
import com.lorne.core.framework.utils.http.PostFileParam;
import com.lorne.core.framework.utils.http.PostParam;
import com.lorne.core.framework.utils.redis.RedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.File;

/**
 * http工具类测试
 *
 * Created by lorne on 2017/6/12.
 */
public class HttpTest {



    @Test
    public void get(){
        String url = "https://www.baidu.com";
        String res = HttpUtils.get(url);
        System.out.println(res);
    }



    @Test
    public void post1(){
        String url = "http://weibo.com/login.php";
        String res = HttpUtils.post(url,"name=123&pwd=123");
        System.out.println(res);
    }

    @Test
    public void post2(){
        String url = "http://weibo.com/login.php";
        String res = HttpUtils.post(url,new PostParam("name","123"),new PostParam("pwd","123"));
        System.out.println(res);
    }

    @Test
    public void postFile(){
        String url = "http://weibo.com/login.php";
        String res = HttpUtils.postFile(url,new PostFileParam("file",new File("/test/123.jpg")));
        System.out.println(res);
    }

    @Test
    public void postXml(){
        String url = "http://weibo.com/login.php";
        String res = HttpUtils.postXml(url,"<xml>haha</xml>");
        System.out.println(res);
    }


    @Test
    public void postJson(){
        String url = "http://weibo.com/login.php";
        String res = HttpUtils.postJson(url,"{\"xml\":\"haha\"}");
        System.out.println(res);
    }


    @Test
    public void download(){
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497271444708&di=e03419f51d204ccd964e584ca4c3f3c5&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F61%2F00%2F61a58PICtPr_1024.jpg";
        boolean res = HttpUtils.download(url,"/test/123.jpg");
        System.out.println(res);
    }


}
