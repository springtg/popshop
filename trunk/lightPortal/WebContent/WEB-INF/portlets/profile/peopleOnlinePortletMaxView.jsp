<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL />">
<c:if test='${requestScope.pages > 1}'>
<table border='0' cellpadding='0' cellspacing='0'  width='95%'>
<tr>
<td class='portlet-table-td-right'>
<c:out value="${start}"/> - <c:out value="${end}"/> (<c:out value="${total}"/>)
<span class="portlet-item">
<c:if test='${page > 1}'>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','page=<c:out value="${requestScope.page - 1}"/>');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.label.previous"/>'/></a>						
</c:if>
<c:forEach var="i" begin="1" end="${requestScope.pages}" step="1">
<c:if test='${i != page}'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','page=<c:out value="${i}"/>;pages=<c:out value="${pages}"/>');" ><c:out value="${i}"/></a>
</c:if>
<c:if test='${i == page}'>
<c:out value="${i}"/>
</c:if>
</c:forEach>
<c:if test='${page < pages}'>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','page=<c:out value="${requestScope.page + 1}"/>');"><img src='<%= request.getContextPath() %>/light/images/next.gif' style='border: 0px' title='<fmt:message key="portlet.label.previous"/>'/></a>						
</c:if>
</span>
</td>
</tr>
</table>
</c:if>

<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<c:forEach var="profile" items="${requestScope.onlinePeople}" varStatus="status">
<c:if test='${status.index % 10 == 0}'>
<tr valign='top' class='portlet-table-td-center'>
</c:if>
<td class='portlet-table-td-center'>
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${profile.uri}"/>' ><c:out value="${profile.displayName}"/></a>
</span>
<br/>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${profile.uri}"/>' >
<c:if test='${profile.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='40' height='30'/>
</c:if>
<c:if test='${profile.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${profile.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${profile.photoSmallWidth / 4}"/>' height='<c:out value="${profile.photoSmallHeight / 4}"/>'/>
</c:if>
</a>
</td>
<c:if test='${status.index % 10 == 9}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.userCount % 10 != 0}'>
</tr>
</c:if>
</table>
</form>
</fmt:bundle>
</body>
</html>