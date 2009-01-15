<%@ include file="/common/taglibs.jsp"%>
<html>
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
<c:out value="${i}"/>
</c:if>
</c:forEach>
<c:if test='${page < pages}'>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','page=<c:out value="${requestScope.page + 1}"/>');"><img src='<%= request.getContextPath() %>/light/images/next.gif' style='border: 0px' title='<fmt:message key="portlet.label.previous"/>'/></a>						
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
	<td class='portlet-table-td-center' width='10%'>   
	<span class="portlet-item">
	<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${item.uri}"/>' ><c:out value="${item.displayName}"/></a>
	<br/>
	<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${item.uri}"/>' >
	<c:if test='${item.photoUrl == null}'>
	<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='40' height='30'/>
	</c:if>
	<c:if test='${item.photoUrl != null}'>
	<img src='<%= request.getContextPath() %><c:out value="${item.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${item.photoSmallWidth / 4}"/>' height='<c:out value="${item.photoSmallHeight / 4}"/>'/>
	</c:if>
	</a>
	<br/>
	<c:if test='${item.currentStatusId == 1 }'>
	<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px;' height='16' width='16'  align="bottom" alt=''/>
	</c:if>
	</span>
	</td>
	<td class='portlet-table-td-left'>
	<b><FONT color='#ff6600' size='4'><c:out value="${item.popCount}"/></FONT></b> <fmt:message key="portlet.label.votes"/> 
	<input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' name="<c:out value='${item.id}'/>"  onClick="document.pressed='pop';document.parameter=this.name;"/>
	<light:authenticateUser>
	<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' name="<c:out value='${item.id}'/>" onClick="document.pressed='forward';document.parameter=this.name;"/>
	</light:authenticateUser>
	<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' name="<c:out value='${item.id}'/>" onClick="document.pressed='bookmark';document.parameter=this.name;"/>
	<a href='http://digg.com/submit?phase=2&url=<c:out value="${item.link}"/>&title=<c:out value="${item.title}"/>&bodytext=<c:out value="${item.desc}"/>&topic=world_news' target='_blank'><img src="<%= request.getContextPath() %>/light/images/digg.gif" alt="digg it!" title="digg it!" border="0" height='16' width='16'/></a>
	<light:authorize role="ROLE_ADMIN"> 
    	<input type="image" title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" name="<c:out value='${item.id}'/>" style='border: 0px;' height='11' width='11' onClick="document.pressed='delete';document.parameter=this.name;"/>          
    </light:authorize>
	<br/>
    <span class="portlet-rss">
   	<a href='<c:out value="${item.link}"/>' target='blank' onclick="javascript:readPopItem('<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');"
   	  onmouseover="javascript:showPopItemDesc(event,'<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');"
      onmouseout="javascript:hidePopItemDesc();"><c:out value="${item.title}"/></a>  
    <a href='javascript:void(0);' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','maximized','showComments=1;itemId=<c:out value="${item.id}"/>');"><c:out value="${item.commentCount}"/> <fmt:message key="portlet.label.comments"/></a>    
   </span>
</td>
</tr>
   </c:forEach>   
</table>
</c:if>
<br/>
</form>
</fmt:bundle>
</body>
</html>