<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<table border="0" cellpadding="0" cellspacing="0">
<tr>
<td class="portlet-msg-info" style="padding-top:20px">
<B>Please fill in the following information, your feedback is valuable
for us.</B>
</td>
</tr>
</table>
<br/>

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
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</table>
</c:if>
<br/>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0'  width="98%">
<tr>
<td class='portlet-table-td-left' width="60">
*<fmt:message key="portlet.label.subject"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='subject'  value='<c:out value="${subject}" />'
class='portlet-form-input-field' size='48' />
</td>
</tr>
<c:if test='${sessionScope.user == null}'>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.email"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='email'  value='<c:out value="${email}" />'
class='portlet-form-input-field' size='48' />
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-left'>
*<fmt:message key="portlet.label.content"/>:
</td>
<td class='portlet-table-td-left'>
<input type='checkbox' name='htmlEditor' value='1'
onchange="<portlet:actionURL windowState='maximized'/>"
<c:if test='${showHtmlEditor != null}'>
checked="checked"
</c:if>
 ><fmt:message key="portlet.label.htmlEditor"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:if test='${showHtmlEditor == null}'>
<textarea name='content' class='portlet-form-textarea-field' rows='5' cols='52' ><c:if test='${requestScope.content != null}'><c:out value="${content}" /></c:if></textarea>
</c:if>
<c:if test='${showHtmlEditor != null}'>
<FCK:editor id="content" width='98%' height="300"
basePath="FCKeditor/"
           fontNames=";Arial;Courier New;Times New
Roman;Verdana;Helv;Helvetica;sans-serif" >
<c:if test='${requestScope.content != null}'>
<c:out value="${content}" escapeXml="false" />
</c:if>
</FCK:editor>
</c:if>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'/>
<td class='portlet-table-td-left' style="padding-top:10px">
<input type='submit' name='action' onClick="document.pressed='save'" value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.closePortlet('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.close"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>