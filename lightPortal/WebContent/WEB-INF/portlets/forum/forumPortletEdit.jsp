<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if>
<input type='hidden' name='categoryId'  value='<c:out value="${categoryId}"/>' /> 
<input type='hidden' name='forumId'  value='<c:out value="${forumId}"/>' /> 
<tr>
<td class='portlet-table-td-left' colspan = '2' >
<c:out value="${categoryName}"/>-><c:out value="${forumName}"/>
<a href='http://www.<c:out value="${sessionScope.org.webId}"/>/rss/forum<c:out value="${forumId}"/>.xml'><img src='<%= request.getContextPath() %>/light/images/rss.gif' style='border: 0px' title='<fmt:message key="portlet.label.rssForum"/>'/></a>
</td>
</tr>
<c:if test='${requestScope.topicId == null}'>
<tr>
<td class='portlet-table-td-left' colspan = '2' >
<fmt:message key="portlet.label.topic"/>:
<input type='text' name='topic'  value='<c:out value='${requestScope.topic}'/>' class='portlet-form-input-field' size='50' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.content"/>:
<input type='checkbox' name='htmlEditor' value='1' onchange="javascript:Light.executeAction('<c:out value="${requestScope.responseId}"/>','','','','','edit','maximized','categoryId=<c:out value="${categoryId}"/>;forumId=<c:out value="${forumId}"/>');" 
<c:if test='${showHtmlEditor != null}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.htmlEditor"/></input>
</td>
</tr>
</c:if>
<c:if test='${requestScope.topicId != null}'>
<input type='hidden' name='topicId'  value='<c:out value="${requestScope.topicId}"/>' /> 
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.content"/>:
<input type='checkbox' name='htmlEditor' value='1' onchange="javascript:Light.executeAction('<c:out value="${requestScope.responseId}"/>','','','','','edit','maximized','categoryId=<c:out value="${categoryId}"/>;forumId=<c:out value="${forumId}"/>;topicId=<c:out value="${requestScope.topicId}"/>');" 
<c:if test='${showHtmlEditor != null}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.htmlEditor"/></input>
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:if test='${showHtmlEditor == null}'>
<textarea name='content' class='portlet-form-textarea-field' rows='5' cols='60' ><c:if test='${requestScope.content != null}'><c:out value='${requestScope.content}'/></c:if></textarea>
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
<c:if test='${requestScope.topicId == null}'>
<input type='submit' name='action' onClick="document.pressed='save';document.mode='view';document.resetLastAction='1';" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
</c:if>
<c:if test='${requestScope.topicId != null}'>
<input type='submit' name='action' onClick="document.pressed='reply';document.mode='view';document.resetLastAction='1';" value='<fmt:message key="portlet.button.reply"/>' class='portlet-form-button' />
</c:if>
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','categoryId=<c:out value="${categoryId}"/>;forumId=<c:out value="${forumId}"/>');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
