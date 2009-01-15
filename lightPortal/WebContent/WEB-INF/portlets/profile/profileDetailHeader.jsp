<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr class='portlet-table-td-left'>
<td class='portlet-rss' >
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='action' value='name'/></portlet:renderURL>" >
<c:if test='${current == "name"}'>
<b>
</c:if>
<fmt:message key="portlet.label.name"/>
<c:if test='${current == "name"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'>
<img src='<%=request.getContextPath() %>/light/images/spacer.gif' style='border: 0px'/></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='action' value='interests'/></portlet:renderURL>" >
<c:if test='${current == "interests"}'>
<b>
</c:if>
<fmt:message key="portlet.label.interests"/>
<c:if test='${current == "interests"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%=request.getContextPath() %>/light/images/spacer.gif' style='border: 0px'/></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='action' value='basic'/></portlet:renderURL>" >
<c:if test='${current == "basic"}'>
<b>
</c:if>
<fmt:message key="portlet.label.basic"/>
<c:if test='${current == "basic"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%=request.getContextPath() %>/light/images/spacer.gif' style='border: 0px'/></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='action' value='background'/></portlet:renderURL>" >
<c:if test='${current == "background"}'>
<b>
</c:if>
<fmt:message key="portlet.label.background"/>
<c:if test='${current == "background"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%=request.getContextPath() %>/light/images/spacer.gif' style='border: 0px'/></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='action' value='account'/></portlet:renderURL>" >
<c:if test='${current == "account"}'>
<b>
</c:if>
<fmt:message key="portlet.label.account"/>
<c:if test='${current == "account"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%=request.getContextPath() %>/light/images/spacer.gif' style='border: 0px'/></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='action' value='privacy'/></portlet:renderURL>" >
<c:if test='${current == "privacy"}'>
<b>
</c:if>
<fmt:message key="portlet.label.privacy"/>
<c:if test='${current == "privacy"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%=request.getContextPath() %>/light/images/spacer.gif' style='border: 0px'/></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='action' value='channels'/></portlet:renderURL>" >
<c:if test='${current == "channels"}'>
<b>
</c:if>
<fmt:message key="portlet.label.channels"/>
<c:if test='${current == "channels"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%=request.getContextPath() %>/light/images/spacer.gif' style='border: 0px'/></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='action' value='block'/></portlet:renderURL>" >
<c:if test='${current == "block"}'>
<b>
</c:if>
<fmt:message key="portlet.label.blockUsers"/>
<c:if test='${current == "block"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'><img src='<%=request.getContextPath() %>/light/images/spacer.gif' style='border: 0px'/></span>
<a href='javascript:void(0)' onclick="<portlet:renderURL><portlet:param name='action' value='invite'/></portlet:renderURL>" >
<c:if test='${current == "invite"}'>
<b>
</c:if>
<fmt:message key="portlet.label.inviteHistory"/>
<c:if test='${current == "invite"}'>
</b>
</c:if>
</a>
</td>
</tr>
</table>
<c:if test='${requestScope.success != null}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-success' >
<c:out value="${requestScope.success}" escapeXml="false"/>
</td>
</tr>
</table>
</c:if>
<c:if test='${requestScope.error != null}'>
<br/>
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