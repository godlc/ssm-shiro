package com.wtu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HASEE on 2018/3/31.
 */
@Controller
public class LoginController {
//    @RequestMapping("/login")
//    public String login(HttpServletRequest request) throws Exception{
////        //如果登录失败就从request中获取异常信息
////        String exc = (String) request.getAttribute("shiroLoginFailure");
////        if(null!=exc){
////            if (UnknownAccountException.class.getName().equals(exc)) {
////                //最终会抛给异常处理器
//////                throw new CustomException("账号不存在");
////                System.out.print(111);
////            } else if (IncorrectCredentialsException.class.getName().equals(
////                    exc)) {
////                System.out.print(111);
//////                throw new CustomException("用户名/密码错误");
////            } else if("randomCodeError".equals(exc)){
////                System.out.print(111);
//////                throw new CustomException("验证码错误");
////            } else{
////                System.out.print(111);
////                throw new Exception();//最终在异常处理器生成未知错误
////            }
////        }
//        Factory<SecurityManager> securityManagerFactory = new IniSecurityManagerFactory();
//        SecurityManager securityManager = securityManagerFactory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
//        Subject user = SecurityUtils.getSubject();
//        String username = (String)request.getAttribute("username");
//        String password = (String)request.getAttribute("password");
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        try {
//            user.login(token);
//        }catch (AuthenticationException e){
//            e.printStackTrace();
//        }
//
//        return "/show";
//    }


}
