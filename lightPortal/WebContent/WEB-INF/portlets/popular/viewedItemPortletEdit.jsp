<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width="95%">
<tr>
<td class='portlet-table-td-left' width='200'>
<fmt:message key="portlet.label.show.viewedBy"/>:
</td>
<td class='portlet-table-td-left'>
<select name='viewedBy' size='1'  class='portlet-form-select'>
<option value='0'
<c:if test='${requestScope.viewedBy == 0}'>
selected='selected'
</c:if>
><fmt:message key="portlet.label.show.viewedBy.everyone"/></option>
<option value='1'
<c:if test='${requestScope.viewedBy == 1}'>
selected='selected'
</c:if>
><fmt:message key="portlet.label.show.viewedBy.me"/></option>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='200'>
<fmt:message key="portlet.label.show.normal"/>:
</td>
<td class='portlet-table-td-left'>
<select name='items' size='1'  class='portlet-form-select'>
<c:forEach var="i" begin="1" end="50" step="1">
<c:if test='${requestScope.showNumber == i}'>
<option selected='selected' value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
<c:if test='${requestScope.showNumber != i}'>
<option value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
</c:forEach>
</select>
</td>
</tr>		
<tr>
<td class='portlet-table-td-left' width='200'>
<fmt:message key="portlet.label.show.maximized"/>:
</td>
<td class='portlet-table-td-left'>
<select name='maxItems' size='1'  class='portlet-form-select'>
<c:forEach var="i" begin="1" end="50" step="1">
<c:if test='${requestScope.maxNumber == i}'>
<option selected='selected' value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
<c:if test='${requestScope.maxNumber != i}'>
<option value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
</c:forEach>
</select>
</td>
</tr>	
<tr>
<td class='portlet-table-td-right' colspan='2' >
<input type='submit' name='action' onClick="document.pressed='config';document.resetLastAction='1'" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>					
</table>		
</form>
</fmt:bundle>
</body>
</html>