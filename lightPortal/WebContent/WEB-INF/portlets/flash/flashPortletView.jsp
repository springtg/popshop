<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-center'>
<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" width='<c:out value="${requestScope.width}"/>' height='<c:out value="${requestScope.height}"/>'>
  <param name=movie value='<c:out value="${requestScope.name}"/>'>

  <param name=quality value=high>
  <embed src='<c:out value="${requestScope.name}"/>' quality=high pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width='<c:out value="${requestScope.width}"/>' height='<c:out value="${requestScope.height}"/>'>
  </embed> 
</object>
</td>
</tr>
</table>
</fmt:bundle>
</body>
</html>