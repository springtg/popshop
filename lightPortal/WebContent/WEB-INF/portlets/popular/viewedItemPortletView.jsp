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
    <a href='javascript:void(0);' onclick="javascript:readViewedItem('<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','maximized','index=<c:out value="${item.id}"/>');"
      onmouseover="javascript:showViewedItemDesc(event,'<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');"
      onmouseout="javascript:hideViewedItemDesc();">
   	  <c:out value="${item.title}"/></a>
   </span>
   </c:forEach>
   
   <c:if test='${requestScope.state == "normal" && requestScope.showMore != null }'>
   <span class="portlet-rss" style="text-align:right;">
   	<a href='javascript:void(0)' onclick="<portlet:renderURL windowState='MAXIMIZED'/>" ><fmt:message key="portlet.label.more"/>...</a>
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
</form>
</fmt:bundle>
</body>
</html>