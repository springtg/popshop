<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-center' width='50%'>
<c:if test='${requestScope.userProfile.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${requestScope.userProfile.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${requestScope.userProfile.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${requestScope.userProfile.photoSmallWidth}"/>' height='<c:out value="${requestScope.userProfile.photoSmallHeight}"/>'/>
</c:if>
<br/>
<light:authenticateUser> 
<span class="portlet-rss" style="text-align:center;">   
<a href='javascript:void(0)' onclick="javascript:editProfilePhoto(event,'<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.editPhoto"/></a>
</span>
</light:authenticateUser>
</td>

<td class='portlet-table-td-center' width='50%'>
<span class="portlet-rss" >   
<c:out value="${requestScope.userProfile.name}"/><br/><br/>
<c:if test='${requestScope.chat.currentStatus == 1 && sessionScope.visitedUser != null }'>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px;' height='16' width='16'  align="bottom" alt=''/><br/><br/>
</c:if>
<c:out value="${requestScope.userProfile.genderName}"/><br/><br/>
<c:out value="${requestScope.userProfile.age}"/> <fmt:message key="portlet.label.age"/> <br/><br/>
<c:out value="${requestScope.userProfile.country}"/><br/><br/>
<a href='javascript:void(0)' onclick="javascript:Light.portal.editProfile();" ><fmt:message key="portlet.label.editProfile"/></a>
</span>
</td>
</tr>
</table>
<br/>

<light:authenticateUser> 
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left'>
<b><fmt:message key="portlet.label.myUrl"/></b>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<span class="portlet-rss" > 
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${requestScope.userProfile.uri}"/>'>http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${requestScope.userProfile.uri}"/></a>
</span>
</td>
<c:if test='${requestScope.userProfile.chosedUri == null}'>
<td class='portlet-table-td-left'>
<span class="portlet-rss" > 
<a href='javascript:void(0)' onclick="javascript:editMyUrl(event,'<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.edit"/></a>
</span>
</td>
</c:if>
</tr>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.lastLoginDate"/>: <c:out value="${requestScope.userProfile.lastDate}"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.ProfileViews"/>: <c:out value="${requestScope.userProfile.visitCount}"/>
</td>
</tr>
</table>
</light:authenticateUser>
</fmt:bundle>
</body>
</html>