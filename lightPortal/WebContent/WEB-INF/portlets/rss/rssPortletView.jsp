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
<c:if test='${requestScope.rssLists != null}'>	
    <c:if test='${requestScope.portlet.showType == 0}'>
		<c:forEach var="item" items="${requestScope.rssLists}" >		
		<span class="portlet-rss" >
		<light:authenticateUser> 
		<image src="<%= request.getContextPath() %>/light/images/showMod.gif" style='border: 0px;cursor:pointer;' height='16' width='16' onClick='javascript:Light.showLinkAction(event,"<c:out value='${requestScope.responseId}'/>","<c:out value='${item.index}'/>","<c:out value='${item.link}'/>",this,"showNewsAction");'/>	
	    </light:authenticateUser> 
	    <a href='javascript:void(0);' onclick="javascript:trackRssItem('<c:out value="${item.index}"/>','<c:out value="${requestScope.responseId}"/>');Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','maximized','index=<c:out value="${item.index}"/>');"
			onmouseover="javascript:showRssDesc(event,'<c:out value="${item.index}"/>','<c:out value="${item.link}"/>','<c:out value="${requestScope.responseId}"/>');"
		    onmouseout="javascript:hideRssDesc();"><c:out value="${item.title}"/></a>	
		</span>
		
		</c:forEach>
	</c:if>
	
	<c:if test='${requestScope.portlet.showType == 1}'>
	<c:forEach var="item" items="${requestScope.rssLists}" >
	<span class="portlet-rss">
	<image src="<%= request.getContextPath() %>/light/images/showMod.gif" style='border: 0px;cursor:pointer;' height='16' width='16' onClick='javascript:Light.showLinkAction(event,"<c:out value='${requestScope.responseId}'/>","<c:out value='${item.index}'/>","<c:out value='${item.link}'/>",this,"showNewsAction");'/>	
    <c:if test='${item.addLink}'>
	<a href='<c:out value="${item.link}"/>' target='_blank' onclick="javascript:trackRssItem('<c:out value="${item.index}"/>','<c:out value="${requestScope.responseId}"/>');"><c:out value="${item.desc}" escapeXml="false"/></a>
	<br/>
	</c:if>
	<c:if test='${!item.addLink}'>
	<c:out value="${item.desc}" escapeXml="false"/>
	</c:if>
	<br/>
	</span>
	</c:forEach>
	</c:if>
	
	<c:if test='${requestScope.portlet.showType == 2}'>
	<c:forEach var="item" items="${requestScope.rssLists}" >
	<span class="portlet-rss">
	<image src="<%= request.getContextPath() %>/light/images/showMod.gif" style='border: 0px;cursor:pointer;' height='16' width='16' onClick='javascript:Light.showLinkAction(event,"<c:out value='${requestScope.responseId}'/>","<c:out value='${item.index}'/>","<c:out value='${item.link}'/>",this,"showNewsAction");'/>	
    <a href='<c:out value="${item.link}"/>' target='_blank' onclick="javascript:trackRssItem('<c:out value="${item.index}"/>','<c:out value="${requestScope.responseId}"/>');"><c:out value="${item.title}"/></a>
	<br/>
	<c:out value="${item.desc}" escapeXml="false"/>
	<br/>
	</span>	
	</c:forEach>
	</c:if>
	
	<c:if test='${requestScope.state == "normal" && requestScope.showMore != null }'>
	<span class="portlet-rss" style="text-align:center;padding-top:5px;">
		<c:if test='${page > 1}'>
			<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','','previousPage=1;page=<c:out value="${requestScope.page}"/>');" ><img src='<%= request.getContextPath() %>/light/images/previous.gif' title='<fmt:message key="portlet.label.previous"/>' style='border: 0px' /></a>						
		</c:if>
		<c:forEach var="i" begin="1" end="${requestScope.pages}" step="1">
		<c:if test='${i != page}'>
		<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','page=<c:out value="${i}"/>');" ><c:out value="${i}"/></a>
		</c:if>
		<c:if test='${i == page}'>
		<label class='currentpage'><c:out value="${i}"/></label>
		</c:if>
		</c:forEach>
		<c:if test='${page < pages}'>
			<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','','nextPage=1;page=<c:out value="${requestScope.page}"/>');" ><img src='<%= request.getContextPath() %>/light/images/next.gif' title='<fmt:message key="portlet.label.next"/>' style='border: 0px' /></a>	
		</c:if>
	</span>
	</c:if>
</c:if>
<c:if test='${requestScope.error != null}'>
<br/>
<span class="portlet-item">
<c:out value="${requestScope.error}"/>
</span>
<br/>
</c:if>
<c:if test='${requestScope.showMore == null }'>
<br/>	
</c:if>
</fmt:bundle>
</body>
</html>