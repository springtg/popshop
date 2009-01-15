<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0' width="95%">
<tr>
<td class='portlet-table-td-left'>
Feed:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='prFeed'  value='<c:out value="${requestScope.feed}"/>' class='portlet-form-input-field' size='30' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Title:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='prTitle'  value='<c:out value="${requestScope.portlet.title}"/>' class='portlet-form-input-field' size='30'/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Link:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='prUrl'  value='<c:out value="${requestScope.portlet.url}"/>' class='portlet-form-input-field' size='30'/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Image Link:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='prIcon' value='<c:out value="${requestScope.portlet.icon}"/>' class='portlet-form-input-field' size='30'/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Auto Refresh:
</td>
<td class='portlet-table-td-left'>
<select name='prAuto' size='1'  class='portlet-form-select'>
<c:if test='${requestScope.portlet.autoRefreshed == 1}'>
<option selected='selected' value='1'>true</option>
</c:if>
<c:if test='${requestScope.portlet.autoRefreshed != 1}'>
<option value='1'>true</option>
</c:if>
<c:if test='${requestScope.portlet.autoRefreshed == 0}'>
<option selected='selected' value='0'>false</option>
</c:if>
<c:if test='${requestScope.portlet.autoRefreshed != 0}'>
<option value='0'>false</option>
</c:if>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Refresh minute rate:
</td>
<td class='portlet-table-td-left'>
<select name='prMinute' size='1'  class='portlet-form-select'>
<c:forEach var="i" begin="0" end="60" step="1">
<c:if test='${requestScope.minute == i}'>
<option selected='selected' value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
<c:if test='${requestScope.minute != i}'>
<option value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Show Type:
</td>
<td class='portlet-table-td-left'>
<select name='prShowType' size='1'  class='portlet-form-select'>
<c:if test='${requestScope.portlet.showType == 0}'>
<option selected='selected' value='0'>Title</option>
</c:if>
<c:if test='${requestScope.portlet.showType != 0}'>
<option value='0'>Title</option>
</c:if>
<c:if test='${requestScope.portlet.showType == 1}'>
<option selected='selected' value='1'>Description</option>
</c:if>
<c:if test='${requestScope.portlet.showType != 1}'>
<option value='1'>Description</option>
</c:if>
<c:if test='${requestScope.portlet.showType == 2}'>
<option selected='selected' value='2'>Both</option>
</c:if>
<c:if test='${requestScope.portlet.showType != 2}'>
<option value='2'>Both</option>
</c:if>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
Show Items:
</td>
<td class='portlet-table-td-left'>
<select name='prItems' size='1'  class='portlet-form-select'>
<c:forEach var="i" begin="1" end="50" step="1">
<c:if test='${requestScope.portlet.showNumber == i}'>
<option selected='selected' value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
<c:if test='${requestScope.portlet.showNumber != i}'>
<option value='<c:out value="${i}" />'><c:out value="${i}" /></option>
</c:if>
</c:forEach>
</select>
<input name='Submit' type='button' value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button'	onclick="javascript:editRssPortlet('<c:out value="${requestScope.responseId}"/>');" />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>						
</table>		
</form>
</fmt:bundle>
</body>
</html>