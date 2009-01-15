<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width="98%">
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.group"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.group}" />
<input type='hidden' name='id'  value='<c:out value="${contact.id}" />'  /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.fullName"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.fullName}" />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.homePhone"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.homePhone}" />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.workPhone"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.workPhone}" />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.mobilePhone"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.mobilePhone}" /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.personalEmail"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.personalEmail}" />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.workEmail"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.workEmail}" />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.homePage"/>:
</td>
<td class='portlet-table-td-left' >
<span class='portlet-item'>
<a href='<c:out value="${contact.homePage}"/>' target="_blank" ><c:out value="${contact.homePage}" /></a>
</span>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.address"/>:
</td>
<td class='portlet-table-td-left' >
<span class='portlet-item'>
<a href='http://maps.google.com/maps?q=<c:out value="${contact.map}"/>' target="_blank" ><c:out value="${contact.address}"/></a>
</span>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.city"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.city}" />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.province"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.province}" />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.country"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.country}" />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.postalCode"/>:
</td>
<td class='portlet-table-td-left' >
<c:out value="${contact.postalCode}" />
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2'>
<input type='submit' name='<c:out value="${requestScope.contact.id}"/>' onClick="document.pressed='delete';document.parameter=this.name;" value='<fmt:message key="portlet.button.delete"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','contactId=<c:out value="${contact.id}"/>');" value='<fmt:message key="portlet.button.edit"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
