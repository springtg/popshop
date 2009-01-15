 <%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<fmt:bundle basename="resourceBundle">
<light:authenticateOwner> 
<form action="<portlet:actionURL portletMode='VIEW'/>">
<input type='hidden' name ='pageId' value='<c:out value="${requestScope.pageId}"/>'/>
<table border='0' cellpadding='0' cellspacing='0' width='99%'>
<c:if test='${requestScope.error != null}'>
<tr>
<td class='portlet-msg-error' colspan = '2' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</c:if>
<tr>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','edit','maximized','type=create;pageId=<c:out value="${pageId}"/>');" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.label.composeMail"/></a>
</td>
<c:if test='${requestScope.currentMail == null}'>
<td class='portlet-link' >
<c:if test='${requestScope.totalCount > pageId * requestScope.row}'>
<c:out value="${(pageId - 1) * requestScope.row + 1}"/> - <c:out value="${pageId * requestScope.row}"/>
</c:if>
<c:if test='${requestScope.totalCount <= pageId * requestScope.row}'>
<c:out value="${(pageId - 1) * requestScope.row + 1}"/> - <c:out value="${requestScope.totalCount}"/>
</c:if>
 of <c:out value="${requestScope.totalCount}"/>
(<c:out value="${requestScope.unreadCount}"/>)
<c:if test='${requestScope.pages > 1}'>
<c:if test='${requestScope.pageId > 1}'>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','pageId=1;newPage=1');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.label.first"/>' /></a>						
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','pageId=<c:out value="${requestScope.pageId - 1}"/>;newPage=1');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.label.previous"/>'/></a>						
</c:if>
<c:if test='${requestScope.pageId == 1}'>
<img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.label.first"/>'/>		
<img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.label.previous"/>'/>	
</c:if>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','pageId=<c:out value="${requestScope.pageId + 1}"/>;newPage=1');"><img src='<%= request.getContextPath() %>/light/images/next.gif' style='border: 0px' title='<fmt:message key="portlet.label.next"/>'/></a>
<a href="javascript:void(0);" onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','pageId=<c:out value="${requestScope.pages}"/>;newPage=1');"><img src='<%= request.getContextPath() %>/light/images/next.gif' style='border: 0px' title='<fmt:message key="portlet.label.last"/>'/></a>
</c:if>
</td>
</c:if>
</tr>
</table>
<c:if test='${requestScope.currentMail == null}'>
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<c:forEach var="mail" items="${requestScope.mails}" varStatus="status">
<tr valign='top'
<c:if test='${status.index % 2 == 0 }'>
class='portlet-table-td-left'
</c:if>
<c:if test='${status.index % 2 == 1 }'>
class='portlet-bgcolor'
</c:if>
>
<td class='portlet-item'>
<c:if test='${mail.flag == 1}'>
<b>
</c:if>
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','mailId=<c:out value="${status.index}"/>;pageId=<c:out value="${pageId}"/>');"><c:out value="${mail.fromName}"/>: <c:out value="${mail.subject}"/></a>
<c:if test='${mail.flag == 1}'>
</b>
</c:if>
</td>
<td class='portlet-item' >
<c:if test='${mail.flag == 1}'>
<b>
</c:if>
<c:out value="${mail.date}"/>
<c:if test='${mail.flag == 1}'>
</b>
</c:if>
</td>
<td class='portlet-table-td-right'>
<input type="image" src="light/images/deleteLink.gif" style='border: 0px;' height='11' width='11' name="<c:out value='${status.index}'/>" onClick="document.pressed='delete';document.parameter=this.name;"/>
</td>
</tr>
</c:forEach>
</table>
</c:if>

<c:if test='${requestScope.currentMail != null}'>
<input type='hidden' name ='toEmail' value='<c:out value="${currentMail.fromInfo}"/>'/>
<input type='hidden' name ='subject' value='<c:out value="${currentMail.subject}"/>'/>
<input type='hidden' name ='content' value='<c:out value="${currentMail.content}"/>'/>
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr>
<td class='portlet-table-td-left' width='80'><fmt:message key="portlet.label.from"/>:</td>
<td class='portlet-table-td-left'>
<span class='portlet-item'>
<a href='mailto:<c:out value="${currentMail.fromInfo}"/>' ><c:out value="${currentMail.fromInfo}"/></a>
</span>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='80'><fmt:message key="portlet.label.date"/>:</td>
<td class='portlet-table-td-left' >
<c:out value="${currentMail.fullDate}"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='80'><fmt:message key="portlet.label.subject"/>:</td>
<td class='portlet-table-td-left' >
<c:out value="${currentMail.subject}"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' width='80'><fmt:message key="portlet.label.content"/>:<br/></td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'><c:out value="${currentMail.content}" escapeXml="false"  /></td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<input type='submit' name='action' onClick="document.pressed='reply';document.resetLastAction='1'" value='<fmt:message key="portlet.button.reply"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:popupToDo('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.addToDo"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:popupCalendar('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.addCalendar"/>' class='portlet-form-button' />
<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','pageId=<c:out value="${pageId}"/>');" value='<fmt:message key="portlet.button.back"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</c:if>
</form>
</light:authenticateOwner>
</fmt:bundle>
</body>
</html>