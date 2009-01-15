<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<h4><c:out value="${requestScope.userProfile.headline}"/></h4>
</td>
</tr>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<c:out value="${requestScope.userProfile.aboutMe}" escapeXml="false"/><br/><br/>
</td>
</tr>
<c:if test='${userProfile.likeToMeet != null && userProfile.likeToMeet != ""}'>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<FONT color='#ff6600'><fmt:message key="portlet.label.likeToMeet"/></FONT>
</td>
</tr>
<tr>
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<c:out value="${requestScope.userProfile.likeToMeet}" escapeXml="false"/><br/><br/>
</td>
</tr>
</c:if>
</table>
</fmt:bundle>
</body>
</html>