package com.demo.service.impl;

import com.demo.Constant;
import com.demo.service.InitService;
import com.demo.service.JobService;
import com.lorne.core.framework.job.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lorne on 2017/6/12.
 */
@Service
public class InitServiceImpl implements InitService {


    @Autowired
    private SchedulerService schedulerService;


    @Autowired
    private JobService jobService;

    @Override
    public void start() {
        Constant.jobService = jobService;
        schedulerService.start();
    }

    @Override
    public void close() {
        schedulerService.close();
    }
}
