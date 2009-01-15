<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0'  width='95%'>
<tr>
<td class='portlet-table-td-left'>
<c:out value="${blog.title}" escapeXml="false"/>
</td>
</tr>
<tr valign=top>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.posted"/>: <c:out value="${blog.date}"/> By 
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${blog.uri}"/>' ><c:out value="${blog.displayName}"/></a>
</span>
<br/><br/>
</tr>
<tr>
<td class='portlet-table-td-left'>
<c:out value="${blog.summary}" escapeXml="false"/>
<br/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<c:out value="${blog.content}" escapeXml="false"/>
</td>
</tr>
</table>

<table border='0' cellpadding='0' cellspacing='0'  width='95%'>
<tr>
<td class='portlet-table-td-left'>
<br/>
<br/>
<fmt:message key="portlet.label.comments"/>:
<br/>
<hr/>
</td>
</tr>
<c:forEach var="item" items="${requestScope.comments}" varStatus="status">
<tr valign=top>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.posted"/>: <c:out value="${item.date}"/> By 
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${item.uri}"/>' ><c:out value="${item.displayName}"/></a>
</span>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<c:out value="${item.comment}" escapeXml="false"/>
<hr/>
</td>
</tr>
</c:forEach>
</table>
</fmt:bundle>
</body>
</html>