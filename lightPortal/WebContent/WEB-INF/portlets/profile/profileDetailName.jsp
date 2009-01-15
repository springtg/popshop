<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="profileDetailHeader.jsp" ></jsp:include>
<br/>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL/>">
<table border='0' cellpadding='0' cellspacing='0' width='80%'>
<tr valign="middle">
<td class='portlet-table-td-right'><fmt:message key="portlet.label.displayName"/>:</td>
<td class='portlet-table-td-left'>
<input type='text' name='displayName' class='portlet-form-input-field' size='60' value='<c:out value="${requestScope.user.displayName}"/>'/>
</td>
</tr>
<br/>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.fullName"/>: </td>
<td class='portlet-table-td-left'>
<input type='text' name='firstName' value='<c:out value="${requestScope.userProfile.firstName}"/>' class='portlet-form-input-field' size='60' /> 
</td>
</tr>
</table>

<table border='0' cellpadding='0' cellspacing='0' width='80%'>
<tr>
<td class='portlet-table-td-right'>
<input type='submit' name='action' onClick="document.pressed='name'" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>