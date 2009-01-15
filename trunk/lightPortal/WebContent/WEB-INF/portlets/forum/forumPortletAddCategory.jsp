<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if> 
<tr>
<td class='portlet-table-td-right' width='100' >
<fmt:message key="portlet.label.category"/>:
</td>
<td class='portlet-table-td-left'  >
<input type='text' name='category'  value='<c:out value='${requestScope.category}'/>' class='portlet-form-input-field' size='50' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right' width='100'>
<fmt:message key="portlet.label.desc"/>:
</td>
<td class='portlet-table-td-left'  >
<input type='text' name='categoryDesc'  value='<c:out value='${requestScope.categoryDesc}'/>' class='portlet-form-input-field' size='50' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2' >
<input type='submit' name='action' onClick="document.pressed='category';document.mode='view';document.resetLastAction='1';" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
