<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<light:authenticateOwner> 
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<input type='hidden' name ='pageId' value='<c:out value="${requestScope.pageId}"/>'/>
<table border='0' cellpadding='0' cellspacing='0' width="98%">
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-left' width='80'>
<fmt:message key="portlet.label.to"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='toEmail'  value='<c:out value="${requestScope.toEmail}"/>' class='portlet-form-input-field' size='30' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left' >
<fmt:message key="portlet.label.cc"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='cc'  value='<c:out value="${requestScope.cc}"/>' class='portlet-form-input-field' size='30' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left' >
<fmt:message key="portlet.label.bcc"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='bcc'  value='<c:out value="${requestScope.bcc}"/>' class='portlet-form-input-field' size='30' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='80'>
<fmt:message key="portlet.label.subject"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='subject'  value='<c:out value="${requestScope.subject}"/>' class='portlet-form-input-field' size='30' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.content"/>:
<input type='checkbox' name='htmlEditor' value='1' onchange="<portlet:actionURL portletMode='EDIT'/>" 
<c:if test='${showHtmlEditor != null}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.htmlEditor"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:if test='${showHtmlEditor == null}'>
<textarea name='content' class='portlet-form-textarea-field' rows='5' cols='40' >
<c:if test='${requestScope.content != null}'>
<c:out value="${content}" />
</c:if>
</textarea>
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
<input type='submit' name='action' onClick="document.pressed='send';document.resetLastAction='1'" value='<fmt:message key="portlet.button.send"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','pageId=<c:out value="${pageId}"/>');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</light:authenticateOwner>
</body>
</html>
