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
<light:authorizeGroupMember type='yes'>
<c:if test='${requestScope.group.memberImage == 1}'> 
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'/>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.addPicture"/></a>
</td>
</tr>
</table>
</c:if>
</light:authorizeGroupMember>
<light:authorizeGroupMember type='leader'>
<c:if test='${requestScope.group.memberImage == 0}'> 
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'/>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.addPicture"/></a>
</td>
</tr>
</table>
</c:if>
</light:authorizeGroupMember>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<fmt:message key="portlet.label.thisGroup"/> <c:out value="${requestScope.pictureCount}"/> <fmt:message key="portlet.label.pictures"/>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >

<c:forEach var="picture" items="${requestScope.showPictures}" varStatus="status">
<c:if test='${status.index % columnNumber == 0}'>
<tr>
</c:if>
<td class='portlet-table-td-center'>
<img src='<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' style='border: 0px; cursor: url(<%= request.getContextPath() %>/light/images/zoomin.cur), pointer;'  align="middle" width='<c:out value="${picture.smallWidth}"/>' height='<c:out value="${picture.smallHeight}"/>' 
onclick="javascript:viewMaxGroupPictureAtClient(event,'<c:out value="${requestScope.responseId}"/>','<c:out value="${picture.id}"/>','<c:out value="${picture.pictureUrl}"/>','<c:out value="${picture.caption}"/>','<c:out value="${picture.largeWidth}"/>','<c:out value="${picture.largeHeight}"/>');"
onmouseover="javascript:this.style.border='2px solid #83C2CD';"
onmouseout="javascript:this.style.border='';"
/>
<br/>
<c:out value="${picture.caption}"/>
</td>
<c:if test='${status.index % columnNumber == columnNumber - 1}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.pictureCount % columnNumber != 0}'>
</tr>
</c:if>
</table>
</form>
<c:if test='${requestScope.state == "normal" && requestScope.showMore != null}'>
<span class="portlet-rss" style="text-align:right;">
<a href='javascript:void(0)' onclick="<portlet:renderURL  windowState='MAXIMIZED'/>" >more......</a> 
</span>
</c:if>
</fmt:bundle>
</body>
</html>
