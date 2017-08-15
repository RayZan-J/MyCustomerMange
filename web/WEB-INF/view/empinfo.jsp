
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String cpath = request.getContextPath();
%>
<script src="<%=cpath%>/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
<link href="<%=cpath%>/js/table.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title></title>
</head>
<body>
  <div>
    <table class="well">
      <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>职位</th>
        <th>薪资</th>
      </tr>
      <tr>
        <td>1</td>
        <td>姓名</td>
        <td>职位</td>
        <td>薪资</td>
      </tr>
    </table>
  </div>
</body>
</html>
