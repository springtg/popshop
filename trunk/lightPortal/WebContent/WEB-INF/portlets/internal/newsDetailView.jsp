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
<td class="portlet-link-left" colspan='2'>
<span class="portlet-title"><c:out value="${requestScope.news.subject}"/></span>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<span class="portlet-note"><c:out value="${requestScope.news.date}"/></span>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<br/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:out value="${requestScope.news.content}" escapeXml="false"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2'>
<light:authorize role="ROLE_ADMIN">
<input type='submit' name='<c:out value="${requestScope.bulletin.id}"/>' onClick="document.pressed='delete';document.parameter=this.name;" value='<fmt:message key="portlet.button.delete"/>' class='portlet-form-button' />
</light:authorize>
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.back"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
