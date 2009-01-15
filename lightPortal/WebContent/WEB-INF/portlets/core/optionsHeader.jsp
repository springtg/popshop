<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='600'>
<tr class='portlet-table-td-left' width='600'>
<td class='portlet-rss' >
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name="action" value="general"/></portlet:renderURL>" >
<c:if test='${current == "general"}'>
<b>
</c:if>
<fmt:message key="portlet.label.general"/>
<c:if test='${current == "general"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%= request.getContextPath() %>/light/images/spacer.gif' style='border: 0px' /></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name="action" value="theme"/></portlet:renderURL>" >
<c:if test='${current == "theme"}'>
<b>
</c:if>
<fmt:message key="portlet.label.theme"/>
<c:if test='${current == "theme"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%= request.getContextPath() %>/light/images/spacer.gif' style='border: 0px' /></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name="action" value="page"/></portlet:renderURL>" >
<c:if test='${current == "page"}'>
<b>
</c:if>
<fmt:message key="portlet.label.managePage"/>
<c:if test='${current == "page"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%= request.getContextPath() %>/light/images/spacer.gif' style='border: 0px' /></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name="action" value="language"/></portlet:renderURL>" >
<c:if test='${current == "language"}'>
<b>
</c:if>
<fmt:message key="portlet.label.language"/>
<c:if test='${current == "language"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%= request.getContextPath() %>/light/images/spacer.gif' style='border: 0px' /></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name="action" value="localContent"/></portlet:renderURL>" >
<c:if test='${current == "localContent"}'>
<b>
</c:if>
<fmt:message key="portlet.label.localContent"/>
<c:if test='${current == "localContent"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%= request.getContextPath() %>/light/images/spacer.gif' style='border: 0px' /></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name="action" value="timeZone"/></portlet:renderURL>" >
<c:if test='${current == "timeZone"}'>
<b>
</c:if>
<fmt:message key="portlet.label.timeZone"/>
<c:if test='${current == "timeZone"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%= request.getContextPath() %>/light/images/spacer.gif' style='border: 0px' /></span>
</td>
</tr>
<tr class='portlet-table-td-left' width='600'>
<td class='portlet-msg-success' >
<div id='optionsMessage'></div>
</td>
</tr>
</table>
<c:if test='${requestScope.success != null}'>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-success' >
<c:out value="${requestScope.success}" escapeXml="false"/>
</td>
</tr>
</table>
</c:if>
<c:if test='${requestScope.error != null}'>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
<c:out value="${requestScope.error}" escapeXml="false"/>
</td>
</tr>
</table>
</c:if>
</fmt:bundle>
</body>
</html>