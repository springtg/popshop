<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>" onsubmit="javascript:return validateTodo(this);">           
	<table border='0' cellpadding='0' cellspacing='0' width='95%'>
		<c:if test='${requestScope.missingField != null}'>
			<tr>
			<td class='portlet-table-td-left'>
			Name and description are required fields.
			</td>
			</tr>
		</c:if>
		<tr>
		<td class='portlet-table-td-left'>
		<fmt:message key="portlet.label.todo"/>:
		</td>
		</tr>
		<tr>
		<td class='portlet-table-td-left'>
		<c:if test="${requestScope.todo.status !=0}">
		<input type='text' name='name' class='portlet-form-input-field' size='24' value='<c:out value="${requestScope.todo.name}"/>' style="text-decoration: underline line-through;"/>
		</c:if>
		<c:if test="${requestScope.todo.status ==0}">
		<input type='text' name='name' class='portlet-form-input-field' size='24' value='<c:out value="${requestScope.todo.name}"/>'/>
		</c:if>
		<INPUT TYPE='hidden' NAME="id" value='<c:out value="${requestScope.todo.id}"/>' />
		<fmt:message key="portlet.label.priority"/>:
		<select name='priority' size='1'  class='portlet-form-select' style="width:36px">
		<c:forEach var="i" begin="1" end="10" step="1">
		<c:if test='${requestScope.todo.priority == i}'>
		<option selected='selected' value='<c:out value="${i}" />'><c:out value="${i}" /></option>
		</c:if>
		<c:if test='${requestScope.todo.priority != i}'>
		<option value='<c:out value="${i}" />'><c:out value="${i}" /></option>
		</c:if>
		</c:forEach>
		</select>
		</td>
		</tr>
		<tr>
		<td class='portlet-table-td-left'>
		<fmt:message key="portlet.label.description"/>:
		</td>
		</tr>
		<tr>
		<td class='portlet-table-td-left'>
		<textarea name='description' class='portlet-form-textarea-field' rows='2' cols='33' onfocus="javascript:this.select();"><c:out value="${requestScope.todo.description}"/></textarea>
		</td>
		</tr>						
		<tr>
		<td class='portlet-table-td-left'>
		<input type='submit' name='action' onClick="document.pressed='save';document.resetLastAction='1';increaseTodoPortletTitle('<c:out value="${requestScope.responseId}"/>',<c:out value="${requestScope.todo.id}"/>);" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
		<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />		
		</td>
		</tr>
	</table>		
</form>
</fmt:bundle>
</body>
</html>