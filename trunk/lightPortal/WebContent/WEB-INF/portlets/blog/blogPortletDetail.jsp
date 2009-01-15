<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<table border='0' cellpadding='0' cellspacing='0' width='95%' > 
<tr> 
<td class='portlet-table-td-left'> 
<b><c:out value="${blog.title}"/></b> 
</td> 
<td class='portlet-link' >
<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','','');" ><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.button.back"/>'/></a>
</td>
</tr> 
<tr> 
<td class='portlet-table-td-left' colspan='2'> 
<span class="portlet-rss"> 					
<fmt:message key="portlet.label.postedBy"/>: <a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${blog.uri}"/>' target='_blank'><c:out value="${blog.displayName}"/></a> <fmt:message key="portlet.label.date"/>: <c:out value="${blog.fullDate}"/>
<br/> 
<br/> 
</span> 
</td> 					
</tr> 
<c:if test='${blog.commentCount > 0 }'>
<tr> 
 <td class='portlet-table-td-right'> 
 <span class="portlet-link"> 	
 <a href='javascript:void(0);' onclick="javascript:showBlogComment(event,'<c:out value="${blog.id}"/>');"><fmt:message key="portlet.label.total"/> <c:out value="${blog.commentCount}"/> <fmt:message key="portlet.label.comments"/></a> 
 </span> 
 </td> 
</tr> 
</c:if>

<tr> 
<td class='portlet-table-td-left'> 
<span>
<c:out value="${blog.summary}" escapeXml="false"/>
</span> 
<br/><br/><br/>
</td> 
</tr> 

<tr> 
<td class='portlet-table-td-left'> 
<span>
<c:out value="${blog.content}" escapeXml="false"/>
</span> 
</td> 
</tr> 
<c:if test='${blog.commentCount > 0 }'>
<tr> 
 <td class='portlet-table-td-right'> 
 <span class="portlet-link"> 	
 <a href='javascript:void(0);' onclick="javascript:showBlogComment(event,'<c:out value="${blog.id}"/>');"><fmt:message key="portlet.label.total"/> <c:out value="${blog.commentCount}"/> <fmt:message key="portlet.label.comments"/></a> 
 </span> 
 </td> 
</tr> 
</c:if>
<tr> 
<td class='portlet-table-td-right'> 
<input type='button' value='<fmt:message key="portlet.button.addComment"/>'
 onclick="javascript:addBlogComment(event,'<c:out value="${blog.id}"/>','<c:out value="${requestScope.responseId}"/>');" class='portlet-form-button'/>
<input type='button' value='<fmt:message key="portlet.button.popIt"/>'
 onclick="javascript:popBlog('<c:out value="${blog.id}"/>','<c:out value="${requestScope.responseId}"/>');" class='portlet-form-button'/>
<input type='button' value='<fmt:message key="portlet.button.back"/>'
 onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" class='portlet-form-button'/>

</td>
</tr>		  
</table>
</fmt:bundle>
</body>
</html>
