<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL windowState='MAXIMIZED'><portlet:param name='action' value='find'/></portlet:actionURL>">
<div style="margin:0px 20px;padding:5px;" >
<table border='0' cellpadding='0' cellspacing='0'>
	<tr>
	<td class='portlet-table-td-left'>
	<br/>
	<select name='type' size='1' class='portlet-form-select'>
	<c:forEach var="bean" items="${sessionScope.searchTypes}" >
	<option value='<c:out value="${bean.id}"/>'
	<c:if test='${bean.defaulted == true}'>
	selected="selected"
	</c:if>
	><c:out value="${bean.desc}"/></option>
	</c:forEach>
	</select>
	<c:if test='${sessionScope.criteria != null}'>
		<input type='text' name='keyword' class='portlet-form-input-field' size='64' value='<c:out value="${sessionScope.criteria.keyword}"/>'
		 onchange="javascript:this.form.submit();" /> 
	</c:if>
	<c:if test='${sessionScope.criteria == null}'>
		<input type='text' name='keyword' class='portlet-form-input-field' size='64' value=''
		 onchange="javascript:this.form.submit();" /> 
	</c:if>
	</td>
	<td class='portlet-table-td-left'>
	<br/>
	<input type='submit' class='portlet-form-button' value='<fmt:message key="portlet.button.go"/>'/>
	<input type='button' onClick="javascript:Light.closePortlet('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.close"/>' class='portlet-form-button' />
	</td>
	</tr>
</table>
</div>
<c:if test='${requestScope.items != null}'>			
	<c:if test='${requestScope.pages <= 1}'>
	<br/>
	</c:if>
	<c:if test='${requestScope.pages > 1}'>
	<div style="margin:0px 20px;" >
	<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
	<tr valign='top'>
			<td class='portlet-table-td-right' colspan="3">
			(<fmt:message key="portlet.label.Results"/> <c:out value="${requestScope.start }"/> -  <c:out value="${requestScope.end}"/> <fmt:message key="portlet.label.of"/> <c:out value="${sessionScope.gsResult.total}"/>) 
			<span class="portlet-item" > 
			<c:if test='${page > 0}'>
			<a href='javascript:void(0);' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','page=<c:out value="${requestScope.page - 1}"/>');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.label.previous"/>'/></a>						
			</c:if>
			<c:forEach var="i" begin="0" end="${requestScope.pages - 1}" step="1">
			<c:if test='${i != page}'>
			<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','page=<c:out value="${i}"/>');" ><c:out value="${i + 1}"/></a>
			</c:if>
			<c:if test='${i == page}'>
			<label class='currentpage'><c:out value="${i + 1}"/></label>
			</c:if>
			</c:forEach>
			<c:if test='${page < pages - 1}'>
			<a href='javascript:void(0);' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','page=<c:out value="${requestScope.page + 1}"/>');"><img src='<%= request.getContextPath() %>/light/images/next.gif' style='border: 0px' title='<fmt:message key="portlet.label.next"/>'/></a>						
			</c:if>
			</span>
			</td>
		</tr>
	</table>
	</div>
	</c:if>
	<div style="margin:0px 20px;padding:5px;" >
	<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
	<c:forEach var="item" items="${requestScope.items}" varStatus="status">
		<tr valign='top'>
			<td class='portlet-table-td-left' width= '20%'>
				<c:if test='${item.photoUrl == null}'>
					<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${item.uri}"/>' target='_blank'>
					<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
					</a>
				</c:if>
				<c:if test='${item.photoUrl != null}'>
					<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${item.uri}"/>' target='_blank'>
					<img src='<%= request.getContextPath() %><c:out value="${item.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${item.photoSmallWidth / 2}"/>' height='<c:out value="${item.photoSmallHeight / 2}"/>'/>
					</a>
				</c:if>				
			</td>
			<td class='portlet-table-td-left' width= '20%'>
				<span class="portlet-rss" > 
				<fmt:message key="portlet.label.name"/>: 
				<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${item.uri}"/>' target='_blank'>
					<c:out value="${item.name}"/>
				</a>
				</span>
			</td>
			<td class='portlet-table-td-left' width= '40%'>
				<c:if test='${item.showDetail == true}'>
				<span class="portlet-rss" > 
				<c:out value="${item.type}"/>: 
				<a href='<c:out value="${item.link}"/>' target='_blank'>
					<c:out value="${item.detail}" escapeXml="false"/>
				</a>
				</span>
				</c:if>
			</td>
			<td class='portlet-table-td-left' width= '20%'>
			<span class="portlet-rss" > 
			<a href='javascript:void(0)' onclick="javascript:Light.showSendMessage(event,'<c:out value="${requestScope.responseId}"/>','<c:out value="${item.userId}"/>','<c:out value="${item.name}"/>');" ><img src='<%= request.getContextPath() %>/light/images/inbox.gif' style='border: 0px;' height='16' width='16' align="top"/><fmt:message key="portlet.label.sendMessage"/></a>
			<br/>
			<a href='javascript:void(0)' onclick="javascript:Light.showAddToFriend(event,'<c:out value="${requestScope.responseId}"/>','<c:out value="${item.userId}"/>','<c:out value="${item.name}"/>');" ><img src='<%= request.getContextPath() %>/light/images/newFriend.gif' style='border: 0px;' height='16' width='16' align="top"/><fmt:message key="portlet.label.addToFriend"/></a>			
			</span>
			</td>								
		</tr>
		<tr valign='top'>
			<td class='portlet-table-td-left' colspan="4">
			<hr/>
			</td>
		</tr>	
		</c:forEach>
	</table>
	</div>
		
	<div style="margin:0px 20px;" >
		<table border='0' cellpadding='0' cellspacing='0' width= '98%' >		
		<c:if test='${requestScope.pages > 1}'>
		<tr valign='top'>
			<td class='portlet-table-td-right' colspan="3">
			<span class="portlet-item" > 
			<c:if test='${page > 0}'>
			<a href='javascript:void(0);' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','page=<c:out value="${requestScope.page - 1}"/>');"><img src='<%= request.getContextPath() %>/light/images/previous.gif' style='border: 0px' title='<fmt:message key="portlet.label.previous"/>'/></a>						
			</c:if>
			<c:forEach var="i" begin="0" end="${requestScope.pages - 1}" step="1">
			<c:if test='${i != page}'>
			<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','page=<c:out value="${i}"/>');" ><c:out value="${i + 1}"/></a>
			</c:if>
			<c:if test='${i == page}'>
			<label class='currentpage'><c:out value="${i + 1}"/></label>
			</c:if>
			</c:forEach>
			<c:if test='${page < pages - 1}'>
			<a href='javascript:void(0);' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','page=<c:out value="${requestScope.page + 1}"/>');"><img src='<%= request.getContextPath() %>/light/images/next.gif' style='border: 0px' title='<fmt:message key="portlet.label.next"/>'/></a>						
			</c:if>
			</span>
			</td>
		</tr>
		</c:if>
		<tr valign='top'>
			<td class='portlet-table-td-right' colspan="3">
			<fmt:message key="portlet.label.total"/> <c:out value="${sessionScope.gsResult.total}"/> <fmt:message key="portlet.label.results"/>.
			</td>
		</tr>			
		</table>
	</div>
</c:if>
</form>
</fmt:bundle>
</body>
</html>