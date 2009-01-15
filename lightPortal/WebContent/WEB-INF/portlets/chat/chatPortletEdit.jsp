<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='EDIT'/>">
<table border='0' cellpadding='0' cellspacing='0'>
<c:if test='${requestScope.missingField}'>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.message.missing.buddyemail"/>:
</td>
</tr>
</c:if>
<c:if test='${requestScope.addBuddy}'>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.message.success.addBuddy"/>:
</td>
</tr>
</c:if>
<c:if test='${requestScope.notFoundBuddy}'>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.message.fail.addBuddy"/>:
</td>
</tr>
</c:if>
<c:if test='${requestScope.existBuddy}'>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.message.fail.existBuddy"/>:
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-right'>
<fmt:message key="portlet.label.buddyEmail"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='buddyEmail' class='portlet-form-input-field'
size='24' value=''/>
</td>
</tr>
<br/>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.message.friend.findByName"/>:
</td>
</tr>
<tr>
<td class='portlet-table-td-right'>
<fmt:message key="portlet.label.firstName"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='firstName' class='portlet-form-input-field'
size='24' value=''/>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'>
<fmt:message key="portlet.label.lastName"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='lastName' class='portlet-form-input-field'
size='24' value=''/>
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan ='2'>
<input type='submit' name='action' onClick="document.pressed='search'"
value='<fmt:message key="portlet.button.search"/>'
class='portlet-form-button' />
<input type='button' name='action' onClick="<portlet:renderURL  portletMode='VIEW'/>"
value='<fmt:message key="portlet.button.cancel"/>'
class='portlet-form-button' />
</td>
</tr>
</table>

<c:if test='${requestScope.buddyCount != null}'>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<c:out value="${requestScope.buddyCount}"/> <fmt:message key="portlet.message.searchResult"/>
</td>
</tr>
</table>
</c:if>

<table border='0' cellpadding='0' cellspacing='0' width= '220' >
<c:forEach var="buddy" items="${requestScope.buddys}" >
<tr>
<td class='portlet-table-td-center'>
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.uri}"/>' ><c:out value="${buddy.displayName}"/></a>
</span>
<br/>
<c:if test='${buddy.photoUrl == null}'>
<a href="javascript:void(0);" onclick="javascript:showBuddyDetail(event,'<c:out value="${buddy.id}"/>','<c:out value="${requestScope.responseId}"/>');">
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>'
style='border: 0px;' align="middle" width='75' height='75'/>
</a>
</c:if>
<c:if test='${buddy.photoUrl != null}'>
<a href="javascript:void(0);" onclick="javascript:showBuddyDetail(event,'<c:out value="${buddy.id}"/>','<c:out value="${requestScope.responseId}"/>');">
<img src='<%= request.getContextPath() %><c:out
value="${buddy.photoUrl}"/>' style='border: 0px;' align="middle"
width='<c:out value="${buddy.photoSmallWidth}"/>' height='<c:out
value="${buddy.photoSmallHeight}"/>'/>
</a>
</c:if>
<br/>
<c:if test='${buddy.userCurrentStatusId == 1}'>
<img src="<%= request.getContextPath() %>/light/images/online.gif"
style='border: 0px' align="bottom" alt=''/>
</c:if>
</td>
</tr>
</c:forEach>

</table>
</form>
</fmt:bundle>
</body>
</html>