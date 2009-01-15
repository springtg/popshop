<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='99%'>
<tr VALIGN='TOP'>
<td class='portlet-table-td-left' width='50%'>
<table>
<tr VALIGN='TOP'>
<td class='portlet-table-td-center'>
<c:if test='${requestScope.group.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;' width='75' height='75'/>
</c:if>
<c:if test='${requestScope.group.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${requestScope.group.photoUrl}"/>' style='border: 0px;'  width='<c:out value="${requestScope.group.photoSmallWidth}"/>' height='<c:out value="${requestScope.group.photoSmallHeight}"/>'/>
</c:if>
<c:if test='${requestScope.group.caption != null}'>
<br/>
<c:out value="${requestScope.group.caption}"/>
</c:if>
<br/><br/>
<span class="portlet-rss" > 
<a href='javascript:void(0)' onclick="javascript:viewGroupPictures(event,'<c:out value="${requestScope.group.id}"/>','<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.viewGroupPictures"/></a>
<br/>
<a href='javascript:void(0)' onclick="javascript:viewGroupMembers(event,'<c:out value="${requestScope.group.id}"/>','<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.viewGroupMembers"/></a>
</span>
</td>
<td class='portlet-table-td-left'>
<span class="portlet-rss" >   
<c:out value="${requestScope.group.displayName}"/>
<br/><br/> 
<fmt:message key="portlet.label.category"/>:
<b><a href='javascript:void(0)' onclick="javascript:viewGroupCategory(event,'<c:out value="${requestScope.group.categoryId}"/>','<c:out value="${requestScope.responseId}"/>');" >
<c:out value="${requestScope.group.categoryName}"/></a></b>
<br/><br/>
<fmt:message key="portlet.label.type"/>:
<c:if test='${requestScope.group.openJoin == 0}'>
<fmt:message key="portlet.label.privateMemberShip"/>
</c:if>
<c:if test='${requestScope.group.openJoin == 1}'>
<fmt:message key="portlet.label.publicMemberShip"/>
</c:if>
<br/>
<fmt:message key="portlet.label.founded"/>:<c:out value="${requestScope.group.date}"/>
<br/>
<fmt:message key="portlet.label.located"/>:<c:out value="${requestScope.group.city}"/>,<c:out value="${requestScope.group.province}"/> <c:out value="${requestScope.group.country}"/>
<br/>
<fmt:message key="portlet.label.groupMembers"/>:<c:out value="${requestScope.group.members}"/>
<br/>
</span>
</td>
</tr>
</table>
</td>

<td class='portlet-table-td-left' width='40%' >
<table>
<tr VALIGN='TOP'>
<td class='portlet-table-td-left'>
<light:authorizeGroupMember type='no'>
<input type="button"  value='<fmt:message key="portlet.button.join"/>' class='portlet-form-button' 
onclick="javascript:joinToGroup2(event,'<c:out value="${requestScope.responseId}"/>');"  />
<br/><br/>
</light:authorizeGroupMember>
<light:authorizeGroupMember type='yes'>
<c:if test='${requestScope.group.memberInvite == 1}'>
<input type="button"  value='<fmt:message key="portlet.button.inviteOthers"/>' class='portlet-form-button' 
onclick="javascript:inviteOthers(event,'<c:out value="${requestScope.group.id}"/>','<c:out value="${requestScope.responseId}"/>');"  />
<br/><br/>
</c:if>
<c:if test='${requestScope.group.memberInvite == 0}'>
<light:authorizeGroupMember type='leader'>
<input type="button"  value='<fmt:message key="portlet.button.inviteOthers"/>' class='portlet-form-button' 
onclick="javascript:inviteOthers(event,'<c:out value="${requestScope.group.id}"/>','<c:out value="${requestScope.responseId}"/>');"  />
<br/><br/>
</light:authorizeGroupMember>
</c:if>
<input type="button"  value='<fmt:message key="portlet.button.resign"/>' class='portlet-form-button' 
onclick="javascript:resign(event,'<c:out value="${requestScope.group.id}"/>','<c:out value="${requestScope.responseId}"/>');"  />
<br/><br/>
<c:if test='${requestScope.group.memberImage == 1}'> 
<input type="button"  value='<fmt:message key="portlet.button.uploadPictures"/>' class='portlet-form-button' 
onclick="javascript:uploadGroupPictures2(event,'<c:out value="${requestScope.group.id}"/>','<c:out value="${requestScope.responseId}"/>');"  />
<br/><br/>
</c:if>
<c:if test='${requestScope.group.memberImage == 0}'>
<light:authorizeGroupMember type='leader'>
<input type="button"  value='<fmt:message key="portlet.button.uploadPictures"/>' class='portlet-form-button' 
onclick="javascript:uploadGroupPictures2(event,'<c:out value="${requestScope.group.id}"/>','<c:out value="${requestScope.responseId}"/>');"  />
<br/><br/>
</light:authorizeGroupMember>
</c:if>
<input type="button"  value='<fmt:message key="portlet.button.privacy"/>' class='portlet-form-button' 
onclick="javascript:groupPrivacy(event,'<c:out value="${requestScope.group.id}"/>','<c:out value="${requestScope.responseId}"/>');"  />
<br/><br/>
</light:authorizeGroupMember>
<light:authorizeGroupMember type='leader'>
<input type="button"  value='<fmt:message key="portlet.button.editProfile"/>' class='portlet-form-button' 
onclick="javascript:editGroupProfile(event,'<c:out value="${requestScope.group.id}"/>','<c:out value="${requestScope.responseId}"/>');"  /> 
<br/><br/>
<input type="button"  value='<fmt:message key="portlet.button.deleteGroup"/>' class='portlet-form-button' 
onclick="javascript:deleteGroupProfile(event,'<c:out value="${requestScope.group.id}"/>''<c:out value="${requestScope.group.displayName}"/>',,'<c:out value="${requestScope.responseId}"/>');"  /> 
<br/><br/>
</light:authorizeGroupMember>
</td>
</tr>
</table>
</td>

<td class='portlet-table-td-right' width='10%' >
<table>
<tr VALIGN='TOP'>
<td class='portlet-table-td-center'>
<span class='portlet-item'>
<c:if test='${requestScope.user.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'   width='75' height='75'/>
</c:if>
<c:if test='${requestScope.user.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${requestScope.user.photoUrl}"/>' style='border: 0px;'   width='<c:out value="${requestScope.user.photoSmallWidth}"/>' height='<c:out value="${requestScope.user.photoSmallHeight}"/>'/>
</c:if>
<br/>
<fmt:message key="portlet.label.groupLeader"/>
<br/>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${requestScope.user.uri}"/>'><c:out value="${requestScope.user.name}"/></a><br/><br/>
<c:if test='${requestScope.chat.currentStatus == 1 }'>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px;' height='16' width='16'  align="bottom" alt=''/><br/><br/>
</c:if>
</span>
</td>
</tr>
</table>
</td>
</tr>
</table>
</fmt:bundle>
</body>
</html>