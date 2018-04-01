package com.wtu.controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.wtu.model.User;
import com.wtu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * User类的控制器, 视图显示
 *
 * menglanyingfei
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        // 应该这样输入/user/showUser?id=1
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);model.addAttribute("user", user);
        model.addAttribute("user", user);
        return "/show";
    }

    @RequestMapping("/showUser1")
    public ModelAndView home(HttpServletRequest request, Model model) {
        // 应该这样输入/user/showUser1?id=1
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);

        ModelAndView mav = new ModelAndView();

        mav.setViewName("/showUser");

        return mav;
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request) throws Exception{
//        //如果登录失败就从request中获取异常信息
//        String exc = (String) request.getAttribute("shiroLoginFailure");
//        if(null!=exc){
//            if (UnknownAccountException.class.getName().equals(exc)) {
//                //最终会抛给异常处理器
////                throw new CustomException("账号不存在");
//                System.out.print(111);
//            } else if (IncorrectCredentialsException.class.getName().equals(
//                    exc)) {
//                System.out.print(111);
////                throw new CustomException("用户名/密码错误");
//            } else if("randomCodeError".equals(exc)){
//                System.out.print(111);
////                throw new CustomException("验证码错误");
//            } else{
//                System.out.print(111);
//                throw new Exception();//最终在异常处理器生成未知错误
//            }
//        }
        Factory<SecurityManager> securityManagerFactory = new IniSecurityManagerFactory();
        SecurityManager securityManager = securityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject user = SecurityUtils.getSubject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            user.login(token);
        }catch (AuthenticationException e){
            e.printStackTrace();
        }

        return "/show";
    }

}