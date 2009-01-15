<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-table-td-left' >
<b><c:out value="${groupName}"/>-><c:out value="${topicName}"/></b>
</td>
<td class='portlet-link' >
<a href='groupforum.do?id=<c:out value="${groupId}"/>p1'>
<img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.button.back"/>'/></a>
</td>
</tr>
<tr>
<td class='portlet-link' colspan='3'>
<c:if test='${requestScope.pages > 1}'>
<c:forEach var="i" begin="1" end="${requestScope.pages}" step="1">
<a href='grouptopic.do?id=<c:out value="${topicId}"/>p<c:out value="${i}"/>' ><c:out value="${i}"/></a>
</c:forEach>
</c:if>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0'  width='95%'>
<c:forEach var="forum" items="${requestScope.postLists}" >
<tr valign=top>
<td class='portlet-table-td-center' width='20%'>
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.uri}"/>' ><c:out value="${forum.displayName}"/></a>
<br/>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.uri}"/>' >
<c:if test='${forum.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${forum.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${forum.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${forum.photoSmallWidth}"/>' height='<c:out value="${forum.photoSmallHeight}"/>'/>
</c:if>
</a>
<br/>
<c:if test='${forum.currentStatusId == 1 }'>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px;' height='16' width='16'  align="bottom" alt=''/>
</c:if>
<br/>
<c:out value="${forum.gender}"/>/<c:out value="${forum.age}"/>
</span>
</td>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.posted"/>: <c:out value="${forum.date}"/>

<br/><br/>
<c:out value="${forum.content}" escapeXml="false"/>
</td>
<td class='portlet-table-td-right'>

</td>
</tr>
</c:forEach>
<tr>
<td class='portlet-table-td-center' colspan='3'>
</td>
</tr>
</table>
</fmt:bundle>
</body>
</html>