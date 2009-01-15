<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>		
	    <%@ include file="/common/meta.jsp"%>    	    
	    <light:portal/>	    
		<LINK href="<%= request.getContextPath() %>/light/theme/common.css" rel="stylesheet" type="text/css">
		<LINK href="<%= request.getContextPath() %>/light/theme/<%= (session.getAttribute("theme") != null) ? (String)session.getAttribute("theme") : "theme1"%>/theme.css" rel="stylesheet" type="text/css">	    
		<title><c:out value="${sessionScope.org.webId}"/> - <%= org.light.portal.util.PropUtil.getString("js.light.version") %></title>
	</head>
	
	<body bgcolor="#FFFFFF"  leftmargin="0" topmargin="0"
			 rightmargin="0" bottommargin="0" marginwidth="0" marginheight="0">
			 <table border="0" cellpadding="0" cellspacing="0" width='90%'>
			 	<thead>
					<tr><th colspan="2" scope="colgroup">
						<tiles:insert attribute="header" flush="false"/>					
					</th></tr>
				</thead>								
				
				<tfoot>
					<tr><td class='portlet-table-td-center' colspan="2">
						<tiles:insert attribute="footer" flush="false"/>
					</td></tr>
				</tfoot>
				
				<tbody>
					<tr>
					<td width='100'><span id="leftMenu">
						<tiles:insert attribute="menu" flush="false"/>
					</span></td>
					
					<td ><span id="pageContext">								
						<img src="<%= request.getContextPath() %>/light/images/spacer.gif" style="border: 0px" width="100" height="20" />				
						<tiles:insert attribute="body" flush="false"/>
					</span></td>
					<td width='80'><span id="rightMenu">
						
					</span></td>
					</tr>
				</tbody>
			</table>
			
	</body>	
</html>  