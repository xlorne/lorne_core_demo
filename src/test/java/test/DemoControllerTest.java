package test;

import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * Created by lorne on 2017/6/12.
 */
public class DemoControllerTest extends BaseTest {


    @Test
    public void index(){
        execute("demo/list",true, new IMapParam() {
            @Override
            public void setParams(JSONObject params) {

            }
        });
    }
}
