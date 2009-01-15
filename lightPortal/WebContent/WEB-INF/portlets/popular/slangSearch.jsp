<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form action="http://www.noslang.com/search.php" method="get" target="_blank">
<table>
<tr>
<td valign="bottom">
<a href="http://www.noslang.com"><img src="http://www.noslang.com/realsmall.gif" border=0 alt="No Slang"></a>
</td>
<td>
<input size="10" name="st" value="lol">
</td>
<td>
<input type="submit" name="submit" value='<fmt:message key="portlet.button.go"/>'>
</td>
</tr>
</table>
</form> 
</fmt:bundle>
</body>
</html>