package com.demo.service.impl;

import com.demo.service.JobService;
import org.springframework.stereotype.Service;

/**
 * Created by lorne on 2017/6/12.
 */
@Service
public class JobServiceImpl implements JobService {


    @Override
    public void doing(String data) {
        System.out.println("running->"+data);
    }
}
