<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<light:authenticateUser> 
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'><portlet:param name='add' value='add'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.addBuddy"/></a>
</td>
<c:if test='${currentDesc != null}'>
<td class='portlet-table-td-right' >
<span class='portlet-rss' >
<a href='javascript:void(0)' onclick="javascript:Light.executeProcess('<c:out value="${requestScope.responseId}"/>','','','action=back');" ><c:out value="${currentDesc}"/><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' height='16' width='16' align="top" title='<fmt:message key="portlet.button.back"/>'/></a>
</span>
</td>
</c:if>
</tr>
</table>
</light:authenticateUser>
<c:if test='${buddyLocations != null}'>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<c:forEach var="buddyLocation" items="${requestScope.buddyLocations}" varStatus="status">
<tr valign='top'>
<td class='portlet-table-td-left' width= '100%'>
<span class="portlet-rss">
<a href='javascript:void(0);' onclick="javascript:Light.executeProcess('<c:out value="${requestScope.responseId}"/>','','','action=location;location=<c:out value="${buddyLocation.id}"/>');">
<c:out value="${buddyLocation.id}"/> (<c:out value="${buddyLocation.desc}"/>)
</a>
</span>
</td>
</tr>
</c:forEach>
</table>
</c:if>

<c:if test='${buddyTypes != null}'>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<c:forEach var="buddyType" items="${requestScope.buddyTypes}" varStatus="status">
<tr valign='top'>
<td class='portlet-table-td-left' width= '100%'>
<span class="portlet-rss">
<a href='javascript:void(0);' onclick="javascript:Light.executeProcess('<c:out value="${requestScope.responseId}"/>','','','action=type;friendType=<c:out value="${buddyType.type}"/>');">
<c:out value="${buddyType.title}"/> (<c:out value="${buddyType.count}"/>)
</a>
</span>
</td>
</tr>
</c:forEach>
</table>
</c:if>
<c:if test='${buddyTypes == null && buddyLocations == null}'>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-left' >
<fmt:message key="portlet.label.youHave"/> <c:out value="${requestScope.buddyCount}"/> <fmt:message key="portlet.label.friends"/>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
<c:forEach var="buddy" items="${requestScope.buddys}" varStatus="status">
<tr valign='top'>
<td class='portlet-table-td-left' width= '220'>
<c:if test='${buddy.photoUrl == null}'>
<a href="javascript:void(0);" onclick="javascript:showBuddyDetail(event,'<c:out value="${buddy.buddyUserId}"/>','<c:out value="${requestScope.responseId}"/>');">
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</a>
</c:if>
<c:if test='${buddy.photoUrl != null}'>
<a href="javascript:void(0);" onclick="javascript:showBuddyDetail(event,'<c:out value="${buddy.buddyUserId}"/>','<c:out value="${requestScope.responseId}"/>');">
 <img src='<%= request.getContextPath() %><c:out value="${buddy.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${buddy.photoSmallWidth }"/>' height='<c:out value="${buddy.photoSmallHeight }"/>'/>
</a>
</c:if>
</td>
<td class='portlet-table-td-left' >
<span class='portlet-item'>
<c:if test='${buddy.buddyCurrentStatusId == 1}'>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px' width='15' height='12' align="bottom" alt=''/>
</c:if>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.uri}"/>' ><c:out value="${buddy.displayName}"/></a>
<c:if test='${buddy.showTitleToFriends != 0}'>
-<c:out value="${buddy.title}"/>
</c:if>
</span>
</td>
</tr>
</c:forEach>
</table>
</c:if>
</fmt:bundle>
</body>
</html>