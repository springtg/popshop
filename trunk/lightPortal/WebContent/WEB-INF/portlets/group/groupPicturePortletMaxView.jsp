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
&nbsp;
<a href='javascript:void(0)' onclick="javascript:startSlideShow('<c:out value="${requestScope.responseId}"/>',<c:out value="${requestScope.pictureCount}"/>);" ><fmt:message key="portlet.label.startSlideShow"/></a>
&nbsp;
<a href='javascript:void(0)' onclick="javascript:stopSlideShow('<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.stopSlideShow"/></a>
</td>
</tr>
</table>
<c:if test='${requestScope.pictureCount > 0}'>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<tr>
<td class='portlet-table-td-center'>
<span id='picture_<c:out value="${requestScope.responseId}"/>'>
<img id='currentMyPicture_<c:out value="${requestScope.responseId}"/>' src='<%= request.getContextPath() %><c:out value="${currentPictureUrl}"/>' class='portlet'  align="middle" width='<c:out value="${currentPictureWidth}"/>' height='<c:out value="${currentPictureHeight}"/>'/>
<br/><c:out value="${currentCaption}"/>
</span>
<input type='hidden' name='pictureId' value='<c:out value="${currentPictureId}"/>'/>
<input type='hidden' name='groupId' value='<c:out value="${group.id}"/>'/>
</td>
</tr>
</table>
</c:if>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<c:forEach var="picture" items="${requestScope.groupPictures}" varStatus="status">
<c:if test='${status.index % 10 == 0}'>
<tr class='portlet-table-td-center'>
<td >
</c:if>

<span width= '70' >
<c:if test='${picture.pictureUrl == currentPictureUrl}'>
<a href='javascript:void(0);' onclick="javascript:viewGroupPicture('<c:out value="${requestScope.responseId}"/>','<c:out value="${group.id}"/>','<c:out value="${picture.pictureUrl}"/>','<c:out value="${picture.caption}"/>','<c:out value="${picture.id}"/>','<c:out value="${picture.largeWidth}"/>','<c:out value="${picture.largeHeight}"/>');">
<img id='pictures_<c:out value="${status.index}"/>' name='<c:out value="${picture.id}"/>;<c:out value="${picture.largeWidth}"/>;<c:out value="${picture.largeHeight}"/>;<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>;<c:out value="${picture.status}"/>;<c:out value="${picture.tag}"/>' value='<c:out value="${picture.caption}"/>' src='<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${picture.largeWidth / 8}"/>' height='<c:out value="${picture.largeHeight / 8}"/>'/>
</a>
</c:if>
<c:if test='${picture.pictureUrl != currentPictureUrl}'>
<a href='javascript:void(0);' onclick="javascript:viewGroupPicture('<c:out value="${requestScope.responseId}"/>','<c:out value="${group.id}"/>','<c:out value="${picture.pictureUrl}"/>','<c:out value="${picture.caption}"/>','<c:out value="${picture.id}"/>','<c:out value="${picture.largeWidth}"/>','<c:out value="${picture.largeHeight}"/>');">
<img id='pictures_<c:out value="${status.index}"/>' name='<c:out value="${picture.id}"/>;<c:out value="${picture.largeWidth}"/>;<c:out value="${picture.largeHeight}"/>;<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>;<c:out value="${picture.status}"/>;<c:out value="${picture.tag}"/>' value='<c:out value="${picture.caption}"/>' src='<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${picture.largeWidth / 8}"/>' height='<c:out value="${picture.largeHeight / 8}"/>'/>
</a>
</c:if>
</span>
<c:if test='${status.index % 10 == 9}'>
</td>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.pictureCount % 10 != 0}'>
</td>
</tr>
</c:if>
<light:authenticateUser> 
<c:if test='${requestScope.pictureCount > 0}'>
<tr>
<td class='portlet-table-td-center' colspan='5'>
<br/><br/>
<input type='submit' onClick="document.pressed='caption';stopSlideShow('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.caption"/>' class='portlet-form-button' />
<input type='submit' onClick="document.pressed='profile';stopSlideShow('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.profilePhoto"/>' class='portlet-form-button' />
<input type='submit' onClick="document.pressed='background';stopSlideShow('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.backgroundPicture"/>' class='portlet-form-button' />
<light:authorizeGroupMember type='leader'>
<input type='submit' onClick="document.pressed='delete';stopSlideShow('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.delete"/>' class='portlet-form-button' />
</light:authorizeGroupMember>
</td>
</tr>
</c:if>
</light:authenticateUser>
</table>
</form>
</fmt:bundle>
</body>
</html>
