<%@ include file="/common/taglibs.jsp"%>
<form method="post" action="<portlet:actionURL/>">
<fmt:bundle basename="resourceBundle">
	<table>
        <tr class="portlet-msg-alert">
            <td colspan="2"><%= request.getAttribute("message") != null ?  request.getAttribute("message") : ""%></td>
        </tr>
        <c:if test='${requestScope.urlIsReadOnly == null}'>        
        <tr>
			<td class="portlet-table-td-left">Source URL:</td>
			<td class="portlet-table-td-left"><input type="text" name="url" class='portlet-form-input-field' value="<%= request.getAttribute("iframeUrl") %>" size="32"/></td>
		</tr>
		<input type="hidden" name="urlIsReadOnly" value="0" />
		</c:if>
		<c:if test='${requestScope.urlIsReadOnly != null}'>        
        	<input type="hidden" name="urlIsReadOnly" value="1" />
		</c:if>
		<tr>
		<td class='portlet-table-td-left'>Title:</td>
		<td class='portlet-table-td-left'><input type='text' name='title' class='portlet-form-input-field' value="<%= request.getAttribute("iframeTitle") %>" size="32"/>
		</td>
		</tr>
		<tr>
			<td class="portlet-table-td-left">Width (px or %):</td>
			<td class="portlet-table-td-left"><input type="text" name="width" class='portlet-form-input-field' value="<%= request.getAttribute("iframeWidth") %>"/></td>
		</tr>
        <tr>
			<td class="portlet-table-td-left">Height (px):</td>
			<td class="portlet-table-td-left"><input type="text" name="height" class='portlet-form-input-field' value="<%= request.getAttribute("iframeHeight") %>"/></td>
		</tr>        
		<tr>
			<td class="portlet-table-td-left">Max Height (px or %):</td>
			<td class="portlet-table-td-left"><input type="text" name="maxHeight" class='portlet-form-input-field' value="<%= request.getAttribute("iframeMaxHeight") %>"/></td>
		</tr>
		<tr>
			<td class="portlet-table-td-left">Non IFrame Browser Message:</td>
			<td class="portlet-table-td-left"><input type="text" name="noiframemessage" class='portlet-form-input-field' value="<%= request.getAttribute("iframeMessage") %>" size="32"/></td>
		</tr>
        <tr>
			<td class='portlet-table-td-right' colspan ='2'>
			<input type='submit' name='action' onClick="document.pressed='save';document.mode='view';" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
			<input type='button' name='action' onClick="javascript:Light.executeRender('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
			</td>
        </tr>
    </table>
</fmt:bundle>
</form>