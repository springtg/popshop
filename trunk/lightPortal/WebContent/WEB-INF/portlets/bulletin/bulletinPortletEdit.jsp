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
<td class='portlet-table-td-left' colspan = '2'>
<fmt:message key="portlet.label.bulletinTo"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'  colspan='2'>
<fmt:message key="portlet.label.subject"/>:
<input type='text' name='subject'  value='<c:out value="${subject}" />' class='portlet-form-input-field' size='40' /> 
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
<textarea name='content' class='portlet-form-textarea-field' rows='5' cols='50' ><c:if test='${requestScope.content != null}'><c:out value="${content}" /></c:if></textarea>
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
<td class='portlet-table-td-right' colspan='2'>
<input type='submit' name='action' onClick="document.pressed='save';document.resetLastAction='1';" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
