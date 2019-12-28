<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="javabean.User" %>
<%@ page import="javabean.Record" %>
<html>
<title>添加用户</title>
<body>
<form action="/addUser" method="post">
    账号：<input type="text" name="username">
    姓名：<input type="text" name="name">
    密码：<input type="password" name="password">
    <button type="submit">添加</button>
</form>
<div style="color: red">
    <%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>
</div>

<%
    //List<User> users = (List<User>) request.getAttribute("users");
    List<User> users = (List<User>) request.getAttribute("users");
    if (users != null) {
%>
所有用户信息：<br>
<table border=1 width="100%">
    <tr>
        <td align="center">Id
        </td>
        <td align="center">账号
        </td>
        <td align="center">姓名
        </td>
        <td align="center">密码
        </td>
    </tr>
    <%
        for (int i = 0; i < users.size(); i++) {
    %>
    <tr>
        <td align="center"><%=users.get(i).getId()%>
        </td>
        <td align="center"><%=users.get(i).getUsername()%>
        </td>
        <td align="center"><%=users.get(i).getName()%>
        </td>
        <td align="center"><%=users.get(i).getPassword()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<%
}
%>
<br>
<br>
<br>


<%
    List<Record> records = (List<Record>) request.getAttribute("records");
    if (records != null) {
%>
添加记录信息：<br>
<table border=1 width="100%">
    <tr>
        <td align="center">Id
        </td>
        <td align="center">添加的账号
        </td>
        <td align="center">添加的姓名
        </td>
        <td align="center">添加时间
        </td>
    </tr>
    <%
        for (int i = 0; i < records.size(); i++) {
    %>
    <tr>
        <td align="center"><%=records.get(i).getId()%>
        </td>
        <td align="center"><%=records.get(i).getUsername()%>
        </td>
        <td align="center"><%=records.get(i).getName()%>
        </td>
        <td align="center"><%=records.get(i).getCreatetime()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<%
    }
%>
</body>
</html>
