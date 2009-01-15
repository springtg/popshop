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
<light:authenticateUser> 
<c:if test='${requestScope.picture == null}'>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        <br/><fmt:message key="portlet.label.pictureLink"/>
      </td>    
      <td class='portlet-table-td-left' >
        <input type='text' name='pictureUrl' size='30' />
      </td>
    </tr>    
    <tr>
      <td class='portlet-table-td-right' colspan='2' >
        <input type='submit' onClick="document.pressed='addUrl';document.resetLastAction='1';" value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
      </td>
    </tr>
  </table>
</form>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-link-left' >
<fmt:message key="portlet.label.or"/><fmt:message key="portlet.label.uploadPicture"/>
<br/>
</td>
</tr>
<tr>
<td class='portlet-link-left' >
<fmt:message key="portlet.message.uploadPicture"/>
</td>
</tr>
</table>
<form name='myPhotoForm' enctype='multipart/form-data' method='post'
  action ='<%= request.getContextPath() %>/uploadPicture.lp' onsubmit="javascript:return AIM.submit(this, {'onStart' : startCallback, 'onComplete' : completeCallback}, '<c:out value="${requestScope.responseId}"/>')">
  <table border='0' cellpadding='0' cellspacing='0' > 
    <tr>
      <td class='portlet-table-td-left' >
        <br/><input type='file' name='file' size='30' />
      </td>
    </tr>
    <tr>
    	<td class='portlet-link-left' >
		<a href='javascript:void(0)' onclick="javascript:Light.showUploader('<c:out value="${requestScope.responseId}"/>','uploadPictures');" ><fmt:message key="portlet.button.uploadMultiPictures"/></a>
    	</td>      
    </tr>
    <tr>
      <td class='portlet-table-td-right' >
        <input type='submit' value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
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