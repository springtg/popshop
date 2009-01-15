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
<form action="<portlet:actionURL />">
	<c:if test='${requestScope.lists != null}'>
	   <c:forEach var="item" items="${requestScope.lists}" varStatus="status" >
	   <span class="portlet-rss">
	    <img src="<%= request.getContextPath() %>/light/images/showMod.gif" style='border: 0px;cursor:pointer;' height='16' width='16' onClick='javascript:Light.showLinkAction(event,"<c:out value='${requestScope.responseId}'/>","<c:out value='${item.id}'/>","<c:out value='${item.link}'/>",this,"showLinkAction");'/>	
	    <a href='javascript:void(0);' onclick="javascript:readRecommendedItem('<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','maximized','index=<c:out value="${item.id}"/>');"
	      onmouseover="javascript:showRecommendedItemDesc(event,'<c:out value="${item.id}"/>','<c:out value="${item.link}"/>','<c:out value="${requestScope.responseId}"/>');"
	      onmouseout="javascript:hideRecommendedItemDesc();">
	   	  <c:out value="${item.title}"/></a>
	   </span>
	   </c:forEach>
	  <c:if test='${pages > 1}'>
	  	<span class="portlet-rss" style="text-align:center;padding-top:5px;">
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
	   </c:if>
	</c:if>
</form>
</fmt:bundle>
</body>
</html>