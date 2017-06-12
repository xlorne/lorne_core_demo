package com.demo.service.impl;

import com.demo.model.User;
import com.demo.service.DemoService;
import com.demo.utils.SessionUtils;
import com.lorne.core.framework.exception.ServiceException;
import com.lorne.core.framework.utils.TokenUtils;
import com.lorne.core.framework.utils.json.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lorne on 2017/6/12.
 */
@Service
public class DemoServiceImpl implements DemoService {


    @Override
    public Map<String, Object> login(String json) throws ServiceException {
        Map<String, Object> res = new HashMap<>();
        String name = JsonUtils.getString(json,"name","");
        String pwd = JsonUtils.getString(json,"pwd","");

        if(StringUtils.isEmpty(name)){
            throw new ServiceException("用户名不能为空.");
        }

        if(StringUtils.isEmpty(pwd)){
            throw new ServiceException("密码不能为空.");
        }

        if(name.equals("admin")&&pwd.equals("admin")){

            Map<String,Object> sessionUser = new HashMap<>();
            sessionUser.put("name",name);
            sessionUser.put("pwd",pwd);

            String token = TokenUtils.putValue(sessionUser,60*2);

            res.put("token",token);
            res.put("name",name);
            return res;

        }else{
            throw new ServiceException("用户名或密码不正确.");
        }
    }


    @Override
    public List<User> list(Map<String, Object> sessionUser) throws ServiceException {
        List<User> list = new ArrayList<>();
        list.add(createUser(sessionUser));
        list.add(createUser(sessionUser));
        list.add(createUser(sessionUser));
        list.add(createUser(sessionUser));
        list.add(createUser(sessionUser));
        list.add(createUser(sessionUser));
        list.add(createUser(sessionUser));
        list.add(createUser(sessionUser));
        list.add(createUser(sessionUser));
        return list;
    }

    private User createUser(Map<String, Object> sessionUser) {
        User user = new User();
        user.setName(SessionUtils.getName(sessionUser));
        user.setPwd(SessionUtils.getPwd(sessionUser));
        return user;
    }
}
