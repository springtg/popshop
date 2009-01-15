<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="calendarHeader.jsp" ></jsp:include>
<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>" action="<portlet:actionURL portletMode='VIEW'/>">
<table cellpadding='0' cellspacing='0' width= '98%' align='center' border='0'>
<tr>
<td class='portlet-table-td-center'>
<span class='portlet-table-title'>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=4;previous=1');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' title='<fmt:message key="portlet.label.previous"/>' style='border: 0px' align='top'/></a>						
<c:out value="${requestScope.title}"/>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=4;next=1');"><img src='<%= request.getContextPath() %>/light/images/next.gif' title='<fmt:message key="portlet.label.next"/>' style='border: 0px' align='top'/></a>
</span>
</td>
</tr>
</table>
<table cellpadding='0' cellspacing='0' width= '95%' align='center' class='portlet-table'>
<c:if test='${firstDay == 1}'>
<th><fmt:message key="portlet.label.calendarMonday"/></th>
<th><fmt:message key="portlet.label.calendarTuesday"/></th>
<th><fmt:message key="portlet.label.calendarWednesday"/></th>
<th><fmt:message key="portlet.label.calendarThursday"/></th>
<th><fmt:message key="portlet.label.calendarFriday"/></th>
<th><fmt:message key="portlet.label.calendarSaturday"/></th>
<th><fmt:message key="portlet.label.calendarSunday"/></th>
</c:if>
<c:if test='${firstDay != 1}'>
<th><fmt:message key="portlet.label.calendarSunday"/></th>
<th><fmt:message key="portlet.label.calendarMonday"/></th>
<th><fmt:message key="portlet.label.calendarTuesday"/></th>
<th><fmt:message key="portlet.label.calendarWednesday"/></th>
<th><fmt:message key="portlet.label.calendarThursday"/></th>
<th><fmt:message key="portlet.label.calendarFriday"/></th>
<th><fmt:message key="portlet.label.calendarSaturday"/></th>
</c:if>
<c:forEach var="calendar" items="${requestScope.lists}" varStatus="status">
<c:if test='${status.index % 7 == 0}'>
<tr>
</c:if>
<td class='portlet-table-td-left'>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;newDay=<c:out value="${calendar.time}"/>');" >
<c:if test='${calendar.desc != null}'>
<b>
</c:if>
<c:if test='${calendar.time != 0}'>
<c:out value="${calendar.time}"/>
</c:if>
<c:if test='${calendar.desc != null}'>
</b>
</c:if>
</a>
</span>
<c:if test='${calendar.holidays != null}'>
<c:forEach var="holiday" items="${calendar.holidays}">
<span class='portlet-item' 
   onmouseover="javascript:showDesc(event,'<c:out value="${holiday.desc}"/>','<c:out value="${requestScope.responseId}"/>');"
   onmouseout="javascript:hideDesc();">
<a href='<c:out value="${holiday.link}"/>' target="_blank">
<c:out value="${holiday.holidayName}"/>
</a>
</span>
<br/>
</c:forEach>
</c:if>
</td>
<c:if test='${status.index % 7 == 6}'>
</tr>
</c:if>
</c:forEach>
</table>
</form>
</fmt:bundle>
</body>
</html>