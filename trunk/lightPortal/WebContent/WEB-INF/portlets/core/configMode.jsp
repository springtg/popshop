<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>" action="<portlet:actionURL portletMode='VIEW'/>">
<table border='0' cellpadding='0' cellspacing='0' width="95%" >
<tr>
<td class='portlet-table-td-left' width="50%"><fmt:message key="portlet.label.title"/>:
</td>
<td class='portlet-table-td-left'>
<input type='text' name='pcTitle' value='<c:out value="${requestScope.portlet.title}"/>' class='portlet-form-input-field' size='16' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.titleBgColor"/>:
</td>
<td class='portlet-table-td-left'>
<c:if test="${requestScope.portlet.barBgColor != null}">
<input type='text' name='pcBarBgColor' value='<c:out value="${requestScope.portlet.barBgColor}"/>' class='portlet-form-input-field-color' size='10' style='color:<c:out value="${requestScope.portlet.barBgColor}"/>;background:<c:out value="${requestScope.portlet.barBgColor}"/>;'/>
<input name='pick' type='button' value='...' class='portlet-form-button'
 onclick="javascript:pickColor(event,'<c:out value="${requestScope.responseId}"/>',1);" />
</c:if>
<c:if test="${requestScope.portlet.barBgColor == null}">
<input type='text' name='pcBarBgColor' value='<c:out value="${requestScope.portlet.barBgColor}"/>' class='portlet-form-input-field-color' size='10'/>
<input name='pick' type='button' value='...' class='portlet-form-button'
 onclick="javascript:pickColor(event,'<c:out value="${requestScope.responseId}"/>',1);" />
</c:if>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.titleColor"/>:
</td>
<td class='portlet-table-td-left'>
<c:if test="${requestScope.portlet.barBgColor != null && requestScope.portlet.barFontColor != null}">
<input type='text' name='pcBarFontColor' value='<c:out value="${requestScope.portlet.barFontColor}"/>' class='portlet-form-input-field-color' size='10' style='color:<c:out value="${requestScope.portlet.barFontColor}"/>;background:<c:out value="${requestScope.portlet.barBgColor}"/>;'/>
<input name='pick' type='button' value='...' class='portlet-form-button'
 onclick="javascript:pickColor(event,'<c:out value="${requestScope.responseId}"/>',2);" />
</c:if>
<c:if test="${requestScope.portlet.barBgColor != null && requestScope.portlet.barFontColor == null}">
<input type='text' name='pcBarFontColor' value='<c:out value="${requestScope.portlet.barFontColor}"/>' class='portlet-form-input-field-color' size='10' style='background:<c:out value="${requestScope.portlet.barBgColor}"/>;'/>
<input name='pick' type='button' value='...' class='portlet-form-button'
 onclick="javascript:pickColor(event,'<c:out value="${requestScope.responseId}"/>',2);" />
</c:if>
<c:if test="${requestScope.portlet.barBgColor == null && requestScope.portlet.barFontColor != null}">
<input type='text' name='pcBarFontColor' value='<c:out value="${requestScope.portlet.barFontColor}"/>' class='portlet-form-input-field-color' size='10' style='color:<c:out value="${requestScope.portlet.barFontColor}"/>;'/>
<input name='pick' type='button' value='...' class='portlet-form-button'
 onclick="javascript:pickColor(event,'<c:out value="${requestScope.responseId}"/>',2);" />
</c:if>
<c:if test="${requestScope.portlet.barBgColor == null && requestScope.portlet.barFontColor == null}">
<input type='text' name='pcBarFontColor' value='<c:out value="${requestScope.portlet.barFontColor}"/>' class='portlet-form-input-field-color' size='10'/>
<input name='pick' type='button' value='...' class='portlet-form-button'
 onclick="javascript:pickColor(event,'<c:out value="${requestScope.responseId}"/>',2);" />
</c:if>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.contentBgColor"/>:
</td>
<td class='portlet-table-td-left'>
<c:if test="${requestScope.portlet.contentBgColor != null}">
<input type='text' name='pcContentBgColor' value='<c:out value="${requestScope.portlet.contentBgColor}"/>' class='portlet-form-input-field' size='10' style='color:<c:out value="${requestScope.portlet.contentBgColor}"/>;background:<c:out value="${requestScope.portlet.contentBgColor}"/>;'/>
<input name='pick' type='button' value='...' class='portlet-form-button'
 onclick="javascript:pickColor(event,'<c:out value="${requestScope.responseId}"/>',3);" />
</c:if>
<c:if test="${requestScope.portlet.contentBgColor == null}">
<input type='text' name='pcContentBgColor' value='<c:out value="${requestScope.portlet.contentBgColor}"/>' class='portlet-form-input-field' size='10'/>
<input name='pick' type='button' value='...' class='portlet-form-button'
 onclick="javascript:pickColor(event,'<c:out value="${requestScope.responseId}"/>',3);" />
</c:if>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.textColor"/>:
</td>
<td class='portlet-table-td-left'>
<c:if test="${requestScope.portlet.textColor != null}">
<input type='text' name='pcTextColor' value='<c:out value="${requestScope.portlet.textColor}"/>' class='portlet-form-input-field' size='10' style='color:<c:out value="${requestScope.portlet.textColor}"/>;background:<c:out value="${requestScope.portlet.contentBgColor}"/>;'/>
<input name='pick' type='button' value='...' class='portlet-form-button'
 onclick="javascript:pickColor(event,'<c:out value="${requestScope.responseId}"/>',4);" />
</c:if>
<c:if test="${requestScope.portlet.textColor == null}">
<input type='text' name='pcTextColor' value='<c:out value="${requestScope.portlet.textColor}"/>' class='portlet-form-input-field' size='10' style='background:<c:out value="${requestScope.portlet.contentBgColor}"/>;'/>
<input name='pick' type='button' value='...' class='portlet-form-button'
 onclick="javascript:pickColor(event,'<c:out value="${requestScope.responseId}"/>',4);" />
</c:if>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<input type='checkbox' name='transparent' value='<c:out value="${requestScope.portlet.transparent}"/>' class='portlet-form-checkbox'
<c:if test='${requestScope.portlet.transparent == 1}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.transparentPortlet"/></input> 
</td>
</tr>
<tr>
<td class='cright' colspan='2'>
<input name='save' type='button' value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button'
 onclick="javascript:configPortlet('<c:out value="${requestScope.responseId}"/>');" />
<input name='default' type='button' value='<fmt:message key="portlet.button.default"/>' class='portlet-form-button'
 onclick="javascript:defaultConfigPortlet('<c:out value="${requestScope.responseId}"/>');" />
<input type='submit' name='action' onClick="document.pressed='cancel';document.mode='view';" value='<fmt:message key="portlet.button.close"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>