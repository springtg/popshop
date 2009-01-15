<%@ include file="/common/taglibs.jsp"%>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<!-- 
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-table-td-right'>  
<c:if test='${requestScope.userProfile.firstName != null }'>
<c:out value="${requestScope.userProfile.firstName}"/>
</c:if>
<c:if test='${requestScope.userProfile.firstName == null }'>
<c:out value="${requestScope.user.name}"/>
</c:if>
<br/>
<c:if test='${requestScope.userProfile.occupation != null }'>
<b><c:out value="${requestScope.userProfile.occupation}"/></b><br/><br/>
</c:if>
</td>
</tr>
</table>
 -->
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr valign="top">
<td class='portlet-table-td-center' width='60%' style="padding-top:10px">
<c:if test='${requestScope.user.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${requestScope.user.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${requestScope.user.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${requestScope.user.photoSmallWidth}"/>' height='<c:out value="${requestScope.user.photoSmallHeight}"/>'/>
</c:if>
<c:if test='${requestScope.user.caption != null}'>
<br/>
<c:out value="${requestScope.user.caption}"/>
</c:if>
<br/>
<light:authenticateUser> 
<span class="portlet-rss" style="text-align:center;">   
<a href='javascript:void(0)' onclick="javascript:editProfilePhoto(event,'<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.editPhoto"/></a>
</span>
</light:authenticateUser>
</td>

<td class='portlet-table-td-center' width='40%' style="padding-top:10px">
<span class="portlet-rss" > 
<c:if test='${requestScope.userProfile.firstName != null }'>
<c:out value="${requestScope.userProfile.firstName}"/>
</c:if>
<c:if test='${requestScope.userProfile.firstName == null }'>
<c:out value="${requestScope.user.name}"/>
</c:if>
<br/>
<c:if test='${requestScope.userProfile.occupation != null }'>
<b><c:out value="${requestScope.userProfile.occupation}"/></b><br/>
</c:if>  
<c:if test='${requestScope.chat.currentStatus == 1 && sessionScope.visitedUser != null }'>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px;' height='16' width='16'  align="bottom" alt=''/><br/>
</c:if>
<c:out value="${requestScope.user.genderName}"/><br/>
<light:authenticateFriend>
<c:if test='${requestScope.user.age !="unknow" }'>
<c:out value="${requestScope.user.age}"/> <fmt:message key="portlet.label.age"/> <br/>
</c:if>
<c:if test='${requestScope.user.showBirthToFriend == 1}'>
<fmt:message key="portlet.label.birthday"/> :<c:out value="${requestScope.user.birthday}"/> 
</c:if>
</light:authenticateFriend>
<c:if test='${requestScope.user.city != null}'>
<c:out value="${requestScope.user.city}"/>, <c:out value="${requestScope.user.province}"/><br/>
</c:if>
<c:if test='${requestScope.user.country != null}'>
<c:out value="${requestScope.user.country}"/><br/><br/>
</c:if>
<!-- 
<light:authenticateUser>
<a href='javascript:void(0)' onclick="javascript:Light.portal.editProfile();" ><fmt:message key="portlet.label.myProfile"/></a>
</light:authenticateUser>
<br/>
<a href='javascript:void(0)' onclick="javascript:showMyPicture();" ><fmt:message key="portlet.label.myPictures"/></a>
<br/>
<a href='javascript:void(0)' onclick="javascript:showMyMusic();" ><fmt:message key="portlet.label.myMusics"/></a>
<a href='javascript:void(0)' onClick="javascript:playMusic('<c:out value="${user.musicUrl}"/>');" ><img src="<%= request.getContextPath() %>/light/images/play.gif" title='<fmt:message key="portlet.button.playBg"/>' align='middle' style='border: 0px;' height='16' width='16'/></a>
<a href='javascript:void(0)' onClick="javascript:stopMusic();" ><img src="<%= request.getContextPath() %>/light/images/stop.gif" title='<fmt:message key="portlet.button.stopBg"/>' align='middle' style='border: 0px;' height='11' width='11'/></a>
<br/>
<a href='javascript:void(0)' onclick="javascript:showMyFile();" ><fmt:message key="portlet.title.myFile"/></a>
<br/>
<a href='javascript:void(0)' onclick="javascript:showMyBlog();" ><fmt:message key="portlet.title.myBlog"/></a>
<br/>
<a href='javascript:void(0)' onclick="javascript:showMyFavorites();" ><fmt:message key="portlet.title.favourite"/></a>
<br/>
<a href='javascript:void(0)' onclick="javascript:showMyViewed();" ><fmt:message key="portlet.title.myViewedItem"/></a>
<br/>
<a href='javascript:void(0)' onclick="javascript:showMyRecommended();" ><fmt:message key="portlet.title.recommendedItem"/></a>
 -->
 </span>
</td>
</tr>
</table>
<br/>

<table border='0' cellpadding='0' cellspacing='0'>
<light:authenticateUser> 
<tr>
<td class='portlet-table-td-left'>
<b><fmt:message key="portlet.label.myUrl"/></b>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<span class="portlet-rss" > 
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${requestScope.user.uri}"/>'>http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${requestScope.user.uri}"/></a>
</span>
</td>
<c:if test='${requestScope.user.chosedUri == null}'>
<td class='portlet-table-td-left'>
<span class="portlet-rss" > 
<a href='javascript:void(0)' onclick="javascript:editMyUrl(event,'<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.edit"/></a>
</span>
</td>
</c:if>
</tr>
</light:authenticateUser>
<!-- 
<tr>
<td class='portlet-table-td-left'>
<b><fmt:message key="portlet.label.myBlogUrl"/></b>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<span class="portlet-rss" > 
<a href='http://blog.<c:out value="${sessionScope.org.webId}"/>/<c:out value="${requestScope.user.uri}"/>' target="_blank">http://blog.<c:out value="${sessionScope.org.webId}"/>/<c:out value="${requestScope.user.uri}"/></a>
</span>
</td>
<c:if test='${requestScope.user.chosedUri == null}'>
<td class='portlet-table-td-left'>
<span class="portlet-rss" > 
<a href='javascript:void(0)' onclick="javascript:editMyUrl(event,'<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.edit"/></a>
</span>
</td>
</c:if>
</tr>
 -->
<light:authenticateUser> 
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.ProfileViews"/>: <c:out value="${requestScope.user.visitCount}"/>
</td>
</tr>
</light:authenticateUser>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.lastLoginDate"/>: <c:out value="${requestScope.user.lastDate}"/>
</td>
</tr>
</table>
</form>
</fmt:bundle>