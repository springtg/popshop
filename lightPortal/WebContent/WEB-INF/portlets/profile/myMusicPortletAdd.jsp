<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<c:if test='${requestScope.music == null}'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>         
</c:if>
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
<light:authenticateUser> 
<c:if test='${requestScope.music == null}'>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        <fmt:message key="portlet.label.music.url"/>:
      </td>    
      <td class='portlet-table-td-left' >
        <input type='text' name='musicUrl' size='40' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        <fmt:message key="portlet.label.music.caption"/>:
      </td>    
      <td class='portlet-table-td-left' >
        <input type='text' name='musicCaption' size='40' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-right' colspan='2'>
        <input type='submit' onClick="document.pressed='addUrl';document.resetLastAction='1';" value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
      </td>
    </tr>
  </table>
</form>
<form name='myMusicForm' enctype='multipart/form-data' method='post' accept-charset='UTF-8' 
  action ='<%= request.getContextPath() %>/uploadMusic.lp' onsubmit="javascript:return AIM.submit(this, {'onStart' : startCallback, 'onComplete' : completeCallback}, '<c:out value="${requestScope.responseId}"/>')">
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Or Upload Music File:
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        <input type='file' name='file' size='30' />
      </td>
    </tr>
    <tr>
    	<td class='portlet-link-left' >
		<a href='javascript:void(0)' onclick="javascript:Light.showUploader('<c:out value="${requestScope.responseId}"/>','uploadMusics');" ><fmt:message key="portlet.button.uploadMultiMusics"/></a>
    	</td>      
    </tr>
    <tr>
      <td class='portlet-table-td-right' >
        <input type='submit' value='<fmt:message key="portlet.button.upload"/>' class='portlet-form-button' />
      	<input type='button' name='action' onClick="javascript:Light.backToView('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
      </td>
    </tr>
  </table>
</form>
</c:if>
</light:authenticateUser>
</fmt:bundle>
</body>
</html>