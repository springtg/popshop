<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<light:authenticateUser>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width="98%">
<c:if test='${requestScope.isEmpty != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<fmt:message key="portlet.message.empty.friendRequest"/>
</td>
</tr>
</c:if>
<c:forEach var="friendRequest" items="${requestScope.friendRequests}" >
<tr>
<td class='portlet-table-td-center' >
<c:if test='${friendRequest.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${friendRequest.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${friendRequest.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${friendRequest.photoSmallWidth}"/>' height='<c:out value="${friendRequest.photoSmallHeight}"/>'/>
</c:if>
</td>
<td class='portlet-table-td-center' >
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${friendRequest.uri}"/>' ><c:out value="${friendRequest.displayName}"/></a> <fmt:message key="portlet.message.friendRequest"/>
<br/><br/>
<input type='submit' name='<c:out value="${friendRequest.id}"/>' onClick="document.pressed='approve';document.parameter=this.name;" value='<fmt:message key="portlet.button.approve"/>' class='portlet-form-button' />
<input type='submit' name='<c:out value="${friendRequest.id}"/>' onClick="document.pressed='deny';document.parameter=this.name;" value='<fmt:message key="portlet.button.deny"/>' class='portlet-form-button' />
<input type='submit' name='<c:out value="${friendRequest.id}"/>' onClick="document.pressed='sendMessage';document.parameter=this.name;" value='<fmt:message key="portlet.button.sendMessage"/>' class='portlet-form-button' />
</td>
</tr>
</c:forEach>
</table>
</form>
</light:authenticateUser>
</fmt:bundle>
</body>
</html>