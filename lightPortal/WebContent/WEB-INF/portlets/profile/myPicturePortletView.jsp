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
<light:authenticateUser> 
<tr>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'><portlet:param name='add' value='add'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.addPicture"/></a>
</td>
</tr>
</light:authenticateUser>
</table>

<c:if test='${autoRefresh == 0}'>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<tr>
<td class='portlet-table-td-center' width='100%'>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='previous' value='1'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/previous.gif' title='<fmt:message key="portlet.label.previous"/>' style='border: 0px' /></a>						
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='next' value='1'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/next.gif' title='<fmt:message key="portlet.label.next"/>' style='border: 0px' /></a>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width= '99%' >
<c:forEach var="picture" items="${requestScope.showPictures}" varStatus="status">
<c:if test='${status.index % columnNumber == 0}'>
<tr valign='top'>
</c:if>
<td class='portlet-table-td-center'>
<span id='picture_<c:out value="${requestScope.responseId}"/>'>
<c:if test='${picture.httpUrl}'>
<img id='currentMyPicture_<c:out value="${requestScope.responseId}"/>' src='<c:out value="${picture.pictureUrl}"/>' style='border: 0px; cursor: url(<%= request.getContextPath() %>/light/images/zoomin.cur), pointer;'  align="middle" width='<c:out value="${picture.smallWidth}"/>' height='<c:out value="${picture.smallHeight}"/>' 
onclick="javascript:viewMaxPictureAtClient(event,'<c:out value="${requestScope.responseId}"/>','<c:out value="${picture.id}"/>','<c:out value="${picture.pictureUrl}"/>','<c:out value="${picture.caption}"/>','<c:out value="${picture.largeWidth}"/>','<c:out value="${picture.largeHeight}"/>');"
onmouseover="javascript:this.style.border='2px solid #83C2CD';"
onmouseout="javascript:this.style.border='';" />
</c:if>
<c:if test='${!picture.httpUrl}'>
<img id='currentMyPicture_<c:out value="${requestScope.responseId}"/>' src='<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' style='border: 0px; cursor: url(<%= request.getContextPath() %>/light/images/zoomin.cur), pointer;'  align="middle" width='<c:out value="${picture.smallWidth}"/>' height='<c:out value="${picture.smallHeight}"/>' 
onclick="javascript:viewMaxPictureAtClient(event,'<c:out value="${requestScope.responseId}"/>','<c:out value="${picture.id}"/>','<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>','<c:out value="${picture.caption}"/>','<c:out value="${picture.largeWidth}"/>','<c:out value="${picture.largeHeight}"/>');"
onmouseover="javascript:this.style.border='2px solid #83C2CD';"
onmouseout="javascript:this.style.border='';" />
</c:if>
<br/>
<c:out value="${picture.caption}"/>
</span>
</td>
<c:if test='${status.index % columnNumber == columnNumber - 1}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.showNumber % columnNumber != 0}'>
</tr>
</c:if>
</table>
</c:if>

<c:if test='${autoRefresh > 0}'>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<c:forEach var="picture" items="${requestScope.showPictures}" varStatus="status">
<tr valign='top'>
<td class='portlet-table-td-center'>
<c:if test='${status.index  == 0}'>
<span id='picture_<c:out value="${requestScope.responseId}"/>' style="filter:alpha(opacity=0); -moz-opacity:0.0;"
onclick="javascript:viewMaxPictureAtClientById(event,'<c:out value="${requestScope.responseId}"/>');">
<c:if test='${picture.httpUrl}'>
<img id='currentMyPicture_<c:out value="${requestScope.responseId}"/>' src='<c:out value="${picture.pictureUrl}"/>' style='border: 0px; cursor: url(<%= request.getContextPath() %>/light/images/zoomin.cur), pointer;'  align="middle" width='<c:out value="${picture.smallWidth}"/>' height='<c:out value="${picture.smallHeight}"/>' />
</c:if>
<c:if test='${!picture.httpUrl}'>
<img id='currentMyPicture_<c:out value="${requestScope.responseId}"/>' src='<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' style='border: 0px; cursor: url(<%= request.getContextPath() %>/light/images/zoomin.cur), pointer;'  align="middle" width='<c:out value="${picture.smallWidth}"/>' height='<c:out value="${picture.smallHeight}"/>' />
</c:if>
<br/>
<c:out value="${picture.caption}"/>
</span>
</c:if>
</td>
</tr>
</c:forEach>
</table>

<div id='userPictures'>
<c:forEach var="picture" items="${requestScope.userPictures}" varStatus="status">
<c:if test='${picture.httpUrl}'>
<input type='hidden' id='userPicture_<c:out value="${status.index}"/>' name='<c:out value="${picture.id}"/>;<c:out value="${picture.smallWidth}"/>;<c:out value="${picture.smallHeight}"/>;<c:out value="${picture.largeWidth}"/>;<c:out value="${picture.largeHeight}"/>;<c:out value="${picture.pictureUrl}"/>' value='<c:out value="${picture.caption}"/>'/>
</c:if>
<c:if test='${!picture.httpUrl}'>
<input type='hidden' id='userPicture_<c:out value="${status.index}"/>' name='<c:out value="${picture.id}"/>;<c:out value="${picture.smallWidth}"/>;<c:out value="${picture.smallHeight}"/>;<c:out value="${picture.largeWidth}"/>;<c:out value="${picture.largeHeight}"/>;<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' value='<c:out value="${picture.caption}"/>'/>
</c:if>
</c:forEach>
</div>
</c:if>

<c:if test='${requestScope.state == "normal" && requestScope.showMore != null}'>
<span class="portlet-rss" style="text-align:right;">
<a href='javascript:void(0)' onclick="<portlet:renderURL  windowState='MAXIMIZED'/>" >more...</a> 
</span>
</c:if>

</fmt:bundle>
</body>
</html>