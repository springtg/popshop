<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="profileDetailHeader.jsp" ></jsp:include>
<br/>
<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0' width='95%'>		
<tr>
<td class='portlet-table-td-left' colspan='3'>
<fmt:message key="portlet.label.chooseChannel"/>:
</td>
</tr>			
<c:forEach var="channel" items="${requestScope.channels}" varStatus="status" >
<c:if test='${status.index % 2 == 0}'>
<tr>
</c:if>
<td class='portlet-table-td-left'>
<input TYPE='checkbox' name='channels' 
<c:if test='${channel.selected == 1}'>
checked="yes" 
</c:if>
value='<c:out value="${channel.name}"/>'><c:out value="${channel.desc}"/></input>
</td>
<c:if test='${status.index % 2 == 1}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.totalChannels % 2 != 0}'>
</tr>
</c:if>
</table>


<table border='0' cellpadding='0' cellspacing='0' width='80%'>
<tr>
<td class='portlet-table-td-right'>
<input name='subscribe' type='button' value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button'
 	onclick="javascript:subscribeChannels('<c:out value="${requestScope.responseId}"/>');" />
<c:if test='${requestScope.success != null}'>
<input name='subscribe' type='button' value='<fmt:message key="portlet.button.done"/>' class='portlet-form-button'
 	onclick="javascript:Light.refreshPortal();" />
</c:if>
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>