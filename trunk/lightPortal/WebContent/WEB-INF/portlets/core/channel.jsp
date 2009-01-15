<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<light:authorize role="ROLE_ADMIN"> 
<fmt:bundle basename="resourceBundle">
<c:if test='${requestScope.success != null}'>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-success' >
<c:out value="${requestScope.success}"/>
</td>
</tr>
</table>
</c:if>
<c:if test='${requestScope.error != null}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</table>
</c:if>
<form name="form_<c:out value="${requestScope.responseId}"/>" action="<portlet:actionURL windowState='MAXIMIZED'/>" >
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr valign='middle'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.channels"/>:</td>
<td class='portlet-table-td-left'>
<select name='channel' size='1' class='portlet-form-select'>
<c:forEach var="channel" items="${sessionScope.channels}" >
<option value='<c:out value="${channel.name}"/>'
<c:if test='${requestScope.channel ==channel.name}'>
selected="selected"
</c:if>
><c:out value="${channel.desc}"/></option>
</c:forEach>
</select>
</td>
<td></td>
</tr>
<tr valign='middle'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.regions"/>: 
</td>
<td class='portlet-table-td-left'>
<select name='region' size='1' class='portlet-form-select'>
<c:forEach var="region" items="${sessionScope.regions}" >
<option value='<c:out value="${region.id}"/>'
<c:if test='${requestScope.region ==region.id}'>
selected="selected"
</c:if>
><c:out value="${region.desc}"/></option>
</c:forEach>
</select>
<input type='submit' name='action' onClick="document.pressed='search'" value='<fmt:message key="portlet.button.search"/>' class='portlet-form-button' />
</td>
<td class='portlet-table-td-left'>
</td>
</tr>
</table>

<c:if test='${requestScope.portletRefs != null}'>
<br/>
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr valign='top'>
<td class='portlet-table-td-center'>
Available Contents<br/><br/>
<select name='refs' size='10' class='portlet-form-select' STYLE="width: 200px">
<c:forEach var="ref" items="${requestScope.portletRefs}" >
<option value='<c:out value="${ref.name}"/>'><c:out value="${ref.title}"/></option>
</c:forEach>
</select>
<br/><br/>
<input name='edit' type='button' value='<fmt:message key="portlet.button.edit"/>' class='portlet-form-button' onclick="javascript:editPortletRef('<c:out value="${requestScope.responseId}"/>');" />
</td>
<td class='portlet-table-td-center'>
Column 1 Contents<br/><br/>
<select name='portlets0' size='10' class='portlet-form-select' STYLE="width: 200px">
<c:forEach var="portlet" items="${requestScope.portlets0}" >
<option value='<c:out value="${portlet.id}"/>'><c:out value="${portlet.title}"/></option>
</c:forEach>
</select>
<br/><br/>
<input name='add0' type='button' value='<fmt:message key="portlet.button.add"/>' class='portlet-form-button'
  onclick="javascript:addChannelColumn0('<c:out value="${requestScope.responseId}"/>');" />
<input name='del0' type='button' value='<fmt:message key="portlet.button.del"/>' class='portlet-form-button'
  onclick="javascript:delChannelColumn0('<c:out value="${requestScope.responseId}"/>');" />
<input name='up0' type='button' value='<fmt:message key="portlet.button.up"/>' class='portlet-form-button'
  onclick="javascript:upChannelColumn0('<c:out value="${requestScope.responseId}"/>');" />
<input name='down0' type='button' value='<fmt:message key="portlet.button.down"/>' class='portlet-form-button'
  onclick="javascript:downChannelColumn0('<c:out value="${requestScope.responseId}"/>');" />
</td>
<td class='portlet-table-td-center'>
Column 2 Contents<br/><br/>
<select name='portlets1' size='10' class='portlet-form-select' STYLE="width: 200px">
<c:forEach var="portlet" items="${requestScope.portlets1}" >
<option value='<c:out value="${portlet.id}"/>'><c:out value="${portlet.title}"/></option>
</c:forEach>
</select>
<br/><br/>
<input name='add1' type='button' value='<fmt:message key="portlet.button.add"/>' class='portlet-form-button'
  onclick="javascript:addChannelColumn1('<c:out value="${requestScope.responseId}"/>');" />
<input name='del1' type='button' value='<fmt:message key="portlet.button.del"/>' class='portlet-form-button'
  onclick="javascript:delChannelColumn1('<c:out value="${requestScope.responseId}"/>');" />
<input name='up1' type='button' value='<fmt:message key="portlet.button.up"/>' class='portlet-form-button'
  onclick="javascript:upChannelColumn1('<c:out value="${requestScope.responseId}"/>');" />
<input name='down1' type='button' value='<fmt:message key="portlet.button.down"/>' class='portlet-form-button'
  onclick="javascript:downChannelColumn1('<c:out value="${requestScope.responseId}"/>');" />
</td>
<td class='portlet-table-td-center'>
Column 3 Contents<br/><br/>
<select name='portlets2' size='10' class='portlet-form-select' STYLE="width: 200px">
<c:forEach var="portlet" items="${requestScope.portlets2}" >
<option value='<c:out value="${portlet.id}"/>'><c:out value="${portlet.title}"/></option>
</c:forEach>
</select>
<br/><br/>
<input name='add2' type='button' value='<fmt:message key="portlet.button.add"/>' class='portlet-form-button'
  onclick="javascript:addChannelColumn2('<c:out value="${requestScope.responseId}"/>');" />
<input name='del2' type='button' value='<fmt:message key="portlet.button.del"/>' class='portlet-form-button'
  onclick="javascript:delChannelColumn2('<c:out value="${requestScope.responseId}"/>');" />
<input name='up2' type='button' value='<fmt:message key="portlet.button.up"/>' class='portlet-form-button'
  onclick="javascript:upChannelColumn2('<c:out value="${requestScope.responseId}"/>');" />
<input name='down2' type='button' value='<fmt:message key="portlet.button.down"/>' class='portlet-form-button'
  onclick="javascript:downChannelColumn2('<c:out value="${requestScope.responseId}"/>');" />
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='4' >
<input type='button' name='action' onClick="javascript:saveChannel('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
<input type='submit' name='action' onClick="document.pressed='search';document.resetLastAction='1'" value='<fmt:message key="portlet.button.reset"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</c:if>
</form>
</fmt:bundle>
</light:authorize>
</body>
</html>
