<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<table width='100%' border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-center' width='100%'>
<a href="javascript:void(0);" onclick="javascript:previousItem('<c:out value="${requestScope.responseId}"/>','<c:out value="${requestScope.currentNumber}"/>');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' /></a>						
<a href="javascript:void(0);" onclick="javascript:nextItem('<c:out value="${requestScope.responseId}"/>','<c:out value="${requestScope.currentNumber}"/>');"><img src='<%= request.getContextPath() %>/light/images/next.gif' style='border: 0px' /></a>
<light:authenticateUser>  
<input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' onClick="javascript:popRssItem(event,'<c:out value="${requestScope.currentNumber}"/>','<c:out value="${requestScope.responseId}"/>');"/>
<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' onClick="javascript:forwardRssToFriend(event,'<c:out value="${requestScope.currentNumber}"/>','<c:out value="${requestScope.responseId}"/>');"/>
<input type="image" title='<fmt:message key="portlet.label.savePicture"/>' src="<%= request.getContextPath() %>/light/images/picture.gif" style='border: 0px;' height='16' width='16' onClick="javascript:saveToMyPicture(event,'<c:out value="${requestScope.currentNumber}"/>','<c:out value="${requestScope.responseId}"/>');"/>	
<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' onClick="javascript:saveToBookmark(event,'<c:out value="${requestScope.currentNumber}"/>','<c:out value="${requestScope.responseId}"/>');"/>	
<input type="image" title='<fmt:message key="portlet.label.saveHeader"/>' src="<%= request.getContextPath() %>/light/images/header.png" style='border: 0px;' height='16' width='16' onClick="javascript:saveToHeader(event,'<c:out value="${requestScope.currentNumber}"/>','<c:out value="${requestScope.responseId}"/>');"/>	
<input type="image" title='<fmt:message key="portlet.label.saveBackground"/>' src="<%= request.getContextPath() %>/light/images/background.png" style='border: 0px;' height='16' width='16' onClick="javascript:saveToBackground(event,'<c:out value="${requestScope.currentNumber}"/>','<c:out value="${requestScope.responseId}"/>');"/>	
</light:authenticateUser>
</td>
</tr>
<tr>
<td class='portlet-table-td-center' width='100%'>
<a href='<c:out value="${requestScope.currentImageLink}"/>' target='_blank'><c:out value="${requestScope.currentImage}" escapeXml="false" /></a>
<br/>
<c:out value="${requestScope.currentTitle}"/>
</td>
</tr>
</table>
</fmt:bundle>
</body>
</html>