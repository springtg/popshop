<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
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
<c:if test='${requestScope.picture != null}'>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-center'>
<a href='<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' target="_blank"><img src='<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${picture.smallWidth}"/>' height='<c:out value="${picture.smallHeight}"/>'/></a>
<br/><c:out value="${picture.caption}"/>
<br/><br/><br/>
</td>
</tr>
<tr>
<td class='portlet-table-td-center'>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-right'>
<input type='hidden' name='pictureId' value='<c:out value="${picture.id}"/>'/>
<fmt:message key="portlet.label.caption"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='caption' value='<c:out value="${picture.caption}"/>' class='portlet-form-input-field' size='36' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'>
<fmt:message key="portlet.label.tag"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='tag' value='<c:out value="${picture.tag}"/>' class='portlet-form-input-field' size='36' /> 
</td>
</tr>
<tr valign='top'>
<td class='portlet-table-td-right'>
<fmt:message key="portlet.label.privacy.pic"/>:
</td>
<td class='portlet-table-td-left'>
<input type='radio' name='status' value='0' class='portlet-form-radio'
<c:if test='${picture.status == 0}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.privacy.pic.me"/></input><br/>
<input type='radio' name='status' value='1' class='portlet-form-radio'
<c:if test='${picture.status == 1}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.privacy.pic.friends"/></input><br/>
<input type='radio' name='status' value='2' class='portlet-form-radio'
<c:if test='${picture.status == 2}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.privacy.pic.public"/></input><br/> 
</td>
</tr>
<tr >
<td class='portlet-table-td-right'></td>
<td class='portlet-table-td-left'>
<input type='checkbox' name='rankable' value='<c:out value="${picture.rankable}"/>' class='portlet-form-checkbox'
<c:if test='${picture.rankable == 1}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.rank.picture"/></input> 
</td>
</tr>
</table>
</td>
</tr>
<tr>
<td class='portlet-table-td-center'>
<input type='submit' onClick="document.pressed='save';" value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.backToView('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</c:if>
</light:authenticateUser>
</fmt:bundle>
</body>
</html>