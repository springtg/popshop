<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<c:forEach var="horoscope" items="${requestScope.horoscopes}" >
<tr>
<td style='text-align:center; padding : 0 0 5 5; font-family: Cursive;' width='20%'>
<c:out value="${horoscope.startDate}"/> ~ <c:out value="${horoscope.endDate}"/>
</td>
<td/>
<td/>
</tr>
<tr valign="top">
<c:if test='${horoscope.user == null}'>
<td style='text-align:center; padding : 0 0 5 5; font-family: Cursive;' width='20%'>
<img src='<%= request.getContextPath() %>/light/images/h<c:out value="${horoscope.id}"/>.gif' style='border: 0px;'  align="left"/>
</td>
</c:if>
<c:if test='${horoscope.user != null}'>
<td width='20%' style='background-image:url(<%= request.getContextPath() %>/light/images/h<c:out value="${horoscope.id}"/>.gif); background-repeat:no-repeat; text-align:center; padding : 0 0 30 30; font-family: Cursive;'>
<c:out value="${horoscope.user.displayName}"/>
</td>
</c:if>
<td width='50%' style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<c:if test='${horoscope.weeklyInfo != null}'>
<c:out value="${horoscope.weeklyInfo}"/>
</c:if>
<c:if test='${horoscope.weeklyInfo == null}'>
<c:out value="${horoscope.overview}"/>
</c:if>
</td>
<td class='portlet-table-td-left' width='30%'>
<b><c:out value="${horoscope.title}"/> <fmt:message key="portlet.label.friends"/>:</b>
<br/>
<c:if test='${horoscope.buddys != null}'>
<c:forEach var="buddy" items="${horoscope.buddys}" varStatus="status">
<span class='portlet-item'>
<c:if test='${status.index != 0}'>,</c:if>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.uri}"/>' ><c:out value="${buddy.displayName}"/></a>
</span>
</c:forEach>
</c:if>
<c:if test='${horoscope.buddys == null}'>
<fmt:message key="portlet.label.none"/>
</c:if>
</td>
</tr>
</c:forEach>
</table>
</form>
</fmt:bundle>
</body>
</html>