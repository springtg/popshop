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
<fmt:message key="portlet.message.categoryAd"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'  width='100'>
<fmt:message key="portlet.label.country"/>:
</td>
<td class='portlet-table-td-left'  width='100'>
<select name='country' size='1' class='portlet-form-select'>
<c:forEach var="cun" items="${requestScope.countries}" >
<option value='<c:out value="${cun.desc}"/>'
<c:if test='${country == cun.id}'>
selected="selected"
</c:if>
 ><c:out value="${cun.desc}"/></option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'  width='100'>
<fmt:message key="portlet.label.province"/>:
</td>
<td class='portlet-table-td-left'  width='100'>
<input type='text' name='province'  value='<c:out value="${province}" />' class='portlet-form-input-field' size='40' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'  width='100'>
<fmt:message key="portlet.label.city"/>:
</td>
<td class='portlet-table-td-left'  width='100'>
<input type='text' name='city'  value='<c:out value="${city}" />' class='portlet-form-input-field' size='40' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'  width='100'>
<fmt:message key="portlet.label.adUrl"/>:
</td>
<td class='portlet-table-td-left'  width='100'>
<input type='text' name='adUrl'  value='<c:out value="${adUrl}" />' class='portlet-form-input-field' size='40' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'  width='100'>
<fmt:message key="portlet.label.effDate"/>:
</td>
<td class='portlet-table-td-left'  width='100'>
<input type='text' name='effDate'  value='<c:out value="${effDate}" />' class='portlet-form-input-field' size='40' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'  width='100'>
<fmt:message key="portlet.label.endEffDate"/>:
</td>
<td class='portlet-table-td-left'  width='100'>
<input type='text' name='endEffDate'  value='<c:out value="${endEffDate}" />' class='portlet-form-input-field' size='40' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'  width='100'>
<fmt:message key="portlet.label.title"/>:
</td>
<td class='portlet-table-td-left'  width='100'>
<input type='text' name='title'  value='<c:out value="${title}" />' class='portlet-form-input-field' size='40' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'  width='100'>
<fmt:message key="portlet.label.content"/>:
</td>
<td class='portlet-table-td-left'  width='100'>
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
<input type='submit' name='action' onClick="document.pressed='save'" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
