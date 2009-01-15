<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
	<fmt:bundle basename="resourceBundle">
		<table border='0' cellpadding='0' cellspacing='0' width= '100%' >
			<tr valign='top'>
				<td class='portlet-table-td-left' width= '100%' colspan='3'>
					
				</td>
			</tr>
			<c:forEach var="buddy" items="${requestScope.members}" varStatus="status">
				<tr valign='top'>
				    
					<td class='portlet-table-td-left' width= '20%'>
						<c:if test='${buddy.photoUrl == null}'>
							<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.uri}"/>' target='_blank'>
							<img src='<%= request.getContextPath() %><c:out value="${sessionScope.org.defaultMalePortrait}"/>' style='border: 0px;'  align="middle" width='75' height='75'/>
							</a>
						</c:if>
						<c:if test='${buddy.photoUrl != null}'>
							<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.uri}"/>' target='_blank'>
							<img src='<%= request.getContextPath() %><c:out value="${buddy.photoUrl}"/>' style='border: 0px;'  align="middle" width='<c:out value="${buddy.photoSmallWidth}"/>' height='<c:out value="${buddy.photoSmallHeight}"/>'/>
							</a>
						</c:if>
					</td>
					<td class='portlet-table-td-left' width= '60%'>
						<span class='portlet-item'>
						    <c:if test='${buddy.userCurrentStatusId == 1}'>
							<img src="<%= request.getContextPath() %>/light/images/online.gif" style='border: 0px' width='15' height='12' align="bottom" alt=''/>
							</c:if>
							<a href='http://www.<c:out value="${sessionScope.org.space}"/><c:out value="${buddy.uri}"/>' target='_blank' ><c:out value="${buddy.displayName}"/></a>
						</span>
						<br/>
					</td>
					<td class='portlet-table-td-left' width= '20%'>
					</td>					
				</tr>
			</c:forEach>
			<tr valign='top'>			    
				<td class='portlet-table-td-right' width= '80%' colspan='2'>
					<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.back"/>' class='portlet-form-button' />
				</td>
				<td class='portlet-table-td-left' width= '20%'>
				</td>
			</tr>						
		</table>
	</fmt:bundle>
</body>
</html>