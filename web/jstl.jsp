<%--
  Created by IntelliJ IDEA.
  User: TengSir
  Date: 2019/3/25
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${requestScope.age mod 25}
<C:out value="${requestScope.age mod 25}"></C:out>
<C:set var="aaa" value="23" scope="session"></C:set>

<C:if test="${requestScope.sex eq 0}">男</C:if>
<C:if test="${requestScope.sex ne 0}">女</C:if>

<C:choose>
    <C:when test="${requestScope.score ge 90}">优</C:when>
    <C:when test="${requestScope.score ge 80}">良</C:when>
</C:choose>
<C:forEach items="${requestScope.blogs}" var="b" begin="2" end="3" step="2" varStatus="o">
    o.index  o.count
    ${o.index}
    ${o.count}
    ${b.title}
    ${b.content}

</C:forEach>
</body>
</html>
