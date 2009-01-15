<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL windowState='MAXIMIZED'><portlet:param name='action' value='find'/></portlet:actionURL>">
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left'>
<b><fmt:message key="portlet.title.findMember"/></b>
</td>
</tr>
<c:if test='${requestScope.members == null}'>
<tr>
<td class='portlet-table-td-left'>
<br/>
<input type='text' name='keyword' class='portlet-form-input-field-hint' size='32' value='' 
	 onchange="javascript:this.form['input'].value='1';this.form.submit();" /> 
<input type='hidden' name='input'  value ='0'/>
<input type='submit' class='portlet-form-button' value='<fmt:message key="portlet.button.go"/>'/>
</td>
</tr>
</c:if>
<c:if test='${requestScope.members != null}'>
<tr>
<td class='portlet-table-td-left'>
<br/>
<c:if test='${sessionScope.criteria != null}'>
<input type='text' name='keyword' class='portlet-form-input-field-hint' size='64' value='<c:out value="${sessionScope.keyword}"/>'
	 onchange="javascript:this.form.submit();" /> 
</c:if>
<c:if test='${sessionScope.criteria == null}'>
<input type='text' name='keyword' class='portlet-form-input-field-hint' size='64' value=''
	 onchange="javascript:this.form.submit();" /> 
</c:if>
</td>
<td class='portlet-table-td-left'>
<br/>
<input type='submit' class='portlet-form-button' value='<fmt:message key="portlet.button.go"/>'/>
<input type='button' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.back"/>' class='portlet-form-button' />
</td>
</tr>
</table>

<c:if test='${requestScope.pages > 1}'>
<table border='0' cellpadding='0' cellspacing='0' width= '95%' >
	<tr valign='top'>
		<td class='portlet-table-td-right' colspan="3">
		(<fmt:message key="portlet.label.Results"/> <c:out value="${requestScope.start }"/> -  <c:out value="${requestScope.end}"/> <fmt:message key="portlet.label.of"/> <c:out value="${sessionScope.gsResult.total}"/>) 
		<span class="portlet-item" > 
		<c:forEach var="i" begin="0" end="${requestScope.pages - 1}" step="1">
		<c:if test='${i != page}'>
		<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','page=<c:out value="${i}"/>');" ><c:out value="${i + 1}"/></a>
		</c:if>
		<c:if test='${i == page}'>
		<label class='currentpage'><c:out value="${i + 1}"/></label>
		</c:if>
		</c:forEach>
		</span>
		</td>
	</tr>
</table>
</c:if>

	<c:forEach var="member" items="${requestScope.members}" varStatus="status">
		
		<div style="margin:0px 20px;padding:5px;" >
		<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
		<tr valign='top'>
			<td class='portlet-table-td-left' width= '20%'>
				<c:if test='${member.photoUrl == null}'>
					<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${member.uri}"/>' target='_blank'>
					<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
					</a>
				</c:if>
				<c:if test='${member.photoUrl != null}'>
					<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${member.uri}"/>' target='_blank'>
					<img src='<%= request.getContextPath() %><c:out value="${member.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${member.photoSmallWidth}"/>' height='<c:out value="${member.photoSmallHeight}"/>'/>
					</a>
				</c:if>				
			</td>
			<td class='portlet-table-td-left' width= '50%'>
				<span class="portlet-rss" > 
				<fmt:message key="portlet.label.name"/>: 
				<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${member.uri}"/>' target='_blank'>
					<c:out value="${member.name}"/>
				</a>
				</span>
			</td>
			<td class='portlet-table-td-left' width= '30%'>
			<span class="portlet-rss" > 
			<a href='javascript:void(0)' onclick="javascript:Light.showSendMessage(event,'<c:out value="${requestScope.responseId}"/>','<c:out value="${member.userId}"/>','<c:out value="${member.name}"/>');" ><img src='<%= request.getContextPath() %>/light/images/inbox.gif' style='border: 0px;' height='16' width='16' align="top"/><fmt:message key="portlet.label.sendMessage"/></a>
			<br/>
			<a href='javascript:void(0)' onclick="javascript:Light.showAddToFriend(event,'<c:out value="${requestScope.responseId}"/>','<c:out value="${member.userId}"/>','<c:out value="${member.name}"/>');" ><img src='<%= request.getContextPath() %>/light/images/newFriend.gif' style='border: 0px;' height='16' width='16' align="top"/><fmt:message key="portlet.label.addToFriend"/></a>			
			</span>
			</td>								
		</tr>
		<tr valign='top'>
			<td class='portlet-table-td-left' colspan="3">
			<hr/>
			</td>
		</tr>	
		</table>
		</div>

	</c:forEach>	
	<div style="margin:0px 20px;" >
		<table border='0' cellpadding='0' cellspacing='0' width= '100%' >		
		<c:if test='${requestScope.pages > 1}'>
		<tr valign='top'>
			<td class='portlet-table-td-right' colspan="3">
			<span class="portlet-item" > 
			<c:forEach var="i" begin="0" end="${requestScope.pages - 1}" step="1">
			<c:if test='${i != page}'>
			<a href='javascript:void(0)' onclick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','','maximized','page=<c:out value="${i}"/>');" ><c:out value="${i + 1}"/></a>
			</c:if>
			<c:if test='${i == page}'>
			<label class='currentpage'><c:out value="${i + 1}"/></label>
			</c:if>
			</c:forEach>
			</span>
			</td>
		</tr>
		</c:if>
		<tr valign='top'>
			<td class='portlet-table-td-right' colspan="3">
			<fmt:message key="portlet.label.total"/> <c:out value="${sessionScope.usResult.total}"/> <fmt:message key="portlet.label.results"/>.
			</td>
		</tr>			
		</table>
	</div>
</c:if>
</form>
</fmt:bundle>
</body>
</html>