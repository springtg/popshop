<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<light:authenticateUser> 
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr valign='top'>
<td class='portlet-link-left'>
<a href='javascript:void(0)' onclick="<portlet:renderURL portletMode='EDIT' windowState='MAXIMIZED' ><portlet:param name='add' value='add'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addBlog"/></a>
</td>
<td class='portlet-table-td-right' style="padding: 10px 10px 5px 5px;">
<input type='text' id='blogViewSearch' class='portlet-form-input-field' size='24' value='' onchange="javascript:Light.blogSearch('blogViewSearch');"/>
<a href="javascript:void(0);" onclick="javascript:Light.blogSearch('blogViewSearch');"><img src='<%= request.getContextPath() %>/light/images/search.gif' style='border: 0px' height='16' width='16' align='top' title='<fmt:message key="portlet.button.search"/>'/></a>
</td>
</tr>
</table>
</light:authenticateUser>
<c:if test='${requestScope.type == "1"}'>
<span class="portlet-item">
<fmt:message key="portlet.message.top"/>
<c:out value="${requestScope.showNumber}"/>
<fmt:message key="portlet.message.newestBlog"/>
</span>
</c:if>
<c:if test='${requestScope.type == "2"}'>
<span class="portlet-item">
<fmt:message key="portlet.message.top"/>
<c:out value="${requestScope.showNumber}"/>
<fmt:message key="portlet.message.popularBlog"/>
</span>
</c:if>
<br/><br/>
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
<c:if test='${item.commentCount != 0}'>
(<c:out value="${item.commentCount}"/> <fmt:message key="portlet.label.comments"/>)
</c:if>
</a>
</span>
<br/>
<span class="portlet-note"><c:out value="${item.date}"/></span>
</td>
<td class='portlet-table-td-right'>
<span class="portlet-rss">
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${item.uri}"/>'><c:out value="${item.displayName}"/></a>
</span>
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
</form>
</fmt:bundle>
</body>
</html>