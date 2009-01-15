<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="profileDetailHeader.jsp" ></jsp:include>
<br/>
<fmt:bundle basename="resourceBundle">
<c:if test='${requestScope.inviteCount == 0}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
You haven't invited your friends yet, hurry.
</td>
</tr>
</table>
</c:if>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width= '220'>
<c:forEach var="invite" items="${requestScope.invites}" >
<tr>
<td class='portlet-table-td-center'>
<c:if test='${invite.status == 1}'>
<b><c:out value="${invite.inviteEmail}"/></b>
<img src='<%= request.getContextPath() %>/light/images/wins.gif' style='border: 0px;'  align="middle" width='16' height='16'/>
</c:if>
<c:if test='${invite.status == 0}'>
<c:out value="${invite.inviteEmail}"/>
</c:if>
</td>
</tr>
</c:forEach>
</table>
</form>
</fmt:bundle>
</body>
</html>