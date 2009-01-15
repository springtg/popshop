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
<c:if test='${requestScope.picture != null}'>
<form action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td class='portlet-table-td-center'>
<a href='<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' target="_blank"><img src='<%= request.getContextPath() %><c:out value="${picture.pictureUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${picture.smallWidth}"/>' height='<c:out value="${picture.smallHeight}"/>'/></a>
<br/><br/>
<input type='hidden' name='pictureId' value='<c:out value="${picture.id}"/>'/>
<fmt:message key="portlet.label.caption"/>:
<input type='text' name='caption' value='<c:out value="${picture.caption}"/>' class='portlet-form-input-field' size='18' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-center'>
<input type='submit' onClick="document.pressed='save';" value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
<input type='submit' onClick="document.pressed='cancel';" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</c:if>

<c:if test='${requestScope.picture == null}'>
<span>
<h4>Add a new Picture</h4>
</span>
<br/>
<span>
Share your photos to let friends and other members see who you are.<br/> 
Photos may not contain nudity, sexually explicit content, violent or offensive material, or copyrighted images. Do not load images of other people without their permission.
</span>
<form name='editGroupPhotoForm' enctype='multipart/form-data' method='post'
  action ='<%= request.getContextPath() %>/uploadGroupPicture.lp' onsubmit="javascript:return AIM.submit(this, {'onStart' : startCallback, 'onComplete' : completeCallback}, '<c:out value="${requestScope.responseId}"/>')">
  <table border='0' cellpadding='0' cellspacing='0' >
    <tr>
      <td class='portlet-table-td-left' >
        Upload Picture :
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-left' >
        <input type='file' name='file' size='30' />
      </td>
    </tr>
    <tr>
      <td class='portlet-table-td-right' >
        <input type='submit' value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button' />
      </td>
    </tr>
  </table>
</form>
</c:if>
</light:authenticateUser>
</fmt:bundle>
</body>
</html>