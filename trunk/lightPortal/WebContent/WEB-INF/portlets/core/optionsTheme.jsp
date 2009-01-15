<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="optionsHeader.jsp" ></jsp:include>
<br/>
<fmt:bundle basename="resourceBundle">
<br/>
<br/>
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-table-td-left' colspan='5'>
<fmt:message key="portlet.label.theme"/>:
</td>
</tr>
<tr>
<c:forEach var="theme" items="${requestScope.themes}" varStatus="status">
<td class='portlet-table-td-center'>
<a href="javascript:void(0);">
<img src='<%= request.getContextPath() %>/light/theme/<c:out value="${theme.id}"/>/images/theme.gif' height='75' style='border: 0px' width='75' alt=''
onmousedown="javascript:Light.showTheme(event,'/light/theme/<c:out value="${theme.id}"/>/images/theme.gif','<fmt:message key="portlet.label.theme1"/>','<c:out value="${requestScope.responseId}"/>');"
onmouseup="javascript:Light.hideTheme();" 
/></a>
<br/>
<c:out value="${theme.desc}"/>
<br/>
<input type='radio' name='ptTheme' value='<c:out value="${theme.id}"/>' class='portlet-form-radio' onclick="javascript:Light.selectTheme('<c:out value="${theme.id}"/>');" 
<c:if test="${requestScope.portal.theme == theme.id}"> 
checked='true'
</c:if>
/>
</td>
</c:forEach>
</tr>
</table>
<br/>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left' colspan='3'>
<fmt:message key="portlet.label.bgImage"/>:
<span height='20' width='100' style='' >Repeat</span>
<c:if test="${requestScope.portal.bgRepeat != 0}"> 
<input type='radio' name='ptRepeat' value='0' />
</c:if>
<c:if test="${requestScope.portal.bgRepeat == 0}"> 
<input type='radio' name='ptRepeat' value='0' checked='true' />
</c:if>
<span height='20' width='100' style='' >No Repeat</span>
<c:if test="${requestScope.portal.bgRepeat != 1}"> 
<input type='radio' name='ptRepeat' value='1' />
</c:if>
<c:if test="${requestScope.portal.bgRepeat == 1}"> 
<input type='radio' name='ptRepeat' value='1' checked='true' />
</c:if>
<span height='20' width='100' style='' >Repeat X</span>
<c:if test="${requestScope.portal.bgRepeat != 2}"> 
<input type='radio' name='ptRepeat' value='2' />
</c:if>
<c:if test="${requestScope.portal.bgRepeat == 2}"> 
<input type='radio' name='ptRepeat' value='2' checked='true' />
</c:if>
<span height='20' width='100' style='' >Repeat Y</span>
<c:if test="${requestScope.portal.bgRepeat != 3}"> 
<input type='radio' name='ptRepeat' value='3' />
</c:if>
<c:if test="${requestScope.portal.bgRepeat == 3}"> 
<input type='radio' name='ptRepeat' value='3' checked='true' />
</c:if>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<span height='20' width='100' style='' >Default</span>
<c:if test="${requestScope.portal.bgImage != ''}"> 
<input type='radio' name='ptBg' value='' />
</c:if>
<c:if test="${requestScope.portal.bgImage == ''}"> 
<input type='radio' name='ptBg' value='' checked='true' />
</c:if>
</td>	
<td class='portlet-table-td-left'>
<span height='20' width='100' style='' >No Image</span>
<c:if test="${requestScope.portal.bgImage != 'no'}"> 
<input type='radio' name='ptBg' value='no' />
</c:if>
<c:if test="${requestScope.portal.bgImage == 'no'}"> 
<input type='radio' name='ptBg' value='no' checked='true' />
</c:if>
</td>
<td class='portlet-table-td-left'>
<span height='20' width='100' style='' >
<a href="javascript:void(0);" onclick="javascript:Light.showMoreBgImage(event,'<c:out value="${requestScope.responseId}"/>');">More Images</a>
<c:if test="${requestScope.portal.bgImage == 'no' || requestScope.portal.bgImage == ''}"> 
<input type='radio' name='ptBg' value='more' />
</c:if>
<c:if test="${requestScope.portal.bgImage != 'no' && requestScope.portal.bgImage != ''}"> 
<input type='radio' name='ptBg' value='more' checked='true'/>
</c:if>
</span>
</td>		
</tr>
</table>
<br/>
<br/>
<table border='0' cellpadding='0' cellspacing='0'>

<tr>
<td class='portlet-table-td-left' colspan='3'>
<fmt:message key="portlet.label.headerImage"/>:
<span height='20' width='100' style='' >Repeat</span>
<c:if test="${requestScope.portal.headerRepeat != 0}"> 
<input type='radio' name='ptHeaderRepeat' value='0' />
</c:if>
<c:if test="${requestScope.portal.headerRepeat == 0}"> 
<input type='radio' name='ptHeaderRepeat' value='0' checked='true' />
</c:if>
<span height='20' width='100' style='' >No Repeat</span>
<c:if test="${requestScope.portal.headerRepeat != 1}"> 
<input type='radio' name='ptHeaderRepeat' value='1' />
</c:if>
<c:if test="${requestScope.portal.headerRepeat == 1}"> 
<input type='radio' name='ptHeaderRepeat' value='1' checked='true' />
</c:if>
<span height='20' width='100' style='' >Repeat X</span>
<c:if test="${requestScope.portal.headerRepeat != 2}"> 
<input type='radio' name='ptHeaderRepeat' value='2' />
</c:if>
<c:if test="${requestScope.portal.headerRepeat == 2}"> 
<input type='radio' name='ptHeaderRepeat' value='2' checked='true' />
</c:if>
<span height='20' width='100' style='' >Repeat Y</span>
<c:if test="${requestScope.portal.headerRepeat != 3}"> 
<input type='radio' name='ptHeaderRepeat' value='3' />
</c:if>
<c:if test="${requestScope.portal.headerRepeat == 3}"> 
<input type='radio' name='ptHeaderRepeat' value='3' checked='true' />
</c:if>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<span height='20' width='100' style='' >Default</span>
<c:if test="${requestScope.portal.headerImage != ''}"> 
<input type='radio' name='ptHeader' value='' />
</c:if>
<c:if test="${requestScope.portal.headerImage == ''}"> 
<input type='radio' name='ptHeader' value='' checked='true' />
</c:if>
</td>	
<td class='portlet-table-td-left'>
<span height='20' width='100' style='' >No Image</span>
<c:if test="${requestScope.portal.headerImage != 'no'}"> 
<input type='radio' name='ptHeader' value='no' />
</c:if>
<c:if test="${requestScope.portal.headerImage == 'no'}"> 
<input type='radio' name='ptHeader' value='no' checked='true' />
</c:if>
</td>	
<td class='portlet-table-td-left'>
<span height='20' width='100' style='' >
<a href="javascript:void(0);" onclick="javascript:Light.showMoreHeaderImage(event,'<c:out value="${requestScope.responseId}"/>');">More Images</a>
<c:if test="${requestScope.portal.headerImage == 'no' || requestScope.portal.headerImage == ''}"> 
<input type='radio' name='ptHeader' value='more' />
</c:if>
<c:if test="${requestScope.portal.headerImage != 'no' && requestScope.portal.headerImage != ''}"> 
<input type='radio' name='ptHeader' value='more' checked='true'/>
</c:if>
</span>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='3'>
<input type='checkbox' name='transparent' value='<c:out value="${requestScope.portal.transparent}"/>' class='portlet-form-checkbox'
<c:if test='${requestScope.portal.transparent == 1}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.transparent"/></input> 
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-table-td-right'>
<input name='Save' type='button' value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button'
 onclick="javascript:Light.saveTheme('<c:out value="${requestScope.responseId}"/>',true);" />
<input name='Cancel' type='button' value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button'
 onclick="javascript:Light.closePortlet('<c:out value="${requestScope.responseId}"/>');" />
<input name='Save' type='button' value='<fmt:message key="portlet.button.apply"/>' class='portlet-form-button'
 onclick="javascript:Light.saveTheme('<c:out value="${requestScope.responseId}"/>',false);" />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>