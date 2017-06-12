package demo;

import com.lorne.core.framework.utils.thread.CountDownLatchHelper;
import com.lorne.core.framework.utils.thread.IExecute;
import org.junit.Test;

import java.util.List;

/**
 * Thread 测试
 * Created by lorne on 2017/6/12.
 */
public class ThreadTest {

    @Test
    public void test(){

        //创建对象 指定返回数据为Long类型
        CountDownLatchHelper<Long> countDownLatchHelper = new CountDownLatchHelper<>();

        //线程处理1
        countDownLatchHelper.addExecute(new IExecute<Long>() {
            @Override
            public Long execute() {
                System.out.println(""+Thread.currentThread().getId());
                return Thread.currentThread().getId();
            }
        });

        //线程处理2
        countDownLatchHelper.addExecute(new IExecute<Long>() {
            @Override
            public Long execute() {
                System.out.println(""+Thread.currentThread().getId());
                return Thread.currentThread().getId();
            }
        });
        //线程处理3
        countDownLatchHelper.addExecute(new IExecute<Long>() {
            @Override
            public Long execute() {
                System.out.println(""+Thread.currentThread().getId());
                return Thread.currentThread().getId();
            }
        });

        //执行全部线程并汇总返回数据
        List<Long> list = countDownLatchHelper.execute().getData();

        System.out.println(list);

    }
}
