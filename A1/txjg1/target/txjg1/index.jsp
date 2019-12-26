<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>炒茄子</h2>

顾客和服务员说：我要一个炒茄子，而服务员不负责炒茄子，她就把请求往上递交，
传递给厨师，厨师需要茄子，就把请求往上递交，传递给采购员，采购员从仓库里取来茄子传回给厨师，
厨师响应cookEggplant()方法，做好炒茄子后，又传回给服务员，服务员把茄子呈现给顾客。
要求：请使用jsp+ java bean + jdbc技术设计一个三层架构模拟上述场景，

服务员
  |
厨师
  |

<br>
<br>
<form action="/cook" method="post">
    <input type="text" value="炒茄子" hidden >
    <button type="submit" style="color: saddlebrown">点一个炒茄子</button>
</form>
<div style="color: blue">
    <%=session.getAttribute("msg")==null?"":session.getAttribute("msg")%>
</div>



</body>
</html>
