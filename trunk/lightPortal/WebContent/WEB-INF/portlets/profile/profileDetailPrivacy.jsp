<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="profileDetailHeader.jsp" ></jsp:include>
<br/>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL/>">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='notification' 
<c:if test='${requestScope.user.notification == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.notification"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='newsLetter' 
<c:if test='${requestScope.user.newsLetter == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.newsLetter"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='fqNel' 
<c:if test='${requestScope.user.fqNel == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.fqNel"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='commentNeedApprove' 
<c:if test='${requestScope.user.commentNeedApprove == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.commentNeedApprove"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='showTitleToFriends' 
<c:if test='${requestScope.user.showTitleToFriends == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.showTitleToFriends"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='showBirthToFriend' 
<c:if test='${requestScope.user.showBirthToFriend == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.showBirthToFriend"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='blogCommentFriendOnly' 
<c:if test='${requestScope.user.blogCommentFriendOnly == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.blogCommentFriendOnly"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='profileFriendViewOnly' 
<c:if test='${requestScope.user.profileFriendViewOnly == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.profileFriendViewOnly"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='noPicForward' 
<c:if test='${requestScope.user.noPicForward == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.noPicForward"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='myMusicAutoPlay' 
<c:if test='${requestScope.user.myMusicAutoPlay == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.myMusicAutoPlay"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='otherMusucAutoPlay' 
<c:if test='${requestScope.user.otherMusucAutoPlay == 1}'>
checked="yes" 
</c:if>
value='1'><fmt:message key="portlet.label.privacy.otherMusucAutoPlay"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<br/><fmt:message key="portlet.label.privacy.imprivacy"/>: <br/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<input type='radio' name='imprivacy' value='0'
<c:if test='${requestScope.user.imprivacy == 0}'>
checked="yes" 
</c:if>
/> <fmt:message key="portlet.label.privacy.imprivacy.public"/><br/>
<input type='radio' name='imprivacy' value='1'
<c:if test='${requestScope.user.imprivacy == 1}'>
checked="yes" 
</c:if>
/> <fmt:message key="portlet.label.privacy.imprivacy.friends"/><br/>
<input type='radio' name='imprivacy' value='2'
<c:if test='${requestScope.user.imprivacy == 2}'>
checked="yes" 
</c:if>
/> <fmt:message key="portlet.label.privacy.imprivacy.no"/><br/>
</td>
</tr>
</table>

<table border='0' cellpadding='0' cellspacing='0' width='80%'><br/>
<tr>
<td class='portlet-table-td-right'>
<input type='submit' name='action' onClick="document.pressed='privacy'" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>