package com.wtu.controller;

import com.wtu.shiro.CustomRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by HASEE on 2018/4/1.
 */
@Controller
public class ClearShiroCache {
    @Autowired
    protected CustomRealm customRealm;

    @RequestMapping("/clearShiroCache")
    @ResponseBody
    public String clearShiroCache(){
        customRealm.clearCached();
        return "success";
    }
}
