<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="optionsHeader.jsp" ></jsp:include>
<br/>
<fmt:bundle basename="resourceBundle">
<br/>
<br/>
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0'>
<tr valign='top'>
<td class="portlet-table-td-right">Title:</td>
<td class="portlet-table-td-left">
<input name="ptTitle" value='<c:out value="${requestScope.tab.title}"/>' class="portlet-form-input-field" size="16" type="text">
</td>
</tr>
<tr valign='top'>
<td class="portlet-table-td-right">Page Link:</td>
<td class="portlet-table-td-left">
<span class="portlet-rss" > 
<a href='http://www.<c:out value="${sessionScope.org.webId}"/>/page/<c:out value="${requestScope.tab.id}"/>'>http://www.<c:out value="${sessionScope.org.webId}"/>/page/<c:out value="${requestScope.tab.id}"/></a>
</span>
</td>
</tr>
<tr valign='top'>
<td class="portlet-table-td-right">Content Skin:</td>
<td class="portlet-table-td-left">
<select name="ptWindow" size="1" class="portlet-form-select">
<c:forEach var="windowSkin" items="${requestScope.windowSkins}" varStatus="status">
<option value='<c:out value="${windowSkin.id}"/>'
<c:if test='${requestScope.tab.portletWindowType == windowSkin.id}'>
selected="selected"
</c:if>
>
<c:out value="${windowSkin.desc}"/></option>
</c:forEach>
</select>
</td>
</tr>
<tr valign='top'>
<td class="portlet-table-td-right">Allow to be Closed:</td>
<td class="portlet-table-td-left">
<input name="ptClose" type="checkbox"
<c:if test='${requestScope.tab.closeable == 1}'>
checked="checked"
</c:if>
/>
</td>
</tr>
<tr valign='top'>
<td class="portlet-table-td-right">Default tab:</td>
<td class="portlet-table-td-left">
<input name="ptDefault" type="checkbox"
<c:if test='${requestScope.tab.defaulted == 1}'>
checked="checked"
</c:if>
/>
</td>
</tr>
<tr valign='top'>
<td class="portlet-table-td-right">Page Privacy:</td>
<td class="portlet-table-td-left">
<input type='radio' name='ptStatus' value='0' class='portlet-form-radio'
<c:if test='${requestScope.tab.status == 0}'>
checked='true'
</c:if>
>
Only for me</input> 
<input type='radio' name='ptStatus' value='1' class='portlet-form-radio'
<c:if test='${requestScope.tab.status == 1}'>
checked='true'
</c:if>
>
Show on my Public space</input> 
<input type='radio' name='ptStatus' value='2' class='portlet-form-radio'
<c:if test='${requestScope.tab.status == 2}'>
checked='true'
</c:if>
>
Available to my friends</input> 
<input type='radio' name='ptStatus' value='3' class='portlet-form-radio'
<c:if test='${requestScope.tab.status == 3}'>
checked='true'
</c:if>
>
Open to public</input> 
</td>
</tr>
<tr valign='top'>
<td class="portlet-table-td-right">Auto fit screen width:</td>
<td class="portlet-table-td-left">
<input name="ptFitScreen" type="checkbox"
<c:if test='${requestScope.tab.fitScreen == 1}'>
checked="checked"
</c:if>
/>
</td>
</tr>
<tr valign='top'>
<td class="portlet-table-td-right">Allowed Columns:</td>
<td class="portlet-table-td-left">
<select name="ptColumns" size="1" class="portlet-form-select">
<c:forEach var="i" begin="1" end="10" step="1">
<option value='<c:out value="${i}" />' 
<c:if test='${requestScope.tab.columnTotal == i}'>
selected="selected"
</c:if>
><c:out value="${i}" /></option>
</c:forEach>
</select>
</td>
</tr>
<tr valign='top'>
<td class="portlet-table-td-right">Columns between width:</td>
<td class="portlet-table-td-left">
<input name="ptBetween" value="<c:out value="${requestScope.tab.between}"/>" class="portlet-form-input-field" size="10" type="text">
</td>
</tr>
<tr>
<td class="portlet-table-td-right">Columns width:</td>
<td class="portlet-table-td-left">
<input name="ptWidths" value="<c:out value="${requestScope.tab.widths}"/>" class="portlet-form-input-field" size="24" type="text">
</td>
</tr>
<%-- 
<c:forEach var="width" items="${requestScope.tab.columnWidths}" varStatus="loop">
<tr>
<td class="portlet-table-td-right">Column <c:out value="${loop.index + 1}"/> width:</td>
<td class="portlet-table-td-left">
<input name="ptWidth0" value='<c:out value="${width}"/>' class="portlet-form-input-field" size="10" type="text">
</td>
</tr>
</c:forEach>
--%>
<tr valign='top'>
<td class='portlet-table-td-right' colspan='2'>
<input name='Save' type='button' value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button'
 onclick="javascript:manageTab('<c:out value="${requestScope.responseId}"/>');" />
<input name='Cancel' type='button' value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button'
 onclick="javascript:Light.closePortlet('<c:out value="${requestScope.responseId}"/>');" /> 
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>