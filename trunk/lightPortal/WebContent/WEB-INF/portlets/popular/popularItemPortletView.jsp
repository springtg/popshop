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
    <image src="<%= request.getContextPath() %>/light/images/showMod.gif" style='border: 0px;cursor:pointer;' height='16' width='16' onClick='javascript:Light.showLinkAction(event,"<c:out value='${requestScope.responseId}'/>","<c:out value='${item.id}'/>","<c:out value='${item.link}'/>",this,"showLinkAction");'/>	
    <a href='<c:out value="${item.link}"/>' target='blank' onclick="javascript:readPopItem('<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');"
      onmouseover="javascript:showPopItemDesc(event,'<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');"
      onmouseout="javascript:hidePopItemDesc();">
   		 <c:out value="${item.title}"/> (<c:out value="${item.popCount}"/> <fmt:message key="portlet.label.votes"/>)</a>
   <a href='javascript:void(0);' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','maximized','showComments=1;itemId=<c:out value="${item.id}"/>');"><c:out value="${item.commentCount}"/> <fmt:message key="portlet.label.comments"/></a>
   </span>   
   </c:forEach>
   
   <c:if test='${requestScope.state == "normal" && requestScope.showMore != null }'>
   <span class="portlet-rss" style="text-align:right;">
   	<a href='javascript:void(0)' onclick="<portlet:renderURL windowState='MAXIMIZED'/>" >more......</a>
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
</form>
</fmt:bundle>
</body>
</html>