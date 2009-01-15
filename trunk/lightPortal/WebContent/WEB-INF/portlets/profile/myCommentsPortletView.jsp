<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-link-left' colspan='3'>
<a href='javascript:void(0)' onclick="javascript:showAddComments(event,'<c:out value="${requestScope.responseId}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addPost"/></a>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<c:forEach var="comment" items="${requestScope.userComments}" >
<tr>
<td class='portlet-table-td-center' width='20%'>
<c:if test='${comment.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${comment.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${comment.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${comment.photoSmallWidth / 4}"/>' height='<c:out value="${comment.photoSmallHeight / 4}"/>'/>
</c:if>
<br/>
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${comment.uri}"/>' ><c:out value="${comment.displayName}"/></a>
</span>
</td>
<td class='portlet-table-td-left' width='75%'>
<c:out value="${comment.date}"/>
<br/>
<c:out value="${comment.comments}"/>
</td>
<light:authenticateOwner> 
<td class='portlet-table-td-left' width='5%'>
<input type="image" src="/light/images/deleteLink.gif" name="<c:out value='${comment.id}'/>" style='border: 0px;' height='11' width='11' onClick="document.pressed='delete';document.parameter=this.name;decreasePortletTitle('<c:out value="${requestScope.responseId}"/>');"/>
</td>
</light:authenticateOwner>
</tr>
</c:forEach>
</table>
<c:if test='${requestScope.state == "normal" && requestScope.showMore != null }'>
<span class="portlet-rss" style="text-align:right;">
<a href='javascript:void(0)' onclick="<portlet:renderURL  windowState='MAXIMIZED'/>" >more......</a> 
</span>
</c:if>
</form>
</fmt:bundle>
</body>
</html>