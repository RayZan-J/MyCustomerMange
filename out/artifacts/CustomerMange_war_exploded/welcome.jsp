<%--
  Created by IntelliJ IDEA.
  User: zll
  Date: 2017/7/26 0026
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="js/simple.css">
<html>
<head>
  <title>客户管理系统登录界面</title>
</head>
<body style="text-align: center">
<h1 style="text-align: center">欢迎登录用户管理系统</h1>
<div style="height: 60%;text-align: center;width: 100%;">
  <form>

    <table style="margin:15% auto ">
      <tr >
        <td style="text-align: left;"><span style="color: RED">*</span>用户名：</td>
        <td><input type="text" name="username" value="" id="username" title="title"/></td>
      </tr>
      <tr>
        <td style="text-align: left;"><span style="color: RED">*</span>密码：</td>
        <td><input type="password" name="password" value="" id="password" title="title"/></td>
      </tr>
      <tr>
        <td><button name="bt1" id="bt1" onclick="" class="btn">&nbsp;登录&nbsp;</button></td>
        <td><button name="bt2" id="bt2" onclick="" class="btn">重置密码</button></td>
      </tr>
    </table>

  </form>
</div>
</body>
</html>
