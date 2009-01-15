<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='95%'>
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:forEach var="type" items="${requestScope.showType}" varStatus="status">
<input type='radio' name='showType' value='<c:out value="${type.id}"/>' class='portlet-form-radio'
<c:if test='${currentShowType == type.id}'>
checked="checked"
</c:if>
>
<c:out value="${type.desc}"/></input>
<c:if test='${"5" == type.id}'>
<select name='friendType' size='1'  class='portlet-form-select'>
<c:forEach var="fType" items="${requestScope.friendType}" varStatus="status">
<option 
<c:if test='${currentFriendType == fType.id}'>
selected='selected' 
</c:if>
value='<c:out value="${fType.id}"/>'><c:out value="${fType.desc}"/></option>
</c:forEach>
</select>
</c:if>
<br/>
</c:forEach>
</td>
</tr>

<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.showItems"/>:
</td>
<td class='portlet-table-td-left'>
<select name='items' size='1'  class='portlet-form-select' STYLE="width: 80px">
<c:if test='${requestScope.showNumber == 0}'>
<option selected='selected' value='0'><fmt:message key="portlet.label.all"/></option>
</c:if>
<c:if test='${requestScope.showNumber != 0}'>
<option value='0'><fmt:message key="portlet.label.all"/></option>
</c:if>
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
<select name='columns' size='1'  class='portlet-form-select'  STYLE="width: 80px">
<c:forEach var="i" begin="1" end="3" step="1">
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
<tr>
<td class='portlet-table-td-right' colspan='2' >
<input type='submit' name='action' onClick="document.pressed='config';document.resetLastAction='1';" value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
