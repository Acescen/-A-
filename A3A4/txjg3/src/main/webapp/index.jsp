<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="javabean.User" %>
<%@ page import="javabean.Record" %>
<%@ page import="javabean.UserOpt" %>
<html>
<title>添加用户</title>
<body>
<%
    UserOpt userOpt = new UserOpt();
    userOpt.addUser();
%>
<button type="button" value="name" onclick="javascript:location.reload()">添加用户</button>


<%
    List<User> users = userOpt.getUsers();
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
    List<Record> records = userOpt.getRecords();
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
