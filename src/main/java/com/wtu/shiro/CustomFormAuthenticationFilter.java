package com.wtu.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by HASEE on 2018/4/1.
 * 实现验证码功能
 *需要继承FormAuthenticationFilter，改写认证方法，在认证之前实现验证码验证
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession Session = httpServletRequest.getSession();
//        取出session中的正确验证码
        String validateCode = (String) Session.getAttribute("vaildateCode");
//        取出页面的验证码
        String randomcode=httpServletRequest.getParameter("randomcode");
        if (randomcode!=null&&validateCode!=null&&!randomcode.equals(validateCode))
        {
            //如果校验失败，将验证码错误的失败信息，通过shiroLoginFailure设置到request中
            httpServletRequest.setAttribute("shiroLoginFailure","randomCodeError");

            //拒绝访问，不再校验账号和密码
            return true;

        }

        return super.onAccessDenied(request, response);
    }
}
