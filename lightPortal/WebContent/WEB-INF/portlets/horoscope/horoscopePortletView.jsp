<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr valign="top">
<td style='text-align:left; padding : 0 0 5 5; font-family: Cursive;'>
<c:if test='${horoscope != null}'>
<img src='<%= request.getContextPath() %>/light/images/h<c:out value="${horoscope.id}"/>.gif' style='border: 0px;float: left; margin-right: 10;'  align="middle" />
<c:out value="${horoscope.shortOverview}"/>
</c:if>
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>