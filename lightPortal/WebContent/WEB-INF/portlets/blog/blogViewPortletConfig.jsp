<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0'>
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.blogViewType"/>:
</td>
<td class='portlet-table-td-left'>
<select name='newType' size='1'  class='portlet-form-select'>
<c:if test='${requestScope.type == "1"}'>
<option selected='selected' value='1'><fmt:message key="portlet.message.newestBlog"/></option>
</c:if>
<c:if test='${requestScope.type != "1"}'>
<option  value='1'><fmt:message key="portlet.message.newestBlog"/></option>
</c:if>
<c:if test='${requestScope.type == "2"}'>
<option selected='selected' value='2'><fmt:message key="portlet.message.popularBlog"/></option>
</c:if>
<c:if test='${requestScope.type != "2"}'>
<option value='2'><fmt:message key="portlet.message.popularBlog"/></option>
</c:if>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Show Items:
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
<td class='portlet-table-td-right' colspan='2' >
<input type='submit' name='action' onClick="document.pressed='config';document.resetLastAction='1'" value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
<input type='button' value='<fmt:message key="portlet.button.cancel"/>' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" class='portlet-form-button'/>
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
