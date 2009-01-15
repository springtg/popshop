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
<td class='portlet-table-td-left' width='10'>
<fmt:message key="portlet.label.from"/>:
</td>
<td class='portlet-table-td-center'>
<c:if test='${requestScope.ad.photoUrl == null}'>
<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
</c:if>
<c:if test='${requestScope.ad.photoUrl != null}'>
<img src='<%= request.getContextPath() %><c:out value="${requestScope.ad.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${requestScope.ad.photoWidth}"/>' height='<c:out value="${requestScope.ad.photoHeight}"/>'/>
</c:if>
<br/>
<span class='portlet-item'>
<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${requestScope.ad.uri}"/>' ><c:out value="${requestScope.ad.displayName}"/></a>
</span>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.title"/>:
<c:out value="${requestScope.ad.title}"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.location"/>:
<c:out value="${requestScope.ad.location}"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.effDate"/>:
<c:out value="${requestScope.ad.effDate}"/> to <c:out value="${requestScope.ad.endEffDate}"/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<fmt:message key="portlet.label.content"/>:
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<c:out value="${requestScope.ad.content}" escapeXml="false"/>
</td>
</tr>
<c:if test='${requestScope.ad.commentCount > 0 }'>
<tr> 
 <td class='portlet-table-td-right' colspan='2'> 
 <span class="portlet-link"> 	
 <a href='javascript:void(0);' onclick="javascript:showAdComment(event,'<c:out value="${requestScope.ad.id}"/>');"><fmt:message key="portlet.label.total"/> <c:out value="${requestScope.ad.commentCount}"/> <fmt:message key="portlet.label.comments"/></a> 
 </span> 
 </td> 
</tr> 
</c:if>
<tr>
<td class='portlet-table-td-right' colspan='2'>
<input type='button' value='<fmt:message key="portlet.button.addComment"/>'
 onclick="javascript:addAdComment(event,'<c:out value="${ad.id}"/>','<c:out value="${requestScope.responseId}"/>');" class='portlet-form-button'/>
<input type='button' value='<fmt:message key="portlet.button.popIt"/>'
 onclick="javascript:popAd('<c:out value="${ad.id}"/>','<c:out value="${requestScope.responseId}"/>');" class='portlet-form-button'/>
<input type='button' value='<fmt:message key="portlet.button.back"/>'
 onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" class='portlet-form-button'/>
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>
