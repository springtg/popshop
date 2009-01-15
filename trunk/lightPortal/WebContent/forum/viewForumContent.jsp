<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<c:if test='${requestScope.success != null}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-success' >
<c:out value="${requestScope.success}" escapeXml="false"/>
</td>
</tr>
</table>
</c:if>
<c:if test='${requestScope.error != null}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
<c:out value="${requestScope.error}" escapeXml="false"/>
</td>
</tr>
</table>
</c:if>

<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-table-td-left' >
<b><c:out value="${categoryName}"/>-><c:out value="${forumName}"/></b>
</td>
<td class='portlet-link' >
<a href='viewcategory.do?id=<c:out value="${categoryId}"/>'>
<img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.button.back"/>'/></a>
</td>
</tr>
<tr>
<td class='portlet-link' colspan='3'>
<c:if test='${requestScope.pages > 1}'>
<c:forEach var="i" begin="1" end="${requestScope.pages}" step="1">
<a href='viewforum.do?id=<c:out value="${forumId}"/>p<c:out value="${i}"/>' ><c:out value="${i}"/></a>
</c:forEach>
</c:if>
</td>
</tr>
</table>
<c:if test='${requestScope.topicLists != null}'>
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.forumTopic"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.posts"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.lastPost"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.topicStarter"/></td>
</tr>
<c:forEach var="forum" items="${requestScope.topicLists}" >
<tr class='portlet-table-td-left'>
<td class='portlet-item' >
<a href='viewtopic.do?id=<c:out value="${forum.id}"/>p1'>
<img src='<%= request.getContextPath() %>/light/images/folder_smll.gif' style='border: 0px;'  align="top" />
<c:out value="${forum.topic}"/></a>
</td>
<td class='portlet-item' >
<c:out value="${forum.posts}"/>
</td>
<td class='portlet-item'>
<table>
<tr>
<td>
<c:if test='${forum.lastPhotoUrl == null}'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.lastUri}"/>' ><img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='50' height='50'/></a>
</c:if>
<c:if test='${forum.lastPhotoUrl != null}'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.lastUri}"/>' ><img src='<%= request.getContextPath() %><c:out value="${forum.lastPhotoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${forum.lastPhotoSmallWidth / 4}"/>' height='<c:out value="${forum.lastPhotoSmallHeight / 4}"/>'/></a>
</c:if>
</td>
<td class='portlet-table-td-left'>
<c:out value="${forum.lastDate}"/>
<br/>by 
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.lastUri}"/>' ><c:out value="${forum.lastDisplayName}"/></a>
</td>
</tr>
</table>
</td>
<td class='portlet-item'>
<table>
<tr>
<td>
<c:if test='${forum.photoUrl == null}'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.uri}"/>' ><img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='50' height='50'/></a>
</c:if>
<c:if test='${forum.photoUrl != null}'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.uri}"/>' ><img src='<%= request.getContextPath() %><c:out value="${forum.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${forum.photoSmallWidth / 4}"/>' height='<c:out value="${forum.photoSmallHeight / 4}"/>'/></a>
</c:if>
</td>
<td class='portlet-table-td-left'>
<c:out value="${forum.date}"/>
<br/>by 
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.uri}"/>' ><c:out value="${forum.displayName}"/></a>
</td>
</tr>
</table>
</td>
</tr>
</c:forEach>
</table>
</c:if>

</fmt:bundle>
</body>
</html>