<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<input type='hidden' name='categoryId'  value='<c:out value="${categoryId}"/>' /> 
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
<fmt:message key="portlet.label.forum"/>:
</td>
<td class='portlet-table-td-left'  >
<input type='text' name='forum'  value='<c:out value='${requestScope.forum}'/>' class='portlet-form-input-field' size='50' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right' width='100'>
<fmt:message key="portlet.label.desc"/>:
</td>
<td class='portlet-table-td-left'  >
<input type='text' name='fourmDesc'  value='<c:out value='${requestScope.forumDesc}'/>' class='portlet-form-input-field' size='50' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2' >
<input type='submit' name='action' onClick="document.pressed='sub';document.mode='view';document.resetLastAction='1';" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','categoryId=<c:out value="${categoryId}"/>');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
