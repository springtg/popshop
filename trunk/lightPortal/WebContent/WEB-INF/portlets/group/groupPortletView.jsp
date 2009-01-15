<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
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
<form action="<portlet:actionURL portletMode='VIEW'/>">
<light:authenticateUser> 
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT' windowState='MAXIMIZED'><portlet:param name='type' value='create'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.createGroup"/></a>
</td>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT' windowState='MAXIMIZED'><portlet:param name='type' value='join'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.joinGroup"/></a>
</td>
</tr>
</table>
</light:authenticateUser>
<c:if test='${requestScope.groupCount > 0}'>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<fmt:message key="portlet.label.youJoin"/> <c:out value="${requestScope.groupCount}"/> <fmt:message key="portlet.label.groups"/>
</td>
</tr>
</table>
</c:if>
<table border='0' cellpadding='0' cellspacing='0' width='95%' >
<c:forEach var="group" items="${requestScope.userGroups}" >
<tr>
<td class='portlet-table-td-center' width= '220'>
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.webId}"/><c:out value="${sessionScope.org.groupPrefix}"/><c:out value="${group.uri}"/>' >
<c:if test='${group.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;' width='75' height='75'/>
</c:if>
<c:if test='${group.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${group.photoUrl}"/>' style='border: 0px;'  width='<c:out value="${group.photoSmallWidth}"/>' height='<c:out value="${group.photoSmallHeight}"/>'/>
</c:if>
</a>
<br/> 
<a href='http://www.<c:out value="${sessionScope.org.webId}"/><c:out value="${sessionScope.org.groupPrefix}"/><c:out value="${group.uri}"/>' ><c:out value="${group.displayName}"/></a>
</span>
</td>
<light:authenticateUser> 
<td class='portlet-table-td-right'>
<c:if test='${group.openJoin == 1 || group.memberInvite == 1}'>
<input type="image" src="<%= request.getContextPath() %>/light/images/wins.gif" title='<fmt:message key="portlet.label.inviteGroup"/>' style='border: 0px;' align="top" height='16' width='16' name="" onClick="javascript:inviteOthers(event,'<c:out value="${group.groupId}"/>','<c:out value="${requestScope.responseId}"/>');"/>
</c:if>
<input type="image" src="<%= request.getContextPath() %>/light/images/group.gif" title='<fmt:message key="portlet.label.viewGroupMembers"/>' style='border: 0px;' align="top" height='16' width='16' name="" onClick="javascript:viewGroupMembers(event,'<c:out value="${group.groupId}"/>','<c:out value="${requestScope.responseId}"/>');"/>
<input type="image" src="<%= request.getContextPath() %>/light/images/picture.gif" title='<fmt:message key="portlet.label.viewGroupPictures"/>' style='border: 0px;' align="top" height='16' width='16' name="" onClick="javascript:viewGroupPictures(event,'<c:out value="${group.groupId}"/>','<c:out value="${requestScope.responseId}"/>');"/>
<input type="image" src="<%= request.getContextPath() %>/light/images/losses.gif" title='<fmt:message key="portlet.label.resignGroup"/>' style='border: 0px;' align="top" height='16' width='16' name="" onClick="javascript:resign(event,'<c:out value="${group.groupId}"/>','<c:out value="${requestScope.responseId}"/>');"/>
<light:authorizeGroupMember type='leader'>
<input type="image" src="<%= request.getContextPath() %>/light/images/edit.gif" title='<fmt:message key="portlet.label.editGroup"/>' style='border: 0px;' align="top" height='11' width='11' name="" onClick="javascript:editGroupProfile(event,'<c:out value="${group.groupId}"/>','<c:out value="${requestScope.responseId}"/>');"/>
<input type="image" src="<%= request.getContextPath() %>/light/images/deleteLink.gif" title='<fmt:message key="portlet.button.delete"/>' style='border: 0px;' align="top" height='11' width='11' onClick="javascript:deleteGroupProfile(event,'<c:out value="${group.groupId}"/>','<c:out value="${group.displayName}"/>','<c:out value="${requestScope.responseId}"/>');"/>
</light:authorizeGroupMember>
</td>
</light:authenticateUser>
</tr>
</c:forEach>
</table>
</form>
</fmt:bundle>
</body>
</html>