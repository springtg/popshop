<%@ include file="/common/taglibs.jsp"%>

<table width="<%= request.getAttribute("iframeWidth") %>">    
    <tr>
        <td>
        	<c:if test='${requestScope.state == "normal"}'>
            <iframe src="<%= request.getAttribute("iframeUrl") %>" width="<%= request.getAttribute("iframeWidth") %>" height="<%= request.getAttribute("iframeHeight") %>" frameborder="0">
	            Your browser does not support iframes
            </iframe>
            </c:if>
            <c:if test='${requestScope.state == "maximized"}'>
            <iframe src="<%= request.getAttribute("iframeUrl") %>" width="<%= request.getAttribute("iframeWidth") %>" height="<%= request.getAttribute("iframeMaxHeight") %>" frameborder="0">
	            Your browser does not support iframes
            </iframe>
            </c:if>
        </td>
    </tr>
</table>