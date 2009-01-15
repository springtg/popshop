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
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr>
<td class='portlet-table-td-left'>*<LABEL FOR='email' ACCESSKEY='U'><b><fmt:message key="portlet.label.userId"/></b>: </LABEL></td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input type='text' name='email' value='' class='portlet-form-input-field' size='33' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>*<b><fmt:message key="portlet.label.birth"/></b>: </td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<select name='birthM' size='1' class='portlet-form-select' style="width:65;">
<c:forEach var="month" items="${requestScope.months}" >
<option value='<c:out value="${month.id}"/>'><c:out value="${month.desc}"/></option>
</c:forEach>
</select>
/
<select name='birthD' size='1' class='portlet-form-select' style="width:50;">
<c:forEach var="day" items="${requestScope.days}" >
<option value='<c:out value="${day.id}"/>'><c:out value="${day.desc}"/></option>
</c:forEach>
</select>
/
<select name='birthY' size='1' class='portlet-form-select' style="width:55;">
<c:forEach var="year" items="${requestScope.years}" >
<option value='<c:out value="${year.id}"/>'><c:out value="${year.desc}"/></option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' >
<br/>
<input type='button' name='action' onClick="javascript:Light.executeAction('<c:out value="${requestScope.responseId}"/>','','request','','','edit','','type=forgot');" value='<fmt:message key="portlet.button.requestNewPassword"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.back"/>' class='portlet-form-button' />
</td>
</tr>

</table>
</form>
</fmt:bundle>
</body>
</html>