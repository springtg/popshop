<%@ include file="/common/taglibs.jsp"%>
<table border="0" cellpadding="0" cellspacing="0" width='99%'>
<tbody>
<tr>
<td class="portlet-table-td-left">
<c:if test='${sessionScope.org.logoUrl != null}'>
<img src='<c:out value="${sessionScope.org.logoUrl}"/>'style='border: 0px;'/></td>
</c:if>
<c:if test='${sessionScope.org.logoUrl == null}'>
<img src='<%= request.getContextPath() %>/light/images/logo.png'style='border: 0px;'/></td>
</c:if>
<td class="portlet-link">
<a href="index.jsp">Home</a>  
<br/>
<light:authenticateUser> 
Welcome&nbsp;<c:out value="${sessionScope.user.displayName}"/>
</light:authenticateUser>             
<br/>
</td>
</tr>
<tr>
<td class="portal-header-title" style='text-align: center;'></td>
</tr>
</tbody>
</table>
