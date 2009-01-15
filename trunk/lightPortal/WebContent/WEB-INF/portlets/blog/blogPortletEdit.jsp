<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-left' colspan = '2'>
<br/>
<fmt:message key="portlet.label.title"/>:
<c:if test='${requestScope.blog != null}'>
<input type='hidden' name='blogId' value='<c:out value="${blog.id}"/>' />
<input type='text' name='subject'  value='<c:out value="${blog.title}"/>' class='portlet-form-input-field' size='50' /> 
</c:if>
<c:if test='${requestScope.blog == null}'>
<input type='hidden' name='blogId' value='<c:out value="${blogId}"/>' />
<input type='text' name='subject'  value='<c:out value="${subject}"/>' class='portlet-form-input-field' size='50' /> 
</c:if>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.summary"/>:
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<textarea name='summary' class='portlet-form-textarea-field' rows='5' cols='50' ><c:if test='${requestScope.blog != null}'><c:out value="${blog.summary}"/></c:if><c:if test='${requestScope.blog == null}'><c:out value="${summary}" /></c:if></textarea>
</td>
</tr>

<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.content"/>:
<input type='checkbox' name='htmlEditor' value='1' onchange="<portlet:actionURL windowState='maximized' portletMode='EDIT'><portlet:param name='add' value='add'/></portlet:actionURL>" 
<c:if test='${showHtmlEditor != null}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.htmlEditor"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:if test='${showHtmlEditor == null}'>
<textarea name='content' class='portlet-form-textarea-field' rows='5' cols='40' ><c:if test='${requestScope.blog != null}'><c:out value="${blog.content}" escapeXml="false" /></c:if><c:if test='${requestScope.blog == null}'><c:out value="${content}" escapeXml="false" /></c:if></textarea>
</c:if>
<c:if test='${showHtmlEditor != null}'>
<FCK:editor id="content" width='95%' height="300" basePath="FCKeditor/"   
		    fontNames=";Arial;Courier New;Times New Roman;Verdana;Helv;Helvetica;sans-serif" >
<c:if test='${requestScope.blog != null}'>
<c:out value="${blog.content}" escapeXml="false" />
</c:if>
<c:if test='${requestScope.blog == null}'>
<c:out value="${content}" escapeXml="false" />
</c:if>
</FCK:editor>
</c:if>
</td>
</tr>

<tr>
<td class='portlet-table-td-right' colspan='2' >
<input type='submit' name='action' onClick="document.pressed='draft';document.resetLastAction='1';" value='<fmt:message key="portlet.button.draft"/>' class='portlet-form-button' />
<input type='submit' name='action' onClick="document.pressed='save';document.resetLastAction='1';" value='<fmt:message key="portlet.button.publish"/>' class='portlet-form-button' />
<input type='submit' name='action' onClick="document.pressed='preview'" value='<fmt:message key="portlet.button.preview"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
