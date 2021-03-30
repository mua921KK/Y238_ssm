<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/3/20
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页显示数据</title>
</head>
<body>
    <c:forEach items="${pageInfo.list}" var="account">
        ${account.id}------>${account.name}------>${account.age}------>${account.balance}<br/>
    </c:forEach>

<%--    <c:if test="${!pageInfo.isFirstPage}">--%>
<%--        <a href="${pageContext.request.contextPath}">--%>
<%--    </c:if>--%>

<%--    <c:forEach begin="1" end="${pageInfo.pages}" step="1" var="currentPae">--%>

<%--    </c:forEach>--%>
<%--        --%>
        <c:forEach items="${pageInfo.navigatepageNums}" var="currentPage">
        <a href="${pageContext.request.contextPath}/queryAllList?currentPage=${currentPage}">第${currentPage}页</a>
        </c:forEach>

    当前页：${pageInfo.pageNum} <br/>
    总记录数：${pageInfo.total} <br/>
    总页数：${pageInfo.pages} <br/>
    导航页码数：${pageInfo.navigatePages} <br/>

</body>
</html>
