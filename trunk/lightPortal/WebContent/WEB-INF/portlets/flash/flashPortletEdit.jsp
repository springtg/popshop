<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<c:if test='${requestScope.success != null}'>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-success' >
<c:out value="${requestScope.success}"/>
</td>
</tr>
</table>
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
</c:if>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.url"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='name'  value='<c:out value="${name}"/>' class='portlet-form-input-field' size='40' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.width"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='width' value='<c:out value="${width}"/>' class='portlet-form-input-field' size='40' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.height"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='height' value='<c:out value="${height}"/>' class='portlet-form-input-field' size='40' />
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan ='2'>
<input type='submit' name='action' onClick="document.pressed='edit'" value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
<input type='submit' name='action' onClick="document.pressed='cancel';document.mode='view';" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>