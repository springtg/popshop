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
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<tr>
<td class='portlet-table-td-center' width='100%'>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='previous' value='1'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/previous.gif' title='<fmt:message key="portlet.label.previous"/>' style='border: 0px' /></a>						
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='next' value='1'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/next.gif' title='<fmt:message key="portlet.label.next"/>' style='border: 0px' /></a>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<c:forEach var="picture" items="${requestScope.showPictures}" varStatus="status">
<c:if test='${status.index % columnNumber == 0}'>
<tr valign='top'>
</c:if>
<td class='portlet-table-td-center'>
<c:if test='${picture.httpUrl}'>
<a href='javascript:void(0);' onclick="javascript:viewMaxPicture('<c:out value="${requestScope.responseId}"/>','<c:out value="${picture.id}"/>');"><img src='<c:out value="${picture.pictureUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${picture.smallWidth}"/>' height='<c:out value="${picture.smallHeight}"/>'/></a>
</c:if>
<c:if test='${!picture.httpUrl}'>
<a href='javascript:void(0);' onclick="javascript:viewMaxPicture('<c:out value="${requestScope.responseId}"/>','<c:out value="${picture.id}"/>');"><img src='<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${picture.smallWidth}"/>' height='<c:out value="${picture.smallHeight}"/>'/></a>
</c:if>
<br/>
<c:out value="${picture.caption}"/>
</td>
<c:if test='${status.index % columnNumber == columnNumber - 1}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.showNumber % columnNumber != 0}'>
</tr>
</c:if>
</table>
</form>
<c:if test='${requestScope.state == "normal" && requestScope.showMore != null}'>
<span class="portlet-rss" style="text-align:right;">
<a href='javascript:void(0)' onclick="<portlet:renderURL  windowState='MAXIMIZED'/>" >more...</a> 
</span>
</c:if>
</fmt:bundle>
</body>
</html>