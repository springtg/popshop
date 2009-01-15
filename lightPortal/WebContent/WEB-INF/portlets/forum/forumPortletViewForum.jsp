<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<input type='hidden' name='categoryId'  value='<c:out value="${categoryId}"/>' /> 
<input type='hidden' name='forumId'  value='<c:out value="${forumId}"/>' /> 
<c:if test='${requestScope.topicLists != null}'>
<table border='0' cellpadding='0' cellspacing='0' width='95%'>
<tr>
<td class='portlet-table-td-left' >
<b><a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','categoryId=<c:out value="${categoryId}"/>');" ><c:out value="${categoryName}"/></a>-><c:out value="${forumName}"/></b>
<a href='http://www.<c:out value="${sessionScope.org.webId}"/>/rss/forum<c:out value="${forumId}"/>p<c:out value="${pageId}"/>.xml'><img src='<%= request.getContextPath() %>/light/images/rss.gif' style='border: 0px' title='<fmt:message key="portlet.label.rssForum"/>'/></a>
<light:authenticateUser>  
<input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' onClick="javascript:popForumItem(event,'<c:out value="${forumId}"/>','<c:out value="${pageId}"/>','<c:out value="${requestScope.responseId}"/>'); return false;"/>
<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' onClick="javascript:forwardForumToFriend(event,'<c:out value="${forumId}"/>','<c:out value="${pageId}"/>','<c:out value="${requestScope.responseId}"/>'); return false;"/>
<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' onClick="javascript:saveForumToBookmark(event,'<c:out value="${forumId}"/>','<c:out value="${pageId}"/>','<c:out value="${requestScope.responseId}"/>'); return false;"/>
</light:authenticateUser>	
</td>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="javascript:if(Light.securityCheck()) Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','','categoryId=<c:out value="${categoryId}"/>;forumId=<c:out value="${forumId}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addForumTopic"/></a>
</td>
<td class='portlet-link' >
<input type='text' id='forumSearch' class='portlet-form-input-field' size='24' value='' onchange="javascript:Light.forumSearch();"/>
<a href="javascript:void(0);" onclick="javascript:Light.forumSearch();"><img src='<%= request.getContextPath() %>/light/images/search.gif' style='border: 0px' height='16' width='16' align='top' title='<fmt:message key="portlet.button.search"/>'/></a>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','categoryId=<c:out value="${categoryId}"/>');" ><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.button.back"/>'/></a>
</td>
</tr>
<tr>
<td class='portlet-link' colspan='3'>
<c:if test='${requestScope.pages > 1}'>
<c:forEach var="i" begin="1" end="${requestScope.pages}" step="1">
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','categoryId=<c:out value="${categoryId}"/>;forumId=<c:out value="${forumId}"/>;pageId=<c:out value="${i}"/>;pages=<c:out value="${pages}"/>');" ><c:out value="${i}"/></a>
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
<c:forEach var="forum" items="${requestScope.topicLists}" >
<tr class='portlet-table-td-left'>
<td class='portlet-item' >
<a href='javascript:void(0);' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','categoryId=<c:out value="${categoryId}"/>;forumId=<c:out value="${forumId}"/>;topicId=<c:out value="${forum.id}"/>');">
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
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${forum.lastUri}"/>' ><img src='<%= request.getContextPath() %><c:out value="${forum.lastPhotoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${forum.lastPhotoSmallWidth / 2}"/>' height='<c:out value="${forum.lastPhotoSmallHeight / 2}"/>'/></a>
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

<c:if test='${requestScope.error != null}'>
<span class="portlet-item">
<c:out value="${requestScope.error}"/>
</span>
</c:if>
</fmt:bundle>
</body>
</html>