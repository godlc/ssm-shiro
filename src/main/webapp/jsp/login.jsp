<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2018/4/1
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
    //System.out.println("path="+path);
    //System.out.println("basePath="+basePath);
%>
<base href="<%=basePath%>" >
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="user/login" method="post">
    用户名：<input type="text" name="username">
    密码：  <input type="password" name="password">
    <button type="submit">登录</button>
</form>

</body>
</html>
