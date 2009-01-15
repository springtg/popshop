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
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<fmt:message key="portlet.label.youHave"/> <c:out value="${requestScope.blockCount}"/> <fmt:message key="portlet.label.blockUser"/>.
</td>
</tr>
</table>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width= '220'>
<c:forEach var="block" items="${requestScope.userBlocks}" >
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
<input type='submit' onClick="document.pressed='unblock';" value='<fmt:message key="portlet.button.unblock"/>' class='portlet-form-button' />
</td>
</tr>
</c:if>
</light:authenticateUser>
</table>
</form>
</fmt:bundle>
</body>
</html>