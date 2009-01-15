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
<light:authenticateOwner> 
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'><portlet:param name='add' value='add'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.addFile"/></a>
</td>
</tr>
</table>
</light:authenticateOwner>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<fmt:message key="portlet.label.youHave"/> <c:out value="${requestScope.fileCount}"/> <fmt:message key="portlet.label.files"/>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >

<c:forEach var="file" items="${requestScope.userFiles}" >
<tr>
<td class='portlet-table-td-left' width='90%'>
<light:authenticateOwner> 
<input type='radio' name='fileId' value='<c:out value="${file.id}"/>' />
</light:authenticateOwner>
<span class="portlet-item">
<a href='<%= request.getContextPath() %><c:out value="${file.fileUrl}"/>' target="_blank">
<c:out value="${file.caption}"/>
</a>
</span>
</td>
</tr>
</c:forEach>
<light:authenticateOwner> 
<c:if test='${requestScope.fileCount > 0}'>
<tr>
<td class='portlet-table-td-left' >
<br/><br/>
<input type='submit' onClick="document.pressed='select';" value='<fmt:message key="portlet.button.config"/>' class='portlet-form-button' />
<input type='submit' onClick="document.pressed='delete';" value='<fmt:message key="portlet.button.delete"/>' class='portlet-form-button' />
</td>
</tr>
</c:if>
</light:authenticateOwner>
</table>
</form>
</fmt:bundle>
</body>
</html>