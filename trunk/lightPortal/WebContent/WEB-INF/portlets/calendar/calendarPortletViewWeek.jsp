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
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=3;previous=1');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' title='<fmt:message key="portlet.label.previous"/>' style='border: 0px' align='top'/></a>						
<c:out value="${requestScope.title}"/>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=3;next=1');"><img src='<%= request.getContextPath() %>/light/images/next.gif' title='<fmt:message key="portlet.label.next"/>' style='border: 0px' align='top'/></a>
</span>
</td>
</tr>
</table>
<table cellpadding='0' cellspacing='0' width= '95%' align='center' class='portlet-table'>
<tr class='portlet-table-td-left'>
<td></td>
<c:if test='${firstDay == 1}'>
<td>
<c:if test='${dayOfWeek == 2}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=2',false);" >
<fmt:message key="portlet.label.calendarMonday"/>
</a></span>
<c:if test='${dayOfWeek == 2}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 3}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=3',false);" >
<fmt:message key="portlet.label.calendarTuesday"/>
</a></span>
<c:if test='${dayOfWeek == 3}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 4}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=4',false);" >
<fmt:message key="portlet.label.calendarWednesday"/>
</a></span>
<c:if test='${dayOfWeek == 4}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 5}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=5',false);" >
<fmt:message key="portlet.label.calendarThursday"/>
</a></span>
<c:if test='${dayOfWeek == 5}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 6}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=6',false);" >
<fmt:message key="portlet.label.calendarFriday"/>
</a></span>
<c:if test='${dayOfWeek == 6}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 7}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=7',false);" >
<fmt:message key="portlet.label.calendarSaturday"/>
</a></span>
<c:if test='${dayOfWeek == 7}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 1}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=1',false);" >
<fmt:message key="portlet.label.calendarSunday"/>
</a></span>
<c:if test='${dayOfWeek == 1}'>
</b>
</c:if>
</td>
</c:if>
<c:if test='${firstDay != 1}'>
<td>
<c:if test='${dayOfWeek == 1}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=1',false);" >
<fmt:message key="portlet.label.calendarSunday"/>
</a></span>
<c:if test='${dayOfWeek == 1}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 2}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=2',false);" >
<fmt:message key="portlet.label.calendarMonday"/>
</a></span>
<c:if test='${dayOfWeek == 2}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 3}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=3',false);" >
<fmt:message key="portlet.label.calendarTuesday"/>
</a></span>
<c:if test='${dayOfWeek == 3}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 4}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=4',false);" >
<fmt:message key="portlet.label.calendarWednesday"/>
</a></span>
<c:if test='${dayOfWeek == 4}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 5}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=5',false);" >
<fmt:message key="portlet.label.calendarThursday"/>
</a></span>
<c:if test='${dayOfWeek == 5}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 6}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=6',false);" >
<fmt:message key="portlet.label.calendarFriday"/>
</a></span>
<c:if test='${dayOfWeek == 6}'>
</b>
</c:if>
</td>
<td>
<c:if test='${dayOfWeek == 7}'>
<b>
</c:if>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','type=1;weekDay=7',false);" >
<fmt:message key="portlet.label.calendarSaturday"/>
</a></span>
<c:if test='${dayOfWeek == 7}'>
</b>
</c:if>
</td>
</c:if>
</tr>
<c:forEach var="calendar" items="${requestScope.lists}" varStatus="status">
<tr valign='top'>
<td class='portlet-table-td-right'>
<c:out value="${calendar.desc}"/>
</td>
<td class='portlet-table-td-left' >
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=0;weekDay=1;startTime=<c:out value="${calendar.time}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/></a>
<br/>
</light:authenticateOwner>
<c:forEach var="event" items="${calendar.events1}" varStatus="status">
<c:if test='${event.state == 0}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateVisitor> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateVisitor>
<br/>
</c:if>
<c:if test='${event.state == 1}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateFriend> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateFriend>
<light:authenticateNotFriend> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateNotFriend>
<br/>
</c:if>
<c:if test='${event.state == 2}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
<c:if test='${event.state == 3}'>
<span class='portlet-item' 
   onmouseover="javascript:showDesc(event,'<c:out value="${event.desc}"/>','<c:out value="${requestScope.responseId}"/>');"
   onmouseout="javascript:hideDesc();">
<a href='<c:out value="${event.link}"/>' target="_blank"><c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
</c:forEach>
</td>
<td class='portlet-table-td-left' >
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=0;weekDay=2;startTime=<c:out value="${calendar.time}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/></a>
<br/>
</light:authenticateOwner>
<c:forEach var="event" items="${calendar.events2}" varStatus="status">
<c:if test='${event.state == 0}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateVisitor> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateVisitor>
<br/>
</c:if>
<c:if test='${event.state == 1}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateFriend> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateFriend>
<light:authenticateNotFriend> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateNotFriend>
<br/>
</c:if>
<c:if test='${event.state == 2}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
<c:if test='${event.state == 3}'>
<span class='portlet-item' 
   onmouseover="javascript:showDesc(event,'<c:out value="${event.desc}"/>','<c:out value="${requestScope.responseId}"/>');"
   onmouseout="javascript:hideDesc();">
<a href='<c:out value="${event.link}"/>' target="_blank"><c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
</c:forEach>
</td>
<td class='portlet-table-td-left' >
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=0;weekDay=3;startTime=<c:out value="${calendar.time}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/></a>
<br/>
</light:authenticateOwner>
<c:forEach var="event" items="${calendar.events3}" varStatus="status">
<c:if test='${event.state == 0}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateVisitor> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateVisitor>
<br/>
</c:if>
<c:if test='${event.state == 1}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateFriend> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateFriend>
<light:authenticateNotFriend> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateNotFriend>
<br/>
</c:if>
<c:if test='${event.state == 2}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
<c:if test='${event.state == 3}'>
<span class='portlet-item' 
   onmouseover="javascript:showDesc(event,'<c:out value="${event.desc}"/>','<c:out value="${requestScope.responseId}"/>');"
   onmouseout="javascript:hideDesc();">
<a href='<c:out value="${event.link}"/>' target="_blank"><c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
</c:forEach>
</td>
<td class='portlet-table-td-left' >
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=0;weekDay=4;startTime=<c:out value="${calendar.time}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/></a>
<br/>
</light:authenticateOwner>
<c:forEach var="event" items="${calendar.events4}" varStatus="status">
<c:if test='${event.state == 0}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateVisitor> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateVisitor>
<br/>
</c:if>
<c:if test='${event.state == 1}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateFriend> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateFriend>
<light:authenticateNotFriend> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateNotFriend>
<br/>
</c:if>
<c:if test='${event.state == 2}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
<c:if test='${event.state == 3}'>
<span class='portlet-item' 
   onmouseover="javascript:showDesc(event,'<c:out value="${event.desc}"/>','<c:out value="${requestScope.responseId}"/>');"
   onmouseout="javascript:hideDesc();">
<a href='<c:out value="${event.link}"/>' target="_blank"><c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
</c:forEach>
</td>
<td class='portlet-table-td-left' >
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=0;weekDay=5;startTime=<c:out value="${calendar.time}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/></a>
<br/>
</light:authenticateOwner>
<c:forEach var="event" items="${calendar.events5}" varStatus="status">
<c:if test='${event.state == 0}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateVisitor> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateVisitor>
<br/>
</c:if>
<c:if test='${event.state == 1}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateFriend> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateFriend>
<light:authenticateNotFriend> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateNotFriend>
<br/>
</c:if>
<c:if test='${event.state == 2}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
<c:if test='${event.state == 3}'>
<span class='portlet-item' 
   onmouseover="javascript:showDesc(event,'<c:out value="${event.desc}"/>','<c:out value="${requestScope.responseId}"/>');"
   onmouseout="javascript:hideDesc();">
<a href='<c:out value="${event.link}"/>' target="_blank"><c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
</c:forEach>
</td>
<td class='portlet-table-td-left' >
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=0;weekDay=6;startTime=<c:out value="${calendar.time}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/></a>
<br/>
</light:authenticateOwner>
<c:forEach var="event" items="${calendar.events6}" varStatus="status">
<c:if test='${event.state == 0}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateVisitor> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateVisitor>
<br/>
</c:if>
<c:if test='${event.state == 1}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11' align='middle' /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateFriend> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateFriend>
<light:authenticateNotFriend> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateNotFriend>
<br/>
</c:if>
<c:if test='${event.state == 2}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
<c:if test='${event.state == 3}'>
<span class='portlet-item' 
   onmouseover="javascript:showDesc(event,'<c:out value="${event.desc}"/>','<c:out value="${requestScope.responseId}"/>');"
   onmouseout="javascript:hideDesc();">
<a href='<c:out value="${event.link}"/>' target="_blank"><c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
</c:forEach>
</td>
<td class='portlet-table-td-left' >
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=0;weekDay=7;startTime=<c:out value="${calendar.time}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/></a>
<br/>
</light:authenticateOwner>
<c:forEach var="event" items="${calendar.events7}" varStatus="status">
<c:if test='${event.state == 0}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateVisitor> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateVisitor>
<br/>
</c:if>
<c:if test='${event.state == 1}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<light:authenticateOwner> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateOwner>
<light:authenticateFriend> 
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
</light:authenticateFriend>
<light:authenticateNotFriend> 
<fmt:message key="portlet.label.calendar.busy"/>
</light:authenticateNotFriend>
<br/>
</c:if>
<c:if test='${event.state == 2}'>
<light:authenticateOwner> 
<a href='javascript:void(0)' onclick="javascript:deleteCalendarEvent('<c:out value="${requestScope.responseId}"/>',<c:out value="${event.id}"/>,<c:out value="${event.parentId}"/>);"><image title='<fmt:message key="portlet.button.delete"/>' src="<%= request.getContextPath() %>/light/images/deleteLink.gif" style='border: 0px;' height='11' width='11'  /></a> 
</light:authenticateOwner>
<c:out value="${event.time}"/>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=3;eventId=<c:out value="${event.id}"/>');" >
<c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
<c:if test='${event.state == 3}'>
<span class='portlet-item' 
   onmouseover="javascript:showDesc(event,'<c:out value="${event.desc}"/>','<c:out value="${requestScope.responseId}"/>');"
   onmouseout="javascript:hideDesc();">
<a href='<c:out value="${event.link}"/>' target="_blank"><c:out value="${event.name}"/></a>
</span>
<br/>
</c:if>
</c:forEach>
</td>
</tr>
</c:forEach>
</table>
</form>
</fmt:bundle>
</body>
</html>