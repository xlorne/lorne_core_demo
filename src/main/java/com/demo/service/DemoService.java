package com.demo.service;

import com.demo.model.User;
import com.lorne.core.framework.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * Created by lorne on 2017/6/12.
 */
public interface DemoService {

    Map<String,Object> login(String json)throws ServiceException;

    List<User> list(Map<String, Object> sessionUser) throws ServiceException;
}
