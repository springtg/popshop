<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width="98%">
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-left' >
<fmt:message key="portlet.label.to"/>:
</td>
<td class='portlet-table-td-left'>
<c:if test='${requestScope.toUser != null}'>
<input type='text' name='toName'  value='<c:out value="${requestScope.toUserName}"/>' class='portlet-form-input-field' size='50' readonly='true' /> 
<input type='hidden' name='to'  value='<c:out value="${requestScope.toUser}"/>' /> 
<input type='hidden' name='toUserName'  value='<c:out value="${requestScope.toUserName}"/>' /> 
</c:if>
<c:if test='${requestScope.toUser == null}'>
<select name='to' size='1' class='portlet-form-select'>
<c:forEach var="buddy" items="${requestScope.buddys}" >
<option value='<c:out value="${buddy.buddyUserId}"/>'><c:out value="${buddy.displayName}"/></option>
</c:forEach>
</select>
</c:if>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.subject"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='subject'  value='<c:out value="${requestScope.subject}"/>' class='portlet-form-input-field' size='50' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.content"/>:
<input type='checkbox' name='htmlEditor' value='1' onchange="<portlet:actionURL windowState='maximized' portletMode='EDIT'/>" 
<c:if test='${showHtmlEditor != null}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.htmlEditor"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:if test='${showHtmlEditor == null}'>
<textarea name='content' class='portlet-form-textarea-field' rows='10' cols='50' ><c:if test='${requestScope.content != null}'><c:out value="${content}" /></c:if></textarea>
</c:if>
<c:if test='${showHtmlEditor != null}'>
<FCK:editor id="content" width='95%' height="300" basePath="FCKeditor/"   
		    fontNames=";Arial;Courier New;Times New Roman;Verdana;Helv;Helvetica;sans-serif" >
<c:if test='${requestScope.content != null}'>
<c:out value="${content}" escapeXml="false" />
</c:if>
</FCK:editor>
</c:if>
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2' >
<input type='submit' name='action' onClick="document.pressed='save'" value='<fmt:message key="portlet.button.send"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
