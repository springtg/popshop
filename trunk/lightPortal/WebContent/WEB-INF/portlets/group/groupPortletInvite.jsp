<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-left' >
<fmt:message key="portlet.label.inviteGroup"/>:
</td>
</tr>
</table>
<br/>
<c:if test='${requestScope.success != null}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-success' >
<c:out value="${requestScope.success}"/>
</td>
</tr>
</table>
<br/>
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
<br/>
</c:if>
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr>
<td class='portlet-table-td-left' width='40%'>
<input type='hidden' name='groupId' value='<c:out value="${requestScope.groupId}"/>' />
<select name='from' size='10' class='portlet-form-select' STYLE="width: 100px">
<c:forEach var="buddy" items="${requestScope.myFriends}" >
<option value='<c:out value="${buddy.buddyUserId}"/>'><c:out value="${buddy.displayName}"/></option>
</c:forEach>
</select>
</td>
<td class='portlet-table-td-center' width='20%'>
<a href="javascript:void(0);" onclick="javascript:selectInvitedFriends('<c:out value="${requestScope.responseId}"/>');"><img src='<%= request.getContextPath() %>/light/images/next.gif' style='border: 0px' /></a>						
<br/>
<a href="javascript:void(0);" onclick="javascript:unselectInvitedFriends('<c:out value="${requestScope.responseId}"/>');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' /></a>
</td>
<td class='portlet-table-td-left' width='40%'>
<select name='to' size='10' class='portlet-form-select' STYLE="width: 100px">
</select>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='80%'>
<tr>
<td class='portlet-table-td-right'>
<input type="button"  value='<fmt:message key="portlet.button.invite"/>' class='portlet-form-button' 
onclick="javascript:inviteToGroup(event,'<c:out value="${requestScope.responseId}"/>');"  />
</td>
</tr>
</table>

</form>
</fmt:bundle>
</body>
</html>