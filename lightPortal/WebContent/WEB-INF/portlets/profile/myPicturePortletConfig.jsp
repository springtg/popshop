<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0' width='95%'>
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-left'>
Auto Refresh:
</td>
<td class='portlet-table-td-left'>
<select name='auto' size='1'  class='portlet-form-select'>
<c:if test='${requestScope.portlet.autoRefreshed == 2}'>
<option selected='selected' value='2'>true</option>
</c:if>
<c:if test='${requestScope.portlet.autoRefreshed != 2}'>
<option value='2'>true</option>
</c:if>
<c:if test='${requestScope.portlet.autoRefreshed == 0}'>
<option selected='selected' value='0'>false</option>
</c:if>
<c:if test='${requestScope.portlet.autoRefreshed != 0}'>
<option value='0'>false</option>
</c:if>
</select>
<input type='hidden' name='seconds' value='0.05'/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.showItems"/>:
</td>
<td class='portlet-table-td-left'>
<select name='items' size='1'  class='portlet-form-select'>
<c:forEach var="i" begin="1" end="50" step="1">
<c:if test='${requestScope.showNumber == i}'>
<option selected='selected' value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
<c:if test='${requestScope.showNumber != i}'>
<option value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.showColumns"/>:
</td>
<td class='portlet-table-td-left'>
<select name='columns' size='1'  class='portlet-form-select'>
<c:forEach var="i" begin="1" end="50" step="1">
<c:if test='${requestScope.columnNumber == i}'>
<option selected='selected' value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
<c:if test='${requestScope.columnNumber != i}'>
<option value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
</c:forEach>
</select>
</td>
</tr>
<tr valign='top'>
<td class='portlet-table-td-right'>
<fmt:message key="portlet.label.privacy.pic.default"/>:
</td>
<td class='portlet-table-td-left'>
<input type='radio' name='status' value='0' class='portlet-form-radio'
<c:if test='${requestScope.defaultPicStatus == 0}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.privacy.pic.me"/></input><br/>
<input type='radio' name='status' value='1' class='portlet-form-radio'
<c:if test='${requestScope.defaultPicStatus == 1}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.privacy.pic.friends"/></input><br/>
<input type='radio' name='status' value='2' class='portlet-form-radio'
<c:if test='${requestScope.defaultPicStatus == 2}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.privacy.pic.public"/></input><br/> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2' >
<input name='Submit' type='button' value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button'	onclick="javascript:editPicPortlet('<c:out value="${requestScope.responseId}"/>');" />
<input type='button' name='action' onClick="javascript:Light.backToView('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
