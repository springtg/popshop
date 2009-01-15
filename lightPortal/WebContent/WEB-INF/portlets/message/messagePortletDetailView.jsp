<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
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
<c:if test='${requestScope.type == "in"}'>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.from"/>:
</td>
<td class='portlet-table-td-center'>
<span class='portlet-item'>
<c:if test='${requestScope.message.fromPhotoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${requestScope.message.fromPhotoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${requestScope.message.fromPhotoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${requestScope.message.fromPhotoSmallWidth}"/>' height='<c:out value="${requestScope.message.fromPhotoSmallHeight}"/>'/>
</c:if>
<br/>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${requestScope.message.fromUri}"/>' target="_blank" ><c:out value="${requestScope.message.fromDisplayName}"/></a>
<c:if test='${requestScope.message.fromCurrentStatusId == 1 }'>
<br/>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px;' height='16' width='16'  align="bottom" alt=''/>
<br/>
<a href='javascript:void(0)' onclick="javascript:showInstantMessageMember(event,'<c:out value="${requestScope.message.postById}"/>','<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.instantMessage"/></a>
<br/>
</c:if>
</span>
</td>
</c:if>
<c:if test='${requestScope.type == "sent"}'>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.to"/>:
</td>
<td class='portlet-table-td-center'>
<c:if test='${requestScope.message.toPhotoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${requestScope.message.toPhotoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${requestScope.message.toPhotoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${requestScope.message.toPhotoSmallWidth}"/>' height='<c:out value="${requestScope.message.toPhotoSmallHeight}"/>'/>
</c:if>
<br/>
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${requestScope.message.toUri}"/>' target="_blank"><c:out value="${requestScope.message.toDisplayName}"/></a>
</span>
<c:if test='${requestScope.message.toCurrentStatusId == 1 }'>
<br/>
<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px;' height='16' width='16'  align="bottom" alt=''/>
<br/>
<span class='portlet-item'>
<a href='javascript:void(0)' onclick="javascript:showInstantMessageMember(event,'<c:out value="${requestScope.message.userId}"/>','<c:out value="${requestScope.responseId}"/>');" ><fmt:message key="portlet.label.instantMessage"/></a>
</span>
<br/>
</c:if>
</td>
</c:if>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width="98%">
<tr>
<td class='portlet-table-td-left' width='20%'>
<fmt:message key="portlet.label.subject"/>:
</td>
<td class='portlet-table-td-left'>
<c:out value="${requestScope.message.subject}"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.content"/>:
</td>
</tr>
<tr>
<td class='portlet-table-td-left'></td>
<td class='portlet-table-td-left'>
<c:out value="${requestScope.message.content}" escapeXml="false" />
</td>
</tr>
<c:if test='${requestScope.message.event != 0}'>
<tr>
<td class='portlet-table-td-center' colspan='2' >
<input type='submit' name='<c:out value="${requestScope.message.id}"/>' onClick="document.pressed='approve';document.parameter=this.name;" value='<fmt:message key="portlet.button.approve"/>' class='portlet-form-button' />
<input type='submit' name='<c:out value="${requestScope.message.id}"/>' onClick="document.pressed='deny';document.parameter=this.name;" value='<fmt:message key="portlet.button.deny"/>' class='portlet-form-button' />
</td>
</tr>
</c:if>
<tr>
<td class='portlet-table-td-right' colspan='2' >
<input type='submit' name='<c:out value="${requestScope.message.id}"/>' onClick="document.pressed='reply';document.parameter=this.name;" value='<fmt:message key="portlet.button.reply"/>' class='portlet-form-button' />
<input type='submit' name='<c:out value="${requestScope.message.id}"/>' onClick="document.pressed='forward';document.parameter=this.name;" value='<fmt:message key="portlet.button.forward"/>' class='portlet-form-button' />
<input type='submit' name='<c:out value="${requestScope.message.id}"/>' onClick="document.pressed='delete';document.parameter=this.name;" value='<fmt:message key="portlet.button.delete"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.back"/>' class='portlet-form-button' />

</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
