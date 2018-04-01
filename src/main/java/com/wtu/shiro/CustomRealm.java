package com.wtu.shiro;

import com.wtu.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HASEE on 2018/3/31.
 * 查询权限和认证
 */
public class CustomRealm extends AuthorizingRealm {
    //设置realm的名称
    public void setName(String name){
        super.setName("customRealm");
    }
    //用于认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //token 是用户登录的
        //第一步从token中取出身份信息
        String userCode = (String)token.getPrincipal();
        //根据用户输入的userName从数据库查询
        //模拟从数据库查询到的密码
        String password = "122";

        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(userCode, password, this.getName());
        return simpleAuthenticationInfo;
    }
    //用于授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从pricipalCollection中取得身份信息
        //User user = (User) principalCollection.getPrimaryPrincipal();
        //从数据库中获取可以有的权限
        List<String> permissions = new ArrayList<>();
        permissions.add("user:create");
        permissions.add("item:query");
        permissions.add("item:add");
        permissions.add("item:edit");
        //查到权限信息，返回授权信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;

    }
    //清除缓存
    public void clearCached(){
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);

    }
}