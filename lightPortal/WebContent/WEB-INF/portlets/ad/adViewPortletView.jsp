<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<c:if test='${requestScope.type == "1"}'>
<span class="portlet-item">
<fmt:message key="portlet.message.top"/>
<c:out value="${requestScope.showNumber}"/>
<fmt:message key="portlet.message.newestAd"/>
</span>
</c:if>
<c:if test='${requestScope.type == "2"}'>
<span class="portlet-item">
<fmt:message key="portlet.message.top"/>
<c:out value="${requestScope.showNumber}"/>
<fmt:message key="portlet.message.popularAd"/>
</span>
</c:if>
<br/><br/>
<c:if test='${requestScope.adLists != null}'>
<table border='0' cellpadding='0' cellspacing='0'  width='95%'>
<c:forEach var="item" items="${requestScope.adLists}" >
<tr>
<td class='portlet-table-td-left'>
<c:out value="${item.date}"/>
</td>
<td class='portlet-table-td-left'>
<span class="portlet-rss"
	onmouseover="javascript:showAdDesc(event,'<c:out value="${item.id}"/>','<c:out value="${requestScope.responseId}"/>');"
    onmouseout="javascript:hideAdDesc();">
<a href='javascript:void(0);' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','adId=<c:out value="${item.id}"/>');">
<c:if test='${item.status != 0}'>
<c:out value="${item.title}"/>
</c:if>
<c:if test='${item.commentCount != 0}'>
(<c:out value="${item.commentCount}"/> <fmt:message key="portlet.label.comments"/>)
</c:if>
</a>
</span>
</td>
<td class='portlet-table-td-right'>
<span class="portlet-rss">
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${item.uri}"/>'><c:out value="${item.displayName}"/></a>
</span>
</td>
</tr>
</c:forEach>
</table>
</c:if>
<c:if test='${requestScope.error != null}'>
<span class="portlet-item">
<c:out value="${requestScope.error}"/>
</span>
</c:if>
</form>
</fmt:bundle>
</body>
</html>