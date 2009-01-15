<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>

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
<form action="<portlet:actionURL portletMode='VIEW'/>">
<light:authenticateOwner> 
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<a href='javascript:void(0)' onclick="<portlet:renderURL  portletMode='EDIT'><portlet:param name='add' value='add'/></portlet:renderURL>" ><img src='<%= request.getContextPath() %>/light/images/add.gif' style='border: 0px;' height='16' width='16' align="middle"/><fmt:message key="portlet.button.addMusic"/></a>
</td>
</tr>
</table>
</light:authenticateOwner>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<fmt:message key="portlet.label.youHave"/> <c:out value="${requestScope.musicCount}"/> <fmt:message key="portlet.label.musics"/>
<c:if test='${requestScope.musicCount > 0}'>
<input type="image" title='<fmt:message key="portlet.button.stop"/>' src="<%= request.getContextPath() %>/light/images/stop.gif" style='border: 0px;' height='11' width='11' name = '<c:out value="${music.id}"/>' align='middle' onClick="javascript:stopMusic(); return false;"/>
</c:if>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width= '100%' >

<c:forEach var="music" items="${requestScope.userMusics}" >
<tr>
<td class='portlet-table-td-left' width='90%'>
<light:authenticateOwner> 
<input type='radio' name='musicId' value='<c:out value="${music.id}"/>' />
</light:authenticateOwner>
<span class="portlet-item">
<input type="image" title='<fmt:message key="portlet.button.play"/>' src="<%= request.getContextPath() %>/light/images/play.gif" style='border: 0px;' height='16' width='16' name = '<c:out value="${music.id}"/>' align='middle' onClick="javascript:playMusic('<c:out value="${music.musicUrl}"/>'); return false;"/>
<a href='<%= request.getContextPath() %><c:out value="${music.musicUrl}"/>' target="_blank">
<c:out value="${music.caption}"/>
</a>
</span>
</td>
<td>
</td>
</tr>
</c:forEach>
<light:authenticateOwner> 
<c:if test='${requestScope.musicCount > 0}'>
<tr>
<td class='portlet-table-td-center' colspan='2'>
<br/><br/>
<input type='submit' onClick="document.pressed='select';" value='<fmt:message key="portlet.button.config"/>' class='portlet-form-button' />
<input type='submit' onClick="document.pressed='rank';" value='<fmt:message key="portlet.button.rankPicture"/>' class='portlet-form-button' />
<input type='submit' onClick="document.pressed='ring';" value='<fmt:message key="portlet.button.ringTone"/>' class='portlet-form-button' />
<input type='submit' onClick="document.pressed='background';" value='<fmt:message key="portlet.button.backgroundMusic"/>' class='portlet-form-button' />
<input type='submit' onClick="document.pressed='delete';" value='<fmt:message key="portlet.button.delete"/>' class='portlet-form-button' />
</td>
</tr>
</c:if>
</light:authenticateOwner>
</table>
</form>
</fmt:bundle>
</body>
</html>