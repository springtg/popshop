<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<light:authorize role="ROLE_ADMIN"> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' colspan='3'>
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT' windowState='MAXIMIZED'/>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addOrg"/></a>
<br/>
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT' windowState='MAXIMIZED'><portlet:param name='type' value='store'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addStore"/></a>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr class='portlet-table-td-left' valign='top'>
<td class='portlet-item'>
<fmt:message key="portlet.label.webId"/>
</td>
<td class='portlet-item'>
<fmt:message key="portlet.label.virtualHost"/>
</td>
<td class='portlet-item'>
<fmt:message key="portlet.label.mx"/>
</td>
</tr>

<c:forEach var="org" items="${requestScope.orgs}" >
<tr class='portlet-table-td-left'>
<td class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','orgId=<c:out value="${org.id}"/>');"><c:out value="${org.webId}"/></a>
</td>
<td class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','orgId=<c:out value="${org.id}"/>');"><c:out value="${org.virtualHost}"/></a>
</td>
<td class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','orgId=<c:out value="${org.id}"/>');"><c:out value="${org.mx}"/></a>
</td>
</tr>
</c:forEach>
</table>
</form>
</fmt:bundle>
</light:authorize>
</body>
</html>