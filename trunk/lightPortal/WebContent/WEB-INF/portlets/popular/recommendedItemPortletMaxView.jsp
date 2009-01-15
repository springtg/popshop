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
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</table>
</c:if>
<form action="<portlet:actionURL />">
<c:if test='${requestScope.pages > 1}'>
<table border='0' cellpadding='0' cellspacing='0'  width='95%'>
<tr>
<td class='portlet-table-td-right'>
<c:out value="${start}"/> - <c:out value="${end}"/> (<c:out value="${total}"/>)
<span class="portlet-item">
<c:if test='${page > 1}'>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','page=<c:out value="${requestScope.page - 1}"/>');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.label.previous"/>'/></a>						
</c:if>
<c:forEach var="i" begin="1" end="${requestScope.pages}" step="1">
<c:if test='${i != page}'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','page=<c:out value="${i}"/>;pages=<c:out value="${pages}"/>');" ><c:out value="${i}"/></a>
</c:if>
<c:if test='${i == page}'>
<label class='currentpage'><c:out value="${i}"/></label>
</c:if>
</c:forEach>
<c:if test='${page < pages}'>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','page=<c:out value="${requestScope.page + 1}"/>');"><img src='<%= request.getContextPath() %>/light/images/next.gif' style='border: 0px' title='<fmt:message key="portlet.label.next"/>'/></a>						
</c:if>
</span>
</td>
</tr>
</table>
</c:if>
<c:if test='${requestScope.lists != null}'>
<table border='0' cellpadding='0' cellspacing='0'  width='95%'>
   <c:forEach var="item" items="${requestScope.lists}" varStatus="status" >
	<tr>	
	<td class='portlet-table-td-left'>
	<light:authenticateUser>
	<input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' name="<c:out value='${item.id}'/>"  onClick="document.pressed='pop';document.parameter=this.name;"/>	
	<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' name="<c:out value='${item.id}'/>" onClick="document.pressed='forward';document.parameter=this.name;"/>
	</light:authenticateUser>
	<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' name="<c:out value='${item.id}'/>" onClick="document.pressed='bookmark';document.parameter=this.name;"/>
	<a href='http://digg.com/submit?phase=2&url=<c:out value="${item.link}"/>&title=<c:out value="${item.title}"/>&bodytext=<c:out value="${item.desc}"/>&topic=world_news' target='_blank'><img src="<%= request.getContextPath() %>/light/images/digg.gif" title="digg it!" alt="digg it!" border="0" /></a>
    <light:authenticateOwner>    
    <input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" name="<c:out value='${item.id}'/>" style='border: 0px;' height='11' width='11' onClick="document.pressed='delete';document.parameter=this.name;"/>
    </light:authenticateOwner>
    <span class="portlet-rss"
      onmouseover="javascript:showRecommendedItemDesc(event,'<c:out value="${item.id}"/>','<c:out value="${item.link}"/>','<c:out value="${requestScope.responseId}"/>');"
      onmouseout="javascript:hideRecommendedItemDesc();">
   		<a href='javascript:void(0);' onclick="javascript:readRecommendedItem('<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','maximized','index=<c:out value="${item.id}"/>');""><c:out value="${item.title}"/><i>( <c:out value="${item.time}"/>)</i></a>   		
   </span>
</td>
</tr>
   </c:forEach>   
</table>
</c:if>
<tr>
<span class="portlet-rss" style="text-align:right;padding : 15 15 15 15;">
	<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" >back</a>
</span>
<br/>
</form>
</fmt:bundle>
</body>
</html>