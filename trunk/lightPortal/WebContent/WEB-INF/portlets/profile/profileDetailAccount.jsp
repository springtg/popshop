<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="profileDetailHeader.jsp" ></jsp:include>
<br/>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL/>">
<table border='0' cellpadding='0' cellspacing='0' width='50%'>
<tr>
<td class='portlet-table-td-right'>*<fmt:message key="portlet.label.userPassword"/>: </td>
<td class='portlet-table-td-left'>
<input type='password' name='password' value='' class='portlet-form-input-field' size='18' />	
</td>
</tr>
<tr>
<td class='portlet-table-td-right'>*<fmt:message key="portlet.label.newPassword"/>: </td>
<td class='portlet-table-td-left'>
<input type='password' name='newPassword' value='' class='portlet-form-input-field' size='18' />	
</td>
</tr>
<tr>
<td class='portlet-table-td-right'>*<fmt:message key="portlet.label.confirmPassword"/>:</td>
<td class='portlet-table-td-left'>
<input type='password' name='confirmPassword' value='' class='portlet-form-input-field' size='18' /> 
</td>
</tr>
</table>

<table border='0' cellpadding='0' cellspacing='0' width='60%'>
<tr>
<td class='portlet-table-td-right'>
<input type='submit' name='action' onClick="document.pressed='account'" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>