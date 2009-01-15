<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL />">
<light:authorize role="ROLE_ADMIN"> 
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-link-left'>
<a href='javascript:void(0)' onclick="<portlet:renderURL portletMode='EDIT'/>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.addInternalNews"/></a>
</td>
</tr>
</table>
</light:authorize>
<c:if test='${requestScope.showList != null}'>
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-link-left'>
<span class="portlet-title"><fmt:message key="portlet.label.latestNews"/></span>
</td>
</tr>
<c:forEach var="item" items="${requestScope.showList}" >	
<tr>
<td class='portlet-link-left'>
<light:authorize role="ROLE_ADMIN">
<input type="image" src="light/images/edit.gif" style='border: 0px;' height='13' width='11' name="<c:out value='${item.id}'/>" onClick="document.pressed='edit';document.parameter=this.name;document.mode='EDIT';"/>
<input type="image" src="light/images/deleteLink.gif" style='border: 0px;' height='11' width='11' name="<c:out value='${item.id}'/>" onClick="document.pressed='delete';document.parameter=this.name;"/>
</light:authorize>
<span class="portlet-item">
<a href='javascript:void(0)' 
   		onclick="javascript:hideInternalNewsDesc();Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','newsId=<c:out value="${item.id}"/>');"
		onmouseover="javascript:showInternalNewsDesc(event,'<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');"
	    onmouseout="javascript:hideInternalNewsDesc();">
	    <c:out value="${item.subject}" escapeXml="false"/>
</a>
</span>	
<br/>
<span class="portlet-note"><c:out value="${item.date}"/></span>
</td>
</tr>
</c:forEach>
</table>
</c:if>

<c:if test='${requestScope.state == "normal" && requestScope.showMore != null }'>
	<span class="portlet-rss" style="text-align:right;margin-right:10px;">
	<a href='javascript:void(0)' onclick="<portlet:renderURL  windowState='MAXIMIZED'/>" ><fmt:message key="portlet.label.more"/>...</a> 
	</span>
</c:if>
<c:if test='${requestScope.state == "maximized" }'>
	<span class="portlet-rss" style="text-align:right;;margin-right:10px;">
	<a href='javascript:void(0)' onclick="<portlet:renderURL  windowState='NORMAL'/>" ><fmt:message key="portlet.button.back"/></a> 
	</span>
</c:if>
</form>
</fmt:bundle>
</body>
</html>