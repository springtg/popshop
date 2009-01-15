<%@ include file="/common/taglibs.jsp"%>
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
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</table>
</c:if>

<table border='0' cellpadding='0' cellspacing='0'  width='100%'>
<tr>	
	<td class='portlet-table-td-center'>
	<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','maximized','previous=1;index=<c:out value="${item.index}"/>');" ><img src='<%= request.getContextPath() %>/light/images/previous.gif' title='<fmt:message key="portlet.label.previous"/>' style='border: 0px' /></a>						
	<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','maximized','next=1;index=<c:out value="${item.index}"/>');" ><img src='<%= request.getContextPath() %>/light/images/next.gif' title='<fmt:message key="portlet.label.next"/>' style='border: 0px' /></a>	
	<light:authenticateUser>
	<input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' onClick="javascript:popRssItem(event,'<c:out value="${item.index}"/>','<c:out value="${requestScope.responseId}"/>');"/>
	<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' onClick="javascript:forwardRssToFriend(event,'<c:out value="${item.index}"/>','<c:out value="${requestScope.responseId}"/>');"/>
	<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' onClick="javascript:saveToBookmark(event,'<c:out value="${item.index}"/>','<c:out value="${requestScope.responseId}"/>');"/>	
	<a href='http://digg.com/submit?phase=2&url=<c:out value="${item.link}"/>&title=<c:out value="${item.title}"/>&bodytext=<c:out value="${item.desc}"/>&topic=world_news' target='_blank'><img src="<%= request.getContextPath() %>/light/images/digg.gif" alt="digg it!" title="digg it!" border="0" /></a>
	</light:authenticateUser>
	<input type="image" title='<fmt:message key="portlet.button.back"/>' src="<%= request.getContextPath() %>/light/images/exit.gif" style='border: 0px;' height='16' width='16' name="<c:out value='${item.index}'/>" onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');"/>
    </td>
</tr>
</table>

<table width="100%">    
    <tr>
        <td>
        	<c:if test='${requestScope.state == "normal"}'>
            <iframe src="<c:out value="${item.link}"/>" width="100%" height="<%= request.getAttribute("readerHeight") %>" frameborder="0">
	            Your browser does not support iframes
            </iframe>
            </c:if>
            <c:if test='${requestScope.state == "maximized"}'>
            <iframe src="<c:out value="${item.link}"/>" width="100%" height="<%= request.getAttribute("readerMaxHeight") %>" frameborder="0">
	            Your browser does not support iframes
            </iframe>
            </c:if>
        </td>
    </tr>
</table>
</fmt:bundle>