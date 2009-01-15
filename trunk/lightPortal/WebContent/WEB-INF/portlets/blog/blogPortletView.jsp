<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr valign='top'>
<light:authenticateUser> 
<td class='portlet-link-left'>
<a href='javascript:void(0)' onclick="<portlet:renderURL portletMode='EDIT' windowState='MAXIMIZED' ><portlet:param name='add' value='add'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.add"/></a>
</td>
<td class='portlet-table-td-right' style="padding: 10px 10px 5px 5px;">
<input type='text' id='blogSearch' class='portlet-form-input-field' size='16' value='' onchange="javascript:Light.blogSearch('blogSearch');"/>
<a href="javascript:void(0);" onclick="javascript:Light.blogSearch('blogSearch');"><img src='<%= request.getContextPath() %>/light/images/search.gif' style='border: 0px' height='16' width='16' align='top' title='<fmt:message key="portlet.button.search"/>'/></a>
</td>
</light:authenticateUser>
<td class='portlet-table-td-right'>
<a href='http://www.<c:out value="${sessionScope.org.webId}"/>/rss/blog<c:out value="${requestScope.userId}"/>.xml'><img src='<%= request.getContextPath() %>/light/images/rss.gif' style='border: 0px;padding-top:10px;' title='<fmt:message key="portlet.label.rssBlog"/>'/></a>
</td>
</tr>
</table>

<c:if test='${requestScope.blogLists != null}'>
<table border='0' cellpadding='0' cellspacing='0'  width='98%'>
<c:forEach var="item" items="${requestScope.blogLists}" >
<tr valign='top'>
<td class='portlet-table-td-left'>
<span class="portlet-item"
	onmouseover="javascript:showBlogDesc(event,'<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');"
    onmouseout="javascript:hideBlogDesc();">
<a href='javascript:void(0);' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','blogId=<c:out value="${item.id}"/>');">
<c:if test='${item.status != 0}'>
<c:out value="${item.title}"/>
</c:if>
<c:if test='${item.status == 0}'>
<i><c:out value="${item.title}"/>(Draft)</i>
</c:if>
<c:if test='${item.commentCount != 0}'>
(<c:out value="${item.commentCount}"/> <fmt:message key="portlet.label.comments"/>)
</c:if>
</a>
</span>
<br/>
<span class="portlet-note"><c:out value="${item.date}"/> </span>
<c:if test='${item.postedById != sessionScope.user.id}'> 
<span class="portlet-note"><fmt:message key="portlet.label.postedBy"/></span>
<span class="portlet-note" style="padding-left:0px;"><a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${item.uri}"/>' target='_blank'><span class="portlet-note-link"><c:out value="${item.displayName}"/></span></a></span>
</c:if>

</td>
<td class='portlet-table-td-right'>
<c:if test='${item.postedById == sessionScope.user.id}'> 
<input type="image" title='<fmt:message key="portlet.label.edit"/>' src="<%= request.getContextPath() %>/light/images/edit.gif" style='border: 0px;' height='11' width='11' name="<c:out value='${item.id}'/>" onClick="document.pressed='edit';document.parameter=this.name;document.mode='EDIT';document.state='maximized';"/>
<input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11' name="<c:out value='${item.id}'/>" onClick="document.pressed='delete';document.parameter=this.name;"/>
</c:if>
</td>
</tr>
</c:forEach>
</table>
</c:if>
<c:if test='${requestScope.state == "normal" && requestScope.showMore != null }'>
<span class="portlet-rss" style="text-align:right;">
<a href='javascript:void(0)' onclick="<portlet:renderURL  windowState='MAXIMIZED'/>" >more......</a> 
</span>
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