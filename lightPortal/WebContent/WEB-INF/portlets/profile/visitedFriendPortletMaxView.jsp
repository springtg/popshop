<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<fmt:message key="portlet.label.youHave"/> <c:out value="${requestScope.buddyCount}"/> <fmt:message key="portlet.label.friends"/>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<tr>
<c:forEach var="buddy" items="${requestScope.buddys}" >
<td class='portlet-table-td-left' width='220'>
<c:if test='${buddy.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${buddy.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${buddy.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${buddy.photoSmallWidth}"/>' height='<c:out value="${buddy.photoSmallHeight}"/>'/>
</c:if>
</td>
<td class='portlet-table-td-left'>
<span class='portlet-item'>
<c:if test='${buddy.buddyCurrentStatusId == 1}'>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px' width='15' height='12' align="bottom" alt=''/>
</c:if>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.uri}"/>' ><c:out value="${buddy.displayName}"/></a>
</span>
<br/>
</td>
</c:forEach>
</tr>
</table>
</fmt:bundle>
</body>
</html>