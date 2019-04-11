<%--
  Created by IntelliJ IDEA.
  User: TengSir
  Date: 2019/4/8
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

welcome:${sessionScope.user.nickname}<br/>

${sessionScope.user.username}<br/>
${sessionScope.user.password}<br/>
${sessionScope.user.sex}<br/>
${sessionScope.user.age}<br/>
<img  src="${sessionScope.user.image}"/>

</body>
</html>
