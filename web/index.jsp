<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String cpath = request.getContextPath();
%>
<script src="jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
<link href="js/index.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>测试上传插件</title>
    <script>
        function fileupload(){
            window.location.href="<%=cpath%>/upload.do";
        }
    </script>
    <style>
        body {
            background: #333333 url("image/classy_fabric.png");
            margin: 0;
        }
    </style>
</head>

<body>

<div id='c'>
    <div class='s'></div>
    <div class='s'></div>
    <div class='s'></div>
    <div class='s'></div>
    <div class='s' onclick="fileupload();"></div>
    <div class='s' ></div>
    <div class='s'></div>
    <div class='s'></div>
    <div class='s'></div>
    <div class='s'></div>
    <div class='s'></div>
</div>
</body>
</html>  