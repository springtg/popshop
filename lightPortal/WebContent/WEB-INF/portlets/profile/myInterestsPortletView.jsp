<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<c:if test='${userProfile.interests != null && userProfile.interests != ""}'>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<FONT color='#ff6600'><fmt:message key="portlet.label.interests"/></FONT>
</td>
</tr>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<c:out value="${userProfile.interests}" escapeXml="false"/><br/><br/>
</td>
</tr>
</c:if>
<c:if test='${userProfile.music != null && userProfile.music != ""}'>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<FONT color='#ff6600'><fmt:message key="portlet.label.music"/></FONT>
</td>
</tr>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<c:out value="${userProfile.music}" escapeXml="false"/><br/><br/>
</td>
</tr>
</c:if>
<c:if test='${userProfile.movies != null && userProfile.movies != ""}'>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<FONT color='#ff6600'><fmt:message key="portlet.label.movies"/></FONT>
</td>
</tr>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<c:out value="${userProfile.movies}" escapeXml="false"/><br/><br/>
</td>
</tr>
</c:if>
<c:if test='${userProfile.television != null && userProfile.television != ""}'>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<FONT color='#ff6600'><fmt:message key="portlet.label.television"/></FONT>
</td>
</tr>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<c:out value="${userProfile.television}" escapeXml="false"/><br/><br/>
</td>
</tr>
</c:if>
<c:if test='${userProfile.books != null && userProfile.books != ""}'>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<FONT color='#ff6600'><fmt:message key="portlet.label.books"/></FONT>
</td>
</tr>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<c:out value="${userProfile.books}" escapeXml="false"/><br/><br/>
</td>
</tr>
</c:if>
<c:if test='${userProfile.heroes != null && userProfile.heroes != ""}'>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<FONT color='#ff6600'><fmt:message key="portlet.label.heroes"/></FONT>
</td>
</tr>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<c:out value="${userProfile.heroes}" escapeXml="false"/><br/><br/>
</td>
</tr>
</c:if>
</table>
</fmt:bundle>
</body>
</html>