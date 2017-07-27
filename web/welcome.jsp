<%--
  Created by IntelliJ IDEA.
  User: zll
  Date: 2017/7/26 0026
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="js/simple.css" rel="stylesheet" type="text/css">
<script src="jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
<html>
<head>
  <title>客户管理系统登录界面</title>
  <script>

    function change(id){
      document.getElementById(id).style.background="white";
    }
    function changebk(id){
      if($("#"+id).val() ===""){
        document.getElementById(id).style.background="transparent";
      }
    }
  </script>
</head>
<body style="text-align: center" >
<div style="padding: 273px 0 0 8px">
  <form>
    <div style="padding-top: 1px">
      <input type="text" name="username" value="" id="username" title="用户名"
             style="width:282px;height:40px;margin: 0;padding: 0;border: 0;
             background-color: transparent;cursor: text;border-radius: .5em;" onkeypress="change($(this).attr('id'))"
             onchange="changebk($(this).attr('id'))"/>
    </div>
    <div style="padding-top: 13px">
      <input type="password" name="password" value="" id="password" title="密码君"
             style="width:282px;height:40px;margin: 0;padding: 0;border: 0;
             background-color: transparent;cursor: text;border-radius: .5em;" onkeypress="change($(this).attr('id'))"
             onchange="changebk($(this).attr('id'))"/>
    </div>
    <div style="padding-top: 16px">
      <input type="button" name="password" value="" id="bt1" title="黄黄的按钮"
             style="width:282px;height:40px;margin: 0;padding: 0;border: 0;
             cursor: text;border-radius: .1em;
             " onclick="submit()"
             />
    </div>


    <%--<tr >--%>
    <%--<td style="text-align: left;"><span style="color: RED">*</span>用户名：</td>--%>
    <%--<td><input type="text" name="username" value="" id="username" title="title"/></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
    <%--<td style="text-align: left;"><span style="color: RED">*</span>密码：</td>--%>
    <%--<td><input type="password" name="password" value="" id="password" title="title"/></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
    <%--<td><button name="bt1" id="bt1" onclick="" class="btn">&nbsp;登录&nbsp;</button></td>--%>
    <%--<td><button name="bt2" id="bt2" onclick="" class="btn">重置密码</button></td>--%>
    <%--</tr>--%>


  </form>
</div>
</body>
</html>
