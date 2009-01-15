<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<table width='100%' border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-center' width='100%'>
<a href="javascript:void(0);" onclick="javascript:previousItem('<c:out value="${requestScope.responseId}"/>','<c:out value="${requestScope.currentNumber}"/>');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' /></a>						
<a href="javascript:void(0);" onclick="javascript:nextItem('<c:out value="${requestScope.responseId}"/>','<c:out value="${requestScope.currentNumber}"/>');"><img src='<%= request.getContextPath() %>/light/images/next.gif' style='border: 0px' /></a>
<light:authenticateUser>  
<input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' onClick="javascript:popRssItem(event,'<c:out value="${requestScope.currentNumber}"/>','<c:out value="${requestScope.responseId}"/>');"/>
<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' onClick="javascript:forwardRssToFriend(event,'<c:out value="${requestScope.currentNumber}"/>','<c:out value="${requestScope.responseId}"/>');"/>
</light:authenticateUser>
<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' onClick="javascript:saveToBookmark(event,'<c:out value="${requestScope.currentNumber}"/>','<c:out value="${requestScope.responseId}"/>');"/>	
</td>
</tr>

<tr>
<td class='portlet-table-td-center' width='100%'>
<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0"
WIDTH="300" HEIGHT="250" style='text-align: center;' >
<PARAM NAME='movie' VALUE='<c:out value="${requestScope.currentLink}"/>'/>
<PARAM NAME='quality' VALUE='high'/>
<PARAM NAME='bgcolor' VALUE='#FFFFFF'/>
<EMBED src='<c:out value="${requestScope.currentLink}"/>' quality='high' bgcolor='#FFFFFF' WIDTH="300" HEIGHT="250"
 ALIGN="" TYPE="application/x-shockwave-flash"
PLUGINSPAGE="http://www.macromedia.com/go/getflashplayer">
</EMBED>
</OBJECT>
<br/>
<c:out value="${requestScope.currentTitle}"/>
</td>
</tr>
</table>
</body>
</html>