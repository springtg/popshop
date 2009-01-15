<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
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
<c:if test='${requestScope.state == "normal" && requestScope.showMore != null }'>
	<span class="portlet-rss" style="text-align:right;">
	<a href='javascript:void(0)' onclick="<portlet:renderURL  windowState='MAXIMIZED'/>" >more......</a> 
	</span>
</c:if>
</fmt:bundle>
</body>
</html>