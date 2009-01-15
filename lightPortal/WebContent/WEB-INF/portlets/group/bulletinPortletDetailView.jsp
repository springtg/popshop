<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width="98%">
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-left' width='10'>
<fmt:message key="portlet.label.from"/>:
</td>
<td class='portlet-table-td-center'>
<span class='portlet-item'>
<c:if test='${requestScope.bulletin.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${requestScope.bulletin.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${requestScope.bulletin.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${requestScope.bulletin.photoSmallWidth}"/>' height='<c:out value="${requestScope.bulletin.photoSmallHeight}"/>'/>
</c:if>
<br/>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${requestScope.bulletin.uri}"/>' ><c:out value="${requestScope.bulletin.displayName}"/></a>
<br/>
<c:if test='${requestScope.bulletin.userCurrentStatusId == 1 }'>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px;' height='16' width='16'  align="bottom" alt=''/>
<br/>
<a href='javascript:void(0)' onclick="javascript:showInstantMessageMember(event,'<c:out value="${requestScope.bulletin.postById}"/>','<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.instantMessage"/></a>
<br/>
</c:if>
<a href='javascript:void(0)' onclick="javascript:showSendMessageMember('<c:out value="${requestScope.bulletin.postById}"/>');" ><fmt:message key="portlet.label.sendMessage"/></a>
</span>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.subject"/>:
<c:out value="${requestScope.bulletin.subject}"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.content"/>:
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:out value="${requestScope.bulletin.content}"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2'>
<input type='submit' name='<c:out value="${requestScope.bulletin.id}"/>' onClick="document.pressed='delete';document.parameter=this.name;" value='<fmt:message key="portlet.button.delete"/>' class='portlet-form-button' />
<input type='submit' name='action' onClick="document.pressed='cancel'" value='<fmt:message key="portlet.button.back"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
