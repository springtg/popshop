<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<light:authorize role="ROLE_ADMIN"> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='99%'>
<tr>
<td class='portlet-table-td-left'>
<select name='type' size='1' class='portlet-form-select' style="width:200px;">
	<c:forEach var="bean" items="${sessionScope.searchTypes}" >
	<option value='<c:out value="${bean.id}"/>'
	<c:if test='${bean.defaulted == true}'>
	selected="selected"
	</c:if>
	><c:out value="${bean.desc}"/></option>
	</c:forEach>
</select>
<input type='submit' name='action' onClick="document.pressed='reIndex'" value='<fmt:message key="portlet.button.reIndex"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
<c:if test='${requestScope.success != null}'>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-success' >
<c:out value="${requestScope.success}"/>
</td>
</tr>
</table>
</c:if>
</fmt:bundle>
</light:authorize>
</body>
</html>