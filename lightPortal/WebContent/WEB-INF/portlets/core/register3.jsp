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
<form name='form_<c:out value="${requestScope.responseId}"/>' action="<portlet:actionURL portletMode='EDIT'/>">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-left' width='30%'>
</td>
<td class='portlet-table-td-left' colspan='2'>
<br/>
<br/>
<fmt:message key="portlet.label.chooseChannel"/>:
</td>
</tr>
<c:forEach var="channel" items="${requestScope.channels}"  varStatus="status">
<c:if test='${status.index % 2 == 0}'>
<tr>
<td class='portlet-table-td-left' width='30%'>
</td>
</c:if>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='channels' value='<c:out value="${channel.name}"/>'
<c:if test='${channel.selected == 1}'>
checked="checked"
</c:if>
><c:out value="${channel.desc}"/></input>
</td>
<c:if test='${status.index % 2 == 1}'>
</tr>
</c:if>
</c:forEach>
</table>

<table border='0' cellpadding='0' cellspacing='0' width='80%'>
<tr>
<td class='portlet-table-td-right'>
<input type='button' name='action' onClick="javascript:signUp3('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.next"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>