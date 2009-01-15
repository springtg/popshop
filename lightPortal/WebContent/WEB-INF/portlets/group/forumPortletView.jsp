<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<c:if test='${requestScope.topLists != null}'>
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-link-left' colspan='3'>
<c:if test='${requestScope.group.publicForum == 1}'>
<light:authenticateUser>  
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'/>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addForumTopic"/></a>
</light:authenticateUser>
</c:if>
<c:if test='${requestScope.group.publicForum != 1}'>
<light:authorizeGroupMember type='yes'>
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'/>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addForumTopic"/></a>
</light:authorizeGroupMember>
</c:if>
<a href='http://www.<c:out value="${sessionScope.org.webId}"/>/rss/gforum<c:out value="${group.id}"/>p<c:out value="${pageId}"/>.xml'><img src='<%= request.getContextPath() %>/light/images/rss.gif' style='border: 0px' title='<fmt:message key="portlet.label.rssForum"/>'/></a>
<light:authorizeGroupMember type='yes'> 
<input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' onClick="javascript:popGroupForumItem(event,'<c:out value="${group.id}"/>','<c:out value="${pageId}"/>','<c:out value="${requestScope.responseId}"/>'); return false;"/>
<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' onClick="javascript:forwardGroupForumToFriend(event,'<c:out value="${group.id}"/>','<c:out value="${pageId}"/>','<c:out value="${requestScope.responseId}"/>'); return false;"/>
<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' onClick="javascript:saveGroupForumToBookmark(event,'<c:out value="${group.id}"/>','<c:out value="${pageId}"/>','<c:out value="${requestScope.responseId}"/>'); return false;"/>	
</light:authorizeGroupMember>
</td>
</tr>
<tr>
<td class='portlet-link' colspan='3'>
<c:if test='${requestScope.pages > 1}'>
<c:forEach var="i" begin="1" end="${requestScope.pages}" step="1">
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','groupId=<c:out value="${group.id}"/>;pageId=<c:out value="${i}"/>;pages=<c:out value="${pages}"/>');" ><c:out value="${i}"/></a>
</c:forEach>
</c:if>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.forumTopic"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.posts"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.lastPost"/></td>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.topicStarter"/></td>
</tr>
<c:forEach var="forum" items="${requestScope.topLists}" >
<tr class='portlet-table-td-left'>
<td class='portlet-item' >
<a href='javascript:void(0);' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','topicId=<c:out value="${forum.id}"/>');">
<img src='<%= request.getContextPath() %>/light/images/folder_smll.gif' style='border: 0px;'  align="top" />
<c:out value="${forum.topic}"/></a>
</td>
<td class='portlet-item' >
<c:out value="${forum.posts}"/>
</td>
<td class='portlet-item'>
<table>
<tr>
<td>
<c:if test='${forum.lastPhotoUrl == null}'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.lastUri}"/>' ><img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='50' height='50'/></a>
</c:if>
<c:if test='${forum.lastPhotoUrl != null}'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.lastUri}"/>' ><img src='<%= request.getContextPath() %><c:out value="${forum.lastPhotoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${forum.lastPhotoSmallWidth / 4}"/>' height='<c:out value="${forum.lastPhotoSmallHeight / 4}"/>'/></a>
</c:if>
</td>
<td class='portlet-table-td-left'>
<c:out value="${forum.lastDate}"/>
<br/>by 
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.lastUri}"/>' ><c:out value="${forum.lastDisplayName}"/></a>
</td>
</tr>
</table>
</td>
<td class='portlet-item'>
<table>
<tr>
<td>
<c:if test='${forum.photoUrl == null}'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.uri}"/>' ><img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='50' height='50'/></a>
</c:if>
<c:if test='${forum.photoUrl != null}'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.uri}"/>' ><img src='<%= request.getContextPath() %><c:out value="${forum.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${forum.photoSmallWidth / 4}"/>' height='<c:out value="${forum.photoSmallHeight / 4}"/>'/></a>
</c:if>
</td>
<td class='portlet-table-td-left'>
<c:out value="${forum.date}"/>
<br/>by 
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.uri}"/>' ><c:out value="${forum.displayName}"/></a>
</td>
</tr>
</table>
</td>
</tr>
</c:forEach>
</table>
</c:if>

<c:if test='${requestScope.forumLists != null}'>
<table border='0' cellpadding='0' cellspacing='0'  width='95%'>
<tr>
<td class='portlet-link-left' colspan='3'>
<a href='http://www.<c:out value="${sessionScope.org.webId}"/>/rss/gtopic<c:out value="${topicId}"/>p<c:out value="${pageId}"/>.xml'><img src='<%= request.getContextPath() %>/light/images/rss.gif' style='border: 0px' title='<fmt:message key="portlet.label.rssForum"/>'/></a>
<light:authorizeGroupMember type='yes'> 
<input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' onClick="javascript:popGroupTopicItem(event,'<c:out value="${topicId}"/>','<c:out value="${pageId}"/>','<c:out value="${requestScope.responseId}"/>'); return false;"/>
<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' onClick="javascript:forwardGroupTopicToFriend(event,'<c:out value="${topicId}"/>','<c:out value="${pageId}"/>','<c:out value="${requestScope.responseId}"/>'); return false;"/>
<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' onClick="javascript:saveGroupTopicToBookmark(event,'<c:out value="${topicId}"/>','<c:out value="${pageId}"/>','<c:out value="${requestScope.responseId}"/>'); return false;"/>	
</light:authorizeGroupMember>
</td>
</tr>
<tr>
<td class='portlet-link' colspan='3'>
<c:if test='${requestScope.pages > 1}'>
<c:forEach var="i" begin="1" end="${requestScope.pages}" step="1">
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','topicId=<c:out value="${groupId}"/>;pageId=<c:out value="${i}"/>;pages=<c:out value="${pages}"/>');" ><c:out value="${i}"/></a>
</c:forEach>
</c:if>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0'  width='95%'>
<c:forEach var="forum" items="${requestScope.forumLists}" >
<tr valign=top>
<td class='portlet-table-td-center' width='20%'>
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.uri}"/>' >
<c:if test='${forum.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${forum.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${forum.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${forum.photoSmallWidth}"/>' height='<c:out value="${forum.photoSmallHeight}"/>'/>
</c:if>
</a>
<br/>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.uri}"/>' ><c:out value="${forum.displayName}"/></a>
<br/>
<c:if test='${forum.currentStatusId == 1 }'>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px;' height='16' width='16'  align="bottom" alt=''/>
</c:if>
<br/><br/>
<c:out value="${forum.gender}"/>/<c:out value="${forum.age}"/>
<br/><br/>
<c:if test='${forum.currentStatusId == 1 }'>
<a href='javascript:void(0)' onclick="javascript:showInstantMessageMember(event,'<c:out value="${forum.postById}"/>','<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.instantMessage"/></a>
<br/>
</c:if>
<a href='javascript:void(0)' onclick="javascript:showSendMessageMember('<c:out value="${forum.postById}"/>');" ><fmt:message key="portlet.label.sendMessage"/></a>
</span>
</td>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.posted"/>: <c:out value="${forum.date}"/>
<light:authorizeGroupMember type='leader'>
<c:if test='${forum.topId == 0 }'>
<input type="image" title='<fmt:message key="portlet.label.deleteAllPosts"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11' name="<c:out value='${forum.id}'/>" onClick="document.pressed='deleteTopic';document.parameter=this.name;"/>
</c:if>
<c:if test='${forum.topId != 0 }'>
<input type="image" title='<fmt:message key="portlet.label.deletePost"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11' name="<c:out value='${forum.id}'/>" onClick="document.pressed='delete';document.parameter=this.name;"/>
</c:if>
</light:authorizeGroupMember>
<br/><br/>
<c:out value="${forum.content}" escapeXml="false"/>
</td>
<td class='portlet-table-td-right'>
<c:if test='${requestScope.group.publicForum == 1}'>
<light:authenticateUser>  
<input type='submit' name="<c:out value='${forum.id}'/>" onClick="document.pressed='quote';document.parameter=this.name;document.mode='EDIT';" value='<fmt:message key="portlet.button.quote"/>' class='portlet-form-button' />
<input type='submit' name="<c:out value='${forum.id}'/>" onClick="document.pressed='replybegin';document.parameter=this.name;document.mode='EDIT';" value='<fmt:message key="portlet.button.reply"/>' class='portlet-form-button' />
</light:authenticateUser>
</c:if>
<c:if test='${requestScope.group.publicForum != 1}'>
<light:authorizeGroupMember type='yes'>
<input type='submit' name="<c:out value='${forum.id}'/>" onClick="document.pressed='quote';document.parameter=this.name;document.mode='EDIT';" value='<fmt:message key="portlet.button.quote"/>' class='portlet-form-button' />
<br/>
<input type='submit' name="<c:out value='${forum.id}'/>" onClick="document.pressed='replybegin';document.parameter=this.name;document.mode='EDIT';" value='<fmt:message key="portlet.button.reply"/>' class='portlet-form-button' />
</light:authorizeGroupMember>
</c:if>
</td>
</tr>
</c:forEach>
<tr>
<td class='portlet-table-td-center' colspan='3'>
<c:if test='${requestScope.group.publicForum == 1}'>
<light:authenticateUser>  
<input type='submit' name="<c:out value='${requestScope.topicId}'/>" onClick="document.pressed='replybegin';document.parameter=this.name;document.mode='EDIT';" value='<fmt:message key="portlet.button.reply"/>' class='portlet-form-button' />
</light:authenticateUser>
</c:if>
<c:if test='${requestScope.group.publicForum != 1}'>
<light:authorizeGroupMember type='yes'>
<input type='submit' name="<c:out value='${requestScope.topicId}'/>" onClick="document.pressed='replybegin';document.parameter=this.name;document.mode='EDIT';" value='<fmt:message key="portlet.button.reply"/>' class='portlet-form-button' />
</light:authorizeGroupMember>
</c:if>
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.back"/>' class='portlet-form-button' />
</td>
</tr>
</table>

</c:if>
<c:if test='${requestScope.error != null}'>
<span class="portlet-item">
<c:out value="${requestScope.error}"/>
</span>
</c:if>
</form>
</fmt:bundle>
</body>
</html>