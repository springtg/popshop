<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<light:authenticateOwner> 
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-link-left' colspan='3'>
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'  windowState='MAXIMIZED'/>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addContact"/></a>
</td>
<td class='portlet-link-left'>
<c:if test='${requestScope.groups != null}'>
<c:forEach var="grp" items="${requestScope.groups}">
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','group=<c:out value="${grp}"/>');"><c:out value="${grp}"/></a>
</c:forEach>
</c:if>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','');">All</a>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr valign='top'>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.name"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.phone"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.email"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.address"/></td>
</tr>
<c:forEach var="contact" items="${requestScope.contacts}" varStatus="status">
<c:if test='${status.index % 2 == 0}'>
<tr class='portlet-item' valign='top'>
</c:if>
<c:if test='${status.index % 2 == 1}'>
<tr class='portlet-itemEven' valign='top'>
</c:if>
<td>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','contactId=<c:out value="${contact.id}"/>');"><c:out value="${contact.fullName}"/></a>
</td>
<td>
<a href='callto:<c:out value="${contact.phone}"/>' ><c:out value="${contact.phone}"/></a>
</td>
<td>
<a href='mailto:<c:out value="${contact.email}"/>' ><c:out value="${contact.email}"/></a>
</td>
<td>
<a href='http://maps.google.com/maps?q=<c:out value="${contact.map}"/>' target='_blank' ><c:out value="${contact.address}"/></a>
</td>
<td class='portlet-table-td-right'>
<input type="image" src="light/images/deleteLink.gif" title='<fmt:message key="portlet.button.delete"/> <c:out value="${contact.fullName}"/>'align='bottom' style='border: 0px;' height='11' width='11' name="<c:out value='${contact.id}'/>" onClick="document.pressed='delete';document.parameter=this.name;"/>
</td>
</tr>
</c:forEach>
</table>
</form>
</light:authenticateOwner>
</fmt:bundle>
</body>
</html>