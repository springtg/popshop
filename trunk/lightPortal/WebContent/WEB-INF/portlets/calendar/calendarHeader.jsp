<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr valign=bottom>
<td class='portlet-link-left' >
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'><portlet:param name="eventId" value="0"/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.addEvent"/></a>
</light:authenticateOwner>
</td>
<td class='portlet-link' >
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="<portlet:actionURL><portlet:param name="type" value="0"/></portlet:actionURL>" >
<c:if test='${current == "0"}'>
<b>
</c:if>
<fmt:message key="portlet.label.calendarOverview"/>
<c:if test='${current == "0"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'></span>
<a href='javascript:void(0)' onclick="<portlet:actionURL><portlet:param name="type" value="1"/></portlet:actionURL>" >
<c:if test='${current == "1"}'>
<b>
</c:if>
<fmt:message key="portlet.label.calendarDay"/>
<c:if test='${current == "1"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'></span>
<a href='javascript:void(0)' onclick="<portlet:actionURL ><portlet:param name="type" value="2"/></portlet:actionURL>" >
<c:if test='${current == "2"}'>
<b>
</c:if>
<fmt:message key="portlet.label.calendarWeekday"/>
<c:if test='${current == "2"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'></span>
<a href='javascript:void(0)' onclick="<portlet:actionURL ><portlet:param name="type" value="3"/></portlet:actionURL>" >
<c:if test='${current == "3"}'>
<b>
</c:if>
<fmt:message key="portlet.label.calendarWeek"/>
<c:if test='${current == "3"}'>
</b>
</c:if>
</a>
<span class='portal-header-menu-item-separater'></span>
<a href='javascript:void(0)' onclick="<portlet:actionURL><portlet:param name="type" value="4"/></portlet:actionURL>" >
<c:if test='${current == "4"}'>
<b>
</c:if>
<fmt:message key="portlet.label.calendarMonth"/>
<c:if test='${current == "4"}'>
</b>
</c:if>
</a>
</span>
</td>
</tr>
<tr>
<td class='portlet-msg-success' >
<div id='calendarMessage'></div>
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