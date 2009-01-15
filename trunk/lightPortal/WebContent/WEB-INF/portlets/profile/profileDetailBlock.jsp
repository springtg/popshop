<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="profileDetailHeader.jsp" ></jsp:include>
<br/>
<fmt:bundle basename="resourceBundle">
<c:if test='${requestScope.blockCount == 0}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
You don't have any block users.
</td>
</tr>
</table>
</c:if>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width= '220'>
<c:forEach var="block" items="${requestScope.blocks}" >
<tr>
<td class='portlet-table-td-center'>
<c:if test='${block.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${block.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${block.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${block.photoWidth}"/>' height='<c:out value="${block.photoHeight}"/>'/>
</c:if>
<br/>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${block.uri}"/>' ><c:out value="${block.displayName}"/></a>
<light:authenticateUser> 
<br/>
<input type='radio' name='blockId' value='<c:out value="${block.id}"/>' />
</light:authenticateUser>
</td>
</tr>
</c:forEach>
<light:authenticateUser> 
<c:if test='${requestScope.blockCount > 0}'>
<tr>
<td class='portlet-table-td-center'>
<input type='submit' onClick="document.pressed='block';" value='<fmt:message key="portlet.button.unblock"/>' class='portlet-form-button' />
</td>
</tr>
</c:if>
</light:authenticateUser>
</table>
</form>
</fmt:bundle>
</body>
</html>