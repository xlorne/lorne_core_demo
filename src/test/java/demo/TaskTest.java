package demo;

import com.lorne.core.framework.utils.KidUtils;
import com.lorne.core.framework.utils.task.ConditionUtils;
import com.lorne.core.framework.utils.task.IBack;
import com.lorne.core.framework.utils.task.Task;
import org.junit.Test;

/**
 *
 * Task 使用教程
 * Created by lorne on 2017/6/12.
 */
public class TaskTest {

    @Test
    public void test(){

        //创建一个key，用来生成Task
        final String key = KidUtils.getKid();

        //创建Task
        Task task = ConditionUtils.getInstance().createTask(key);

        //启用线程处理业务
        new Thread(){
            @Override
            public void run() {
                super.run();

                //通过唯一key拿到创建的task，给他赋值数据
                Task task = ConditionUtils.getInstance().getTask(key);
                task.setBack(new IBack() {
                    @Override
                    public Object doing(Object... objects) throws Throwable {
                        return "hello";
                    }
                });

                //唤醒task任务
                task.signalTask();
            }

        }.start();

        //task等待
        task.awaitTask();

        try {
            //task执行业务
            System.out.println(task.getBack().doing());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            //删除task任务
            task.remove();
        }
    }
}
