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
<b><c:out value="${categoryName}"/></b>
</td>
<td class='portlet-link' >
<a href='viewcategories.do'><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.button.back"/>'/></a>
</td>
</tr>
</table>
<c:if test='${requestScope.forumLists != null}'>
<table border='0' cellpadding='0' cellspacing='0'  width='98%'>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.forum"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.topics"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.posts"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.lastPost"/></td>
</tr>
<c:forEach var="item" items="${requestScope.forumLists}" >
<tr class='portlet-table-td-left'>
<td class='portlet-item' >
<table>
<tr class='portlet-table-td-left'>
<td>
<a href='viewforum.do?id=<c:out value="${item.id}"/>'>
<img src='<%= request.getContextPath() %>/light/images/folder.gif' style='border: 0px;'  align="top" />
</a>
<br/>
</td>
<td class='portlet-item'>
<a href='viewforum.do?id=<c:out value="${item.id}"/>p1'>
<c:out value="${item.name}"/></a>
<br/><c:out value="${item.desc}"/>
</td>
</tr>
</table>
</td>
<td class='portlet-item' >
<c:out value="${item.topics}"/>
</td>
<td class='portlet-item' >
<c:out value="${item.posts}"/>
</td>
<td class='portlet-item'>
<c:if test='${item.lastForumId  != null}'>
<c:out value="${item.lastForum.date}"/>
<br/><fmt:message key="portlet.label.postedBy"/>  
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${item.lastForum.uri}"/>' ><c:out value="${item.lastForum.displayName}"/></a>
>> 
<a href='viewtopic.do?id=<c:out value="${item.lastForum.topicId}"/>p1'>
<fmt:message key="portlet.label.viewPost"/>
</a>
</c:if>
</td>
</tr>
</c:forEach>
</table>
</c:if>

</fmt:bundle>
</body>
</html>