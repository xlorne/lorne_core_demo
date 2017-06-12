package com.demo.job;

import com.demo.Constant;
import com.lorne.core.framework.job.BaseJob;

/**
 * Created by lorne on 2017/6/12.
 */
public class DemoJob extends BaseJob {

    @Override
    public void execute(String data) {
        Constant.jobService.doing(data);
    }
}
