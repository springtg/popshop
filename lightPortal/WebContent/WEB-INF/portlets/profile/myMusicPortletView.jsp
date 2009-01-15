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
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<light:authenticateOwner> 
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'><portlet:param name='add' value='add'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.addMusic"/></a>
</td>
</light:authenticateOwner>
<c:if test='${requestScope.musicCount > 0}'>
<td class='portlet-table-td-center' >
<input type="image" title='<fmt:message key="portlet.button.stop"/>' src="<%= request.getContextPath() %>/light/images/stop.gif" style='border: 0px;' height='11' width='11' name = '<c:out value="${music.id}"/>' align='middle' onClick="javascript:stopMusic();"/>
</td>
</c:if>
</tr>
</table>

<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<c:forEach var="music" items="${requestScope.userMusics}" >
<tr>
<td class='portlet-table-td-left' width='90%'>
<input type="image" title='<fmt:message key="portlet.button.play"/>' src="<%= request.getContextPath() %>/light/images/play.gif" style='border: 0px;' height='16' width='16' name = '<c:out value="${music.id}"/>' align='middle' onClick="javascript:playMusic('<%= request.getContextPath() %><c:out value="${music.musicUrl}"/>');"/>
<span class="portlet-item">
<a href='<%= request.getContextPath() %><c:out value="${music.musicUrl}"/>' target="_blank">
<c:out value="${music.caption}"/> 
</a>
</span>
</td>
</tr>
</c:forEach>
</table>
<c:if test='${requestScope.showMore != null}'>
<span class="portlet-rss" style="text-align:right;">
<a href='javascript:void(0)' onclick="<portlet:renderURL  windowState='MAXIMIZED'/>" >more...</a> 
</span>
</c:if>
</fmt:bundle>
</body>
</html>