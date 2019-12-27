<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="javabean.FuWuYuan" %>
<html>
<body>
<h2>风味餐馆</h2>


<br>
<br>

<button type="button" value="name" onclick="javascript:location.reload()">上一道炒茄子</button>


<%
    FuWuYuan fuWuYuan = new FuWuYuan();
    String chaoqiezi = fuWuYuan.chaoqiezi();
%>
<div style="color: blue">
    <%=chaoqiezi%>
</div>





</body>
</html>
