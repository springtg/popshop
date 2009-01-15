<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="optionsHeader.jsp" ></jsp:include>
<br/>
<fmt:bundle basename="resourceBundle">
<br/>
<br/>
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<c:forEach var="timeZone" items="${requestScope.timeZones}" varStatus="status">
<c:if test='${status.index % 3 == 0}'>
<tr>
</c:if>
<td class='portlet-table-td-left' width='33%'>
<input TYPE='radio' name='timeZone' value='<c:out value="${timeZone.id}"/>'
<c:if test='${sessionScope.user.timeZone == timeZone.id}'>
checked="checked"
</c:if>
>
<c:out value="${timeZone.desc}"/></input>
</td>
<c:if test='${status.index % 3 == 2}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.timeZoneCount % 3 != 0}'>
</tr>
</c:if>
</table>

<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-table-td-right'>
<input name='Save' type='button' value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button'
 onclick="javascript:Light.saveTimeZone('<c:out value="${requestScope.responseId}"/>',true);" />
<input name='Cancel' type='button' value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button'
 onclick="javascript:Light.closePortlet('<c:out value="${requestScope.responseId}"/>');" />
<input name='Apply' type='button' value='<fmt:message key="portlet.button.apply"/>' class='portlet-form-button'
 onclick="javascript:Light.saveTimeZone('<c:out value="${requestScope.responseId}"/>',false);" />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>