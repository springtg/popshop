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
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<input type='checkbox' name='showSearchBar' value='<c:out value="${requestScope.portal.showSearchBar}"/>' class='portlet-form-checkbox'
<c:if test='${requestScope.portal.showSearchBar == 1}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.showSearchBar"/></input> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left' colspan='2'>
<input type='checkbox' name='transparent' value='<c:out value="${requestScope.portal.transparent}"/>' class='portlet-form-checkbox'
<c:if test='${requestScope.portal.transparent == 1}'>
checked="checked"
</c:if>
>
<fmt:message key="portlet.label.transparent"/></input> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.textFont"/>:
</td>
<td class='portlet-table-td-left'>
<select name='pcTextFontSelect' size='1' class='portlet-form-select' style="width:100px;" onchange="javascript:this.form['pcTextFont'].value='';">
<c:forEach var="font" items="${requestScope.fonts}">
<option value='<c:out value="${font}"/>' style='font-family:<c:out value="${font}"/>;'
<c:if test='${requestScope.portal.textFont == font}'>
selected='selected'
</c:if>
><c:out value="${font}"/></option>
</c:forEach>
</select>
<fmt:message key="portlet.label.or"/>
<input type='text' name='pcTextFont' value='<c:out value="${requestScope.portal.textFont}"/>' style='font-family:<c:out value="${requestScope.portal.textFont}"/>' class='portlet-form-input-field' size='10' style=''/>
</td>
</tr>
<tr>
<td class='portlet-table-td-left'><fmt:message key="portlet.label.textColor"/>:
</td>
<td class='portlet-table-td-left'>
<div class='color-block' style='background-color:red;' onclick="javascript:Light.setTextColor('<c:out value="${requestScope.responseId}"/>','red');"> </div>
<div class='color-block' style='background-color:orange;' onclick="javascript:Light.setTextColor('<c:out value="${requestScope.responseId}"/>','orange');"> </div>
<div class='color-block' style='background-color:yellow;' onclick="javascript:Light.setTextColor('<c:out value="${requestScope.responseId}"/>','yellow');"> </div>
<div class='color-block' style='background-color:green;' onclick="javascript:Light.setTextColor('<c:out value="${requestScope.responseId}"/>','green');"> </div>
<div class='color-block' style='background-color:blue;' onclick="javascript:Light.setTextColor('<c:out value="${requestScope.responseId}"/>','blue');"> </div>
<div class='color-block' style='background-color:black;' onclick="javascript:Light.setTextColor('<c:out value="${requestScope.responseId}"/>','black');"> </div>
<div class='color-block' style='background-color:white;' onclick="javascript:Light.setTextColor('<c:out value="${requestScope.responseId}"/>','white');"> </div>
<div class='color-input'>
<fmt:message key="portlet.label.or"/>
<input type='text' name='pcTextColor' value='<c:out value="${requestScope.portal.textColor}"/>' class='portlet-form-input-field' size='10' style='color:<c:out value="${requestScope.portal.textColor}"/>;'/>
</div>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' >
<fmt:message key="portlet.label.fontSize"/>:
</td>
<td class='portlet-table-td-left'>
<select name='ptFontSize' size='1' class='portlet-form-select' style="width:100px;">
<c:forEach var="fontSize" items="${requestScope.fontSizes}">
<option value='<c:out value="${fontSize.id}"/>' 
<c:if test='${requestScope.portal.fontSize == fontSize.id}'>
selected='selected'
</c:if>
><c:out value="${fontSize.desc}"/></option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' >
<fmt:message key="portlet.label.headerHeight"/>:
</td>
<td class='portlet-table-td-left'>
<select name='ptHeaderHeight' size='1' class='portlet-form-select' style="width:100px;">
<c:forEach var="headerHeight" items="${requestScope.headerHeights}">
<option value='<c:out value="${headerHeight.id}"/>' 
<c:if test='${requestScope.portal.headerHeight == headerHeight.id}'>
selected='selected'
</c:if>
><c:out value="${headerHeight.desc}"/></option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-left' >
<fmt:message key="portlet.label.maxShowTabs"/>:
</td>
<td class='portlet-table-td-left'>
<select name='ptMaxShowTabs' size='1' class='portlet-form-select' style="width:100px;">
<c:forEach var="number" items="${requestScope.maxShowTabsNumber}">
<option value='<c:out value="${number}"/>' 
<c:if test='${requestScope.portal.maxShowTabs == number}'>
selected='selected'
</c:if>
><c:out value="${number}"/></option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2'>
<input name='Save' type='button' value='<fmt:message key="portlet.button.ok"/>' class='portlet-form-button'
 onclick="javascript:Light.saveGeneral('<c:out value="${requestScope.responseId}"/>');Light.closePortlet('<c:out value="${requestScope.responseId}"/>');" />
<input name='Cancel' type='button' value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button'
 onclick="javascript:Light.closePortlet('<c:out value="${requestScope.responseId}"/>');" /> 
<input name='Save' type='button' value='<fmt:message key="portlet.button.apply"/>' class='portlet-form-button'
 onclick="javascript:Light.saveGeneral('<c:out value="${requestScope.responseId}"/>');" />
<input name='default' type='button' value='<fmt:message key="portlet.button.default"/>' class='portlet-form-button'
 onclick="javascript:Light.defaultGeneral('<c:out value="${requestScope.responseId}"/>');" />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>