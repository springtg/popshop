<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width= '220'>
<c:forEach var="favourite" items="${requestScope.userFavourites}" >
<tr>
<td class='portlet-table-td-center'>
<span class="portlet-item">
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${favourite.uri}"/>' ><c:out value="${favourite.displayName}"/></a>
</span>
<br/>
<c:if test='${favourite.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${favourite.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${favourite.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${favourite.photoSmallWidth}"/>' height='<c:out value="${favourite.photoSmallHeight}"/>'/>
</c:if>
</td>
</tr>
</c:forEach>
</table>
</fmt:bundle>
</body>
</html>