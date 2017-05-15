<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html; charset=UTF-8">
    <title>查询上商品列表</title>
</head>
<body>
当前用户:${username}
<c:if test="${username!=null}">
    <a href="${pageContext.request.contextPath}/logout">退出</a>
</c:if>
<form action="${pageContext.request.contextPath}/queryActor.action" method="post">
    <table width="100%" border=1>
        <tr>
            <td>
                <input type="submit" value="查询">
            </td>
        </tr>
    </table>
    商品列表:
    <table width="100%" border=1>
        <tr>
            <td>编号</td>
            <td>FirstName</td>
            <td>LastName</td>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.actorId}</td>
                <td>${item.firstName}</td>
                <td>${item.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</form>
<h2>Hello World!</h2>
</body>
</html>
