<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr class='portlet-table-td-left'>
<td class='portlet-item' width='45%' style='padding: 5px 0px 0px 5px;'>
<a href='javascript:void(0)' onclick="javascript:Light.showSendMessage(event,'<c:out value="${requestScope.responseId}"/>','<c:out value="${requestScope.user.id}"/>','<c:out value="${requestScope.user.name}"/>');" ><img src='<%= request.getContextPath() %>/light/images/inbox.gif' style='border: 0px;' height='16' width='16' align="top"/><fmt:message key="portlet.label.sendMessage"/></a>
</td>
<td class='portlet-item' width='55%' style='padding: 5px 0px 0px 5px;'>
<a href='javascript:void(0)' onclick="javascript:Light.showForwardToFriends(event,'<c:out value="${requestScope.responseId}"/>');" ><img src='<%= request.getContextPath() %>/light/images/friend.gif' style='border: 0px;' height='16' width='16' align="top"/><fmt:message key="portlet.label.forwardToFriend"/></a>
</td>
</tr>
<tr class='portlet-table-td-left'>
<td class='portlet-item' width='45%' style='padding: 5px 0px 0px 5px;'>
<a href='javascript:void(0)' onclick="javascript:Light.showAddToFriend(event,'<c:out value="${requestScope.responseId}"/>');" ><img src='<%= request.getContextPath() %>/light/images/newFriend.gif' style='border: 0px;' height='16' width='16' align="top"/><fmt:message key="portlet.label.addToFriend"/></a>
</td>
<td class='portlet-item' width='55%' style='padding: 5px 0px 0px 5px;'>
<a href='javascript:void(0)' onclick="javascript:Light.showAddToFavorites(event,'<c:out value="${requestScope.responseId}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add_favorite.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addToFavorites"/></a>
</td>
</tr>
<tr class='portlet-table-td-left'>
<td class='portlet-item' width='45%' style='padding: 0px 0px 0px 5px;'>
<a href='javascript:void(0)' onclick="javascript:Light.showBlockUser(event,'<c:out value="${requestScope.responseId}"/>');" ><img src='<%= request.getContextPath() %>/light/images/block.gif' style='border: 0px;' height='15' width='15' align="top"/><fmt:message key="portlet.label.blockUser"/></a>
</td>
<td class='portlet-item' width='55%' style='padding: 0px 0px 0px 5px;'>
<a href='javascript:void(0)' onclick="javascript:Light.showInstantMessage(event,'<c:out value="${requestScope.responseId}"/>');" ><img src='<%= request.getContextPath() %>/light/images/chat.gif' style='border: 0px;' height='12' width='12' align="top"/><fmt:message key="portlet.label.instantMessage2"/></a>
</td>
</tr>
<!-- 
<tr class='portlet-table-td-left'>
<td class='portlet-item' width='50%'>
<a href='javascript:void(0)' onclick="javascript:showAddToGroup(event,'<c:out value="${requestScope.responseId}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addToGroup"/></a>
</td>
<td class='portlet-item' width='50%'>
<a href='javascript:void(0)' onclick="javascript:showRankUser();" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.rankUser"/></a>
</td>
</tr>
 -->
</table>
</fmt:bundle>
</body>
</html>