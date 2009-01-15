<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL />">

<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left'>
<input type='hidden' name='chattingId' value='<c:out value="${requestScope.chattingId}"/>'/>
<input type='hidden' name='displayName' value='<c:out value="${requestScope.displayName}"/>'/>
<input type='text' name='chat' class='portlet-form-input-field' size='80'
    onkeypress="document.currentForm=this.form; document.pressed='send'; return keyDownChat(event);" />
<input type='submit' name='action' onClick="document.currentForm=this.form;document.pressed='send'" value='<fmt:message key="portlet.button.send"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>