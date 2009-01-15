<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left'>
<light:authenticateOwner>
<textarea name='content'
 style='border-width:0px;width:100%;overflow:visible;background-color: transparent; color:<c:out value="${requestScope.note.color}"/>;'
 rows='<c:out value="${requestScope.note.height}"/>' cols='<c:out value="${requestScope.note.width}"/>'
 onChange="javascript:saveNote('<c:out value="${requestScope.responseId}"/>')"
 onkeyup="javascript:changeNoteRow(event,'<c:out value="${requestScope.responseId}"/>')"><c:out value="${requestScope.note.displayContent}"/></textarea>
</light:authenticateOwner>
<light:authenticateVisitor>
<textarea name='content'
 style='border-width:0px;width:100%;overflow:visible;background-color: transparent; color:<c:out value="${requestScope.note.color}"/>;'
 rows='<c:out value="${requestScope.note.height}"/>' cols='<c:out value="${requestScope.note.width}"/>'
 readonly="true"><c:out value="${requestScope.note.displayContent}"/></textarea>
</light:authenticateVisitor>
<br/>
</td>
</table>
</form>
</body>
</html>