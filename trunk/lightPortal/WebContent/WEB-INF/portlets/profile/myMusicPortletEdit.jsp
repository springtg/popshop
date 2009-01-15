<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<c:if test='${requestScope.music == null}'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>         
</c:if>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<c:if test='${requestScope.success != null}'>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-success' >
<c:out value="${requestScope.success}"/>
</td>
</tr>
</table>
</c:if>
<c:if test='${requestScope.error != null}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</table>
</c:if>
<light:authenticateUser> 
<c:if test='${requestScope.music != null}'>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-right' width='15%'>
URL:
</td>
<td class='portlet-table-td-left'>
<a href='<%= request.getContextPath() %><c:out value="${music.musicUrl}"/>' target="_blank">
<c:out value="${music.musicUrl}"/>
<c:out value="${music.caption}"/>
</a>
</td>
</tr>
<tr>
<td class='portlet-table-td-right' width='15%'>
<fmt:message key="portlet.label.caption"/>:
</td>
<td class='portlet-table-td-left'>
<input type='hidden' name='musicId' value='<c:out value="${music.id}"/>'/>
<input type='text' name='caption' value='<c:out value="${music.caption}"/>' class='portlet-form-input-field' size='18' /> 
</td>
</tr>
<tr valign='top'>
<td class='portlet-table-td-right' width='15%'>
<fmt:message key="portlet.label.privacy.pic"/>:
</td>
<td class='portlet-table-td-left'>
<input type='radio' name='status' value='0' class='portlet-form-radio'
<c:if test='${music.status == 0}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.privacy.pic.me"/></input><br/>
<input type='radio' name='status' value='1' class='portlet-form-radio'
<c:if test='${music.status == 1}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.privacy.pic.friends"/></input><br/>
<input type='radio' name='status' value='2' class='portlet-form-radio'
<c:if test='${music.status == 2}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.privacy.pic.public"/></input><br/> 
</td>
</tr>
<tr >
<td class='portlet-table-td-right'></td>
<td class='portlet-table-td-left'>
<input type='checkbox' name='rankable' value='<c:out value="${music.rankable}"/>' class='portlet-form-checkbox'
<c:if test='${music.rankable == 1}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.rank.music"/></input> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right' width='15%'>
</td>
<td class='portlet-table-td-left'>
<input type='submit' onClick="document.pressed='save';" value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
<input type='submit' onClick="document.pressed='cancel';" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</c:if>
</light:authenticateUser>
</fmt:bundle>
</body>
</html>