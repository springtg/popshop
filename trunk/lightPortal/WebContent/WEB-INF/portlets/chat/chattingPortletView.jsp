<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL />">
<table border='0' cellpadding='0' cellspacing='0' width ='100%'>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<br/>
</td>
</tr>
<c:forEach var="record" items="${requestScope.records}" >
<tr>
<td class='portlet-table-td-right' width ='20%'>
<c:out value="${record.name}"/> <fmt:message key="portlet.label.said"/>:
</td>
<td class='portlet-table-td-left' width ='80%'>
<c:if test='${!record.systemAdd}'>
<c:out value="${record.content}"/>
</c:if>
<c:if test='${record.systemAdd}'>
<font color="#ff0000"><c:out value="${record.content}"/></font>
</c:if>
</td>
</tr>
</c:forEach>
</table>
</form>
</fmt:bundle>
</body>
</html>