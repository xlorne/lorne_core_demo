package demo;

import com.lorne.core.framework.utils.math.MathDecimal;
import com.lorne.core.framework.utils.math.MathUtils;
import org.junit.Test;

/**
 *
 * MathUtils 测试类
 * Created by lorne on 2017/6/12.
 */
public class MathTest {

    @Test
    public void test(){
        double a = 12.56;
        double b = 2.44;

        double c = a-b;

        System.out.println(c);


        System.out.println(MathUtils.sub(a,b));

        MathDecimal decimal = new MathDecimal(a).sub(b);
        System.out.println(decimal.toDouble());

    }
}
