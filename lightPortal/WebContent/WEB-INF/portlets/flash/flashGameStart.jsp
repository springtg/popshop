<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-title'>
<b><c:out value="${game.title}"/></b>
</td>
<td class='portlet-link' >
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" ><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.button.back"/>'/></a>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<b><fmt:message key="portlet.label.desc"/></b>:
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:out value="${game.desc}" escapeXml="false"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<b><fmt:message key="portlet.label.instructions"/></b>:
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:out value="${game.instructions}" escapeXml="false"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-center' colspan='2'>
<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" width='<c:out value="${game.width}"/>' height='<c:out value="${game.height}"/>'>
  <param name=movie value='<c:out value="${game.link}"/>'>

  <param name=quality value=high>
  <embed src='<c:out value="${game.link}"/>' quality=high pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width='<c:out value="${game.width}"/>' height='<c:out value="${game.height}"/>'>
  </embed> 
</object>
</td>
</tr>
</table>
</fmt:bundle>
</body>
</html>