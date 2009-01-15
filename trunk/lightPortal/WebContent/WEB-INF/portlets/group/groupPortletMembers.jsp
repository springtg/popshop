<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<fmt:message key="portlet.label.thisGroup"/> <c:out value="${requestScope.memberCount}"/> <fmt:message key="portlet.label.members"/>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<c:forEach var="buddy" items="${requestScope.groupMembers}" varStatus="status">
<c:if test='${status.index % 5 == 0}'>
<tr valign='top'>
</c:if>
<td class='portlet-table-td-center'>
<c:if test='${buddy.userPhotoUrl == null}'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.userUri}"/>' target="_blank">
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</a>
</c:if>
<c:if test='${buddy.userPhotoUrl != null}'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.userUri}"/>' target="_blank">
<img src='<%= request.getContextPath() %><c:out value="${buddy.userPhotoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${buddy.userPhotoSmallWidth}"/>' height='<c:out value="${buddy.userPhotoSmallHeight}"/>'/>
</a>
</c:if>
<br/>
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.userUri}"/>' target="_blank"><c:out value="${buddy.userDisplayName}"/></a>
<br/>
<c:if test='${buddy.userCurrentStatusId == 1}'>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px'  align="bottom" alt=''/>
</c:if>
<br/>
<c:if test='${buddy.userCurrentStatusId == 1 }'>
<a href='javascript:void(0)' onclick="javascript:showInstantMessageMember(event,'<c:out value="${buddy.userId}"/>','<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.instantMessage"/></a>
<br/>
</c:if>
<c:if test='${buddy.userCurrentStatusId != 1}'>
<br/>
</c:if>
<a href='javascript:void(0)' onclick="javascript:showSendMessageMember('<c:out value="${buddy.userId}"/>');" ><fmt:message key="portlet.label.sendMessage"/></a>
</span>
</td>
<c:if test='${status.index % 5 == 4}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.memberCount % 5 != 0}'>
</tr>
</c:if>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr>
<td class='portlet-table-td-right'>
</td>
</tr>
</table>
</fmt:bundle>
</body>
</html>