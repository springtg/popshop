<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<script language="JavaScript">

  keyDownYouTube  = function (e, id) {  
	  var KeyID;
	  if (window.event) {	
		keyID = window.event.keyCode;
	  } else {
	    keyID = e.which;
	  } 
	  if ( keyID == 13){   
	    submitYouTube(id);    
	  }
	  return !(keyID == 13);
  }
  
  submitYouTube = function (id){
 	var key = document.forms['form_'+id]['tag'].value; 
 	Light.executeAction(id,'','','','','','','action=search;tag='+key);
  } 

</script>
<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>" >
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left'>
<img src='<%= request.getContextPath() %>/light/images/youtube.png' style='border: 0px;'  align="middle" />
<input type='text' name='tag' class='portlet-form-input-field' size='50'
	 onkeypress="return keyDownYouTube(event,'<c:out value="${requestScope.responseId}"/>');"/> 
<input name='Submit' type='button' class='portlet-form-button' value='<fmt:message key="portlet.button.go"/>' 
	 onclick="javascript:submitYouTube('<c:out value="${requestScope.responseId}"/>');" />
<a href="javascript:void(0);" title='<fmt:message key="portlet.label.mostFeatured"/>' onClick="javascript:Light.executeAction('<c:out value="${requestScope.responseId}"/>','','','','','','','action=featured');"><img src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16'/></a> 	 
</td>
</td>
</tr>
</table>
</form>
<c:if test='${sessionScope.youTubes != null}'>
<table border='0' cellpadding='0' cellspacing='0' width= '95%' >
<c:forEach var="video" items="${sessionScope.youTubes}" varStatus="status">
<c:if test='${status.index % 4 == 0}'>
<tr class='portlet-table-td-left'>
</c:if>
<td class='portlet-item'>
<light:authenticateUser>  
<input type="image" title='<fmt:message key="portlet.label.popItem"/>' src="<%= request.getContextPath() %>/light/images/popular.gif" style='border: 0px;' height='16' width='16' onClick="javascript:popYouTubeItem(event,'<c:out value="${video.id}"/>','<c:out value="${requestScope.responseId}"/>');"/>
<input type="image" title='<fmt:message key="portlet.label.forwardItem"/>' src="<%= request.getContextPath() %>/light/images/forward.gif" style='border: 0px;' height='16' width='16' onClick="javascript:forwardYouTubeToFriend(event,'<c:out value="${video.id}"/>','<c:out value="${requestScope.responseId}"/>');"/>
</light:authenticateUser>
<input type="image" title='<fmt:message key="portlet.label.saveBookmark"/>' src="<%= request.getContextPath() %>/light/images/bookmark.gif" style='border: 0px;' height='16' width='16' onClick="javascript:saveYouTubeToBookmark(event,'<c:out value="${video.id}"/>','<c:out value="${requestScope.responseId}"/>');"/>
<c:out value="${video.title}"/>
<br/>
<fmt:message key="portlet.label.author"/>: 
<a href='javascript:void(0)' onclick="javascript:Light.executeAction('<c:out value="${requestScope.responseId}"/>','','','','','','','action=author;author=<c:out value="${video.author}"/>');">
<c:out value="${video.author}"/>
</a>
<br/>
<span >
<a href='<c:out value="${video.videoUrl}"/>' title='<c:out value="${video.desc}"/>' target='_blank'><img src='<c:out value="${video.picUrl}" />' style='border: 0px;'  align="middle" /></a>
</span>
</td>
<c:if test='${status.index % 4 == 3}'>
</tr>
</c:if>
</c:forEach>
<c:if test='${requestScope.videosCount % 4 != 0}'>
</tr>
</c:if>
</table>
</c:if>
<br/>
<br/>
</fmt:bundle>
</body>
</html>