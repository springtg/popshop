<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<c:forEach var="buddy" items="${requestScope.buddys}" varStatus="status">
<c:if test='${status.index % 3 == 0}'>
<tr valign='top'>
</c:if>
<td class='portlet-table-td-center' width= '33%'>
<span class='portlet-item'>
<c:if test='${buddy.buddyCurrentStatusId == 1}'>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px' width='15' height='12' align="bottom" alt=''/>
</c:if>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.uri}"/>' ><c:out value="${buddy.displayName}"/></a>
</span>
<br/>
<c:if test='${buddy.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${buddy.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${buddy.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${buddy.photoSmallWidth}"/>' height='<c:out value="${buddy.photoSmallHeight}"/>'/>
</c:if>
</td>
<c:if test='${status.index % 3 == 3 - 1}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.showNumber % 3 != 0}'>
</tr>
</c:if>
</table>
<c:if test='${requestScope.state == "normal" && requestScope.showMore != null}'>
<span class="portlet-rss" style="text-align:right;">
<a href='javascript:void(0)' onclick="<portlet:renderURL  windowState='MAXIMIZED'/>" >more...</a> 
</span>
</c:if>
</fmt:bundle>
</body>
</html>