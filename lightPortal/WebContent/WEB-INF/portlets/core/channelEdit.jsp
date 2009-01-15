<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<light:authorize role="ROLE_ADMIN"> 
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
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.name"/>:
</td>
<td class='portlet-table-td-left'>
<c:out value="${ref.name}" />
<input type='hidden' name='name'  value='<c:out value="${ref.name}" />'/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' >
<fmt:message key="portlet.label.title"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='label'  value='<c:out value="${ref.label}" />'
class='portlet-form-input-field' size='40' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.path"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='path'  value='<c:out value="${ref.path}" />'
class='portlet-form-input-field' size='40' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.tag"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='tag'  value='<c:out value="${ref.tag}" />'
class='portlet-form-input-field' size='40' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.subTag"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='subTag'  value='<c:out value="${ref.subTag}" />'
class='portlet-form-input-field' size='40' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.language"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='language'  value='<c:out value="${ref.language}"
/>' class='portlet-form-input-field' size='40' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.user"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='refUserId'  value='<c:out value="${ref.userId}" />'
class='portlet-form-input-field' size='40' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.icon"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='icon'  value='<c:out value="${ref.icon}" />'
class='portlet-form-input-field' size='80' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.url"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='url'  value='<c:out value="${ref.url}" />'
class='portlet-form-input-field' size='80' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.parameter"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='parameter'  value='<c:out
value="${ref.parameter}" />' class='portlet-form-input-field' size='80' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<input TYPE='checkbox' name='refreshMode' value='1'
<c:if test='${ref.refreshMode == 1}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.refreshMode"/></input>
<input TYPE='checkbox' name='editMode' value='1'
<c:if test='${ref.editMode == 1}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.editMode"/></input>
<input TYPE='checkbox' name='helpMode' value='1'
<c:if test='${ref.helpMode == 1}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.helpMode"/></input>
<input TYPE='checkbox' name='configMode' value='1'
<c:if test='${ref.configMode == 1}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.configMode"/></input>
<input TYPE='checkbox' name='autoRefresh' value='1'
<c:if test='${ref.autoRefreshed == 1}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.autoRefresh"/></input>
<input TYPE='checkbox' name='pageRefresh' value='1'
<c:if test='${ref.pageRefreshed == 1}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.pageRefresh"/></input>
<input TYPE='checkbox' name='allowJS' value='1'
<c:if test='${ref.allowJS == 1}'>
checked="checked"
</c:if>
><fmt:message key="portlet.label.allowJS"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.periodTime"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='periodTime'  value='<c:out
value="${ref.periodTime}" />' class='portlet-form-input-field' size='40'
/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100' >
<fmt:message key="portlet.label.showNumber"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='showNumber'  value='<c:out
value="${ref.showNumber}" />' class='portlet-form-input-field' size='40'
/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.showType"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='showType'  value='<c:out value="${ref.showType}"
/>' class='portlet-form-input-field' size='40' />
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.windowStatus"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='windowStatus'  value='<c:out
value="${ref.windowStatus}" />' class='portlet-form-input-field' size='40'
/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.mode"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='refMode'  value='<c:out value="${ref.mode}" />' class='portlet-form-input-field' size='40' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='100'>
<fmt:message key="portlet.label.type"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='refType'  value='<c:out value="${ref.type}" />' class='portlet-form-input-field' size='40' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2'>
<input type='submit' name='action' onClick="document.pressed='edit'"
value='<fmt:message key="portlet.button.save"/>'
class='portlet-form-button' />
<input type='button' name='action'
onClick="javascript:Light.executeRender('<c:out
value="${requestScope.responseId}"/>','','','');" value='<fmt:message
key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</light:authorize>
</body>
</html>