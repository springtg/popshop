<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>			    
	    <light:portalGroup/>
	    <LINK href="<%= request.getContextPath() %>/light/theme/common.css" rel="stylesheet" type="text/css">
	    <LINK href="<%= request.getContextPath() %>/light/theme/<%= (session.getAttribute("theme") != null) ? (String)session.getAttribute("theme") : "theme1"%>/theme.css" rel="stylesheet" type="text/css">	    
	    <%@ include file="/common/meta.jsp"%> 
	     
	    <script language="JavaScript" src="../cache/init/all<%= org.light.portal.util.PropUtil.getString("js.light.version") %>.js"></script>
		<script language="JavaScript" src="../cache/portalGroup/all<%= org.light.portal.util.PropUtil.getString("js.light.version") %>.js"></script>
		
	    <title><c:out value="${sessionScope.visitedGroup.displayName}"/></title>
	</head>
	<body>		 
	    <div id="defaultView">	 
	    	<light:portletsView/> 		 
	  		<jsp:include page="/WEB-INF/view/defaultViews.jsp" flush="true"></jsp:include>  
		</div>
	</body>
</html>