<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0' width="95%">
<tr>
<td class='portlet-table-td-left'>
Feed:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='prFeed'  value='<c:out value="${requestScope.feed}"/>' class='portlet-form-input-field' size='30' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Title:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='prTitle'  value='<c:out value="${requestScope.portlet.title}"/>' class='portlet-form-input-field' size='30'/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Link:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='prUrl'  value='<c:out value="${requestScope.portlet.url}"/>' class='portlet-form-input-field' size='30'/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Image Link:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='prIcon' value='<c:out value="${requestScope.portlet.icon}"/>' class='portlet-form-input-field' size='30'/>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'>
<input name='Submit' type='button' value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' onclick="javascript:editViewerPortlet('<c:out value="${requestScope.responseId}"/>');" />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>						
</table>		
</form>
</fmt:bundle>
</body>
</html>