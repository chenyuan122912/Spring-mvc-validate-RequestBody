package com.cloudeport.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 控制器的基类，将公共方法写在这个类中
 * 
 * @author yi.yuy
 */

public abstract class BaseController {
    private static final Logger   logger         = Logger.getLogger(BaseController.class);
    protected static final String PAGE_403       = "/error/403.jsp";
    protected static final String PAGE_500       = "/error/500.jsp";
    protected static final String SUCCESS_MSG    = "OK";                                  // 成功信息
    protected static final String SUCCESS_STATUS = "200";                                 // 成功信息
    protected static final boolean IS_PAGE = true; // 分页
    protected static final boolean NOT_PAGE = false; // 不分页
    protected static final String SUCCESS = "200";
    protected static final String FAILURE = "400";

    
    public Object buildSuccess() {
        return buildSuccess(SUCCESS_MSG);
    }
    
    public Object buildSuccess(String msg) {
        return buildResult(SUCCESS, null, msg, null);
    }
    
    public Object buildSuccess(Object data, String msg) {
        return buildResult(SUCCESS, data, msg, null);
    }
    
    public Object buildFailure(String msg) {
        return buildResult(FAILURE, null, msg, null);
    }
    
    protected Object buildResult(String status, Object data,String msg, Object summary) {
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("status", status);
        if (null != msg) {
            root.put("msg", msg);
        }
        if (null != data) {
            root.put("data", data);
        }
        if (null != summary) {
            root.put("summary", summary);
        }
        return root;
     }
}
