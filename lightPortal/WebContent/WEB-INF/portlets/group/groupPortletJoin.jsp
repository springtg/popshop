<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-left' >
<fmt:message key="portlet.label.joinGroup"/>:
</td>
</tr>
</table>
<br/>
<c:if test='${requestScope.success != null}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-success' >
<c:out value="${requestScope.success}"/>
</td>
</tr>
</table>
<br/>
</c:if>
<c:if test='${requestScope.error != null}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</table>
<br/>
</c:if>
<light:authenticateUser> 
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'><portlet:param name='type' value='create'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.createGroup"/></a>
</td>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'><portlet:param name='type' value='search'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/search.gif' style='border: 0px;' height='16' width='16' align="buttom"/><fmt:message key="portlet.button.searchGroup"/></a>
</td>
</tr>
</table>
</light:authenticateUser>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<c:forEach var="gc" items="${requestScope.groupCategories}" varStatus="status">
<c:if test='${status.index % 2 == 0}'>
<tr>
</c:if>
<td class='portlet-table-td-left'>
<span class='portlet-item'>
<a href='javascript:void(0)' name='<c:out value="${gc.id}"/>' onclick="document.parameter=this.name;<portlet:renderURL  portletMode='EDIT'><portlet:param name='type' value='joinDetail'/></portlet:renderURL>" >
<c:out value="${gc.displayName}"/>(<fmt:message key="portlet.label.total"/><c:out value="${gc.groupCount}"/><fmt:message key="portlet.label.groups"/>)
</a>
</span>
</td>
<c:if test='${status.index % 2 == 1}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${status.index % 2 == 0}'>
</tr>
</c:if>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-table-td-right' >
<input type='button' name='action' onClick="<portlet:renderURL  portletMode='VIEW'/>" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</fmt:bundle>
</body>
</html>