<%@ include file="/common/taglibs.jsp"%>
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
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</table>
</c:if>

<table border='0' cellpadding='0' cellspacing='0'  width='98%'>
<tr>	
	<td class='portlet-table-td-right'>
	<input type="image" title='<fmt:message key="portlet.button.back"/>' src="<%= request.getContextPath() %>/light/images/exit.gif" style='border: 0px;margin:10px;' height='16' width='16' name="<c:out value='${item.index}'/>" onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');"/>
    </td>
</tr>
</table>

<table width="100%">    
    <tr>
        <td>        	
            <iframe src="<c:out value="${url}"/>" width="100%" height="500" frameborder="0">
	            Your browser does not support iframes
            </iframe>
        </td>
    </tr>
</table>
</fmt:bundle>