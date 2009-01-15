<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>" action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width="95%">
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.notKeyword"/>(<c:out value="${notKeywordsTotal}"/>):
<br/><br/>
<select name='keywords' MULTIPLE='MULTIPLE' size='10' class='portlet-form-select' STYLE="width: 180px">
<c:forEach var="keyword" items="${requestScope.notKeywords}" >
<option value='<c:out value="${keyword.word}"/>'><c:out value="${keyword.word}"/></option>
</c:forEach>
</select>
<br/><br/>
<input type='button' name='action' onClick="javascript:addNotKeywords(event,'<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.add"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:deleteNotKeywords('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.delete"/>' class='portlet-form-button' />
</td>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.notWord"/>(<c:out value="${notWordsTotal}"/>):
<br/><br/>
<select name='words' MULTIPLE='MULTIPLE' size='10' class='portlet-form-select' STYLE="width: 120px">
<c:forEach var="word" items="${requestScope.notWords}" >
<option value='<c:out value="${word.word}"/>'><c:out value="${word.word}"/></option>
</c:forEach>
</select>
<br/><br/>
<input type='button' name='action' onClick="javascript:addNotWords(event,'<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.add"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:deleteNotWords('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.delete"/>' class='portlet-form-button' />
</td>
</tr>				
</table>		
</form>
</fmt:bundle>
</body>
</html>