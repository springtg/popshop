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
<td class='portlet-table-td-left'><fmt:message key="portlet.label.headline"/>: 
<input type='text' name='headline' value='<c:out value="${requestScope.userProfile.headline}"/>' class='portlet-form-input-field' size='64' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.aboutMe"/>: 
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<textarea name='aboutMe' class='portlet-form-textarea-field' rows='5' cols='80' ><c:out value="${requestScope.userProfile.aboutMe}"/></textarea>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.likeToMeet"/>: </td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<textarea name='likeToMeet' class='portlet-form-textarea-field' rows='5' cols='80' ><c:out value="${requestScope.userProfile.likeToMeet}"/></textarea>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.interests"/>: </td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<textarea name='interests' class='portlet-form-textarea-field' rows='5' cols='80' ><c:out value="${requestScope.userProfile.interests}"/></textarea>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.music"/>: </td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<textarea name='music' class='portlet-form-textarea-field' rows='5' cols='80' ><c:out value="${requestScope.userProfile.music}"/></textarea>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.movies"/>: </td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<textarea name='movies' class='portlet-form-textarea-field' rows='5' cols='80' ><c:out value="${requestScope.userProfile.movies}"/></textarea>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.television"/>: </td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<textarea name='television' class='portlet-form-textarea-field' rows='5' cols='80' ><c:out value="${requestScope.userProfile.television}"/></textarea>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.books"/>: </td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<textarea name='books' class='portlet-form-textarea-field' rows='5' cols='80' ><c:out value="${requestScope.userProfile.books}"/></textarea>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.heroes"/>: </td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<textarea name='heroes' class='portlet-form-textarea-field' rows='5' cols='80' ><c:out value="${requestScope.userProfile.heroes}"/></textarea>
</td>
</tr>
</table>

<table border='0' cellpadding='0' cellspacing='0' width='80%'>
<tr>
<td class='portlet-table-td-right'>
<input type='submit' name='action' onClick="document.pressed='interests'" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>