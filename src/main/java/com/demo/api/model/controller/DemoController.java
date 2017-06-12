package com.demo.api.model.controller;

import com.demo.service.DemoService;
import com.lorne.core.framework.controller.IService;
import com.lorne.core.framework.controller.ITokenService;
import com.lorne.core.framework.controller.RestController;
import com.lorne.core.framework.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by lorne on 2017/6/12.
 */
@Controller
@RequestMapping("/mobile/demo")
public class DemoController extends RestController {


    @Autowired
    private DemoService demoService;


    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response){
        initEncode(request, response, new IService() {
            @Override
            public Object init(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String json) throws ServiceException {
                return demoService.login(json);
            }
        });
    }


    @RequestMapping("/list")
    public void list(HttpServletRequest request, HttpServletResponse response){
        initEncode(request, response, new ITokenService() {
            @Override
            public Object init(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Map<String, Object> sessionUser, String json) throws ServiceException {
                return demoService.list(sessionUser);
            }
        });
    }

}
