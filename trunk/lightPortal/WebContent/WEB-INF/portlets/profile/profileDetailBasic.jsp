<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="profileDetailHeader.jsp" ></jsp:include>
<br/>

<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL/>">
<table border='0' cellpadding='0' cellspacing='0' width='60%'>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.email"/>: </td>
<td class='portlet-table-td-left'>
<input type='text' name='email' value='<c:out value="${sessionScope.user.email}"/>' class='portlet-form-input-field' size='24' /> 
<img src='<%= request.getContextPath() %>/light/images/faq.gif' title='<fmt:message key="portlet.label.alternateEmail"/>' style='border: 0px;' width='16' height='16'/>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.birth"/>: </td>
<td class='portlet-table-td-left'>
<select name='birthM' size='1' class='portlet-form-select'>
<c:forEach var="month" items="${requestScope.months}" >
<option value='<c:out value="${month.id}"/>'
<c:if test='${sessionScope.user.birthM == month.id}'>
selected="selected"
</c:if>
><c:out value="${month.desc}"/></option>
</c:forEach>
</select>
/
<select name='birthD' size='1' class='portlet-form-select'>
<c:forEach var="day" items="${requestScope.days}" >
<option value='<c:out value="${day.id}"/>'
<c:if test='${sessionScope.user.birthD == day.id}'>
selected="selected"
</c:if>
><c:out value="${day.desc}"/></option>
</c:forEach>
</select>
/
<select name='birthY' size='1' class='portlet-form-select'>
<c:forEach var="year" items="${requestScope.years}" >
<option value='<c:out value="${year.id}"/>'
<c:if test='${sessionScope.user.birthY == year.id}'>
selected="selected"
</c:if>
><c:out value="${year.desc}"/></option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.gender"/>: </td>
<td class='portlet-table-td-left'>
<input TYPE='radio' name='gender' value='M' 
<c:if test="${sessionScope.user.gender == 'M'}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.gender.male"/></input>
<input TYPE='radio' name='gender' value='F'
<c:if test="${sessionScope.user.gender == 'F'}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.gender.female"/></input>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.occupation"/>: </td>
<td class='portlet-table-td-left'>
<input type='text' name='occupation' value='<c:out value="${requestScope.userProfile.occupation}"/>' class='portlet-form-input-field' size='40' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.country"/>: </td>
<td class='portlet-table-td-left'>
<select name='country' size='1' class='portlet-form-select' value='<c:out value="${sessionScope.user.country}"/>'>
<option value='' ></option>
<c:forEach var="country" items="${requestScope.countries}" >
<option value='<c:out value="${country.desc}"/>'
<c:if test='${sessionScope.user.country == country.desc}'>
selected="selected"
</c:if>
 ><c:out value="${country.desc}"/></option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.province"/>: </td>
<td class='portlet-table-td-left'>
<input type='text' name='province' value='<c:out value="${sessionScope.user.province}"/>' class='portlet-form-input-field' size='18' />
<%--
<select name='province' size='1' class='portlet-form-select'>
<option value='' ></option>
<c:forEach var="province" items="${requestScope.provinces}" >
<option value='<c:out value="${province.desc}"/>' 
<c:if test='${sessionScope.user.province == province.desc}'>
selected="selected"
</c:if>
><c:out value="${province.desc}"/></option>
</c:forEach>
</select>
--%>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.city"/>: </td>
<td class='portlet-table-td-left'>
<input type='text' name='city' value='<c:out value="${sessionScope.user.city}"/>' class='portlet-form-input-field' size='18' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.postalCode"/>: </td>
<td class='portlet-table-td-left'>
<input type='text' name='postalCode' value='<c:out value="${sessionScope.user.postalCode}"/>' class='portlet-form-input-field' size='18' /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.ethnicity"/>: </td>
<td class='portlet-table-td-left'>
<select name='ethnicity' size='1'  class='portlet-form-select' STYLE="width: 120px" >
	<option value="0"
	<c:if test='${requestScope.userProfile.ethnicity == 0}'>
	selected='selected'
	</c:if>
	>No Answer</option>
	<option value="1"
	<c:if test='${requestScope.userProfile.ethnicity == 1}'>
	selected='selected'
	</c:if>
	>Asian</option>
	<option value="2"
	<c:if test='${requestScope.userProfile.ethnicity == 2}'>
	selected='selected'
	</c:if>
	>Black / African descent</option>
	<option value="3"
	<c:if test='${requestScope.userProfile.ethnicity == 3}'>
	selected='selected'
	</c:if>
	>East Indian</option>
	<option value="4"
	<c:if test='${requestScope.userProfile.ethnicity == 4}'>
	selected='selected'
	</c:if>
	>Latino / Hispanic</option>
	<option value="5"
	<c:if test='${requestScope.userProfile.ethnicity == 5}'>
	selected='selected'
	</c:if>
	>Middle Eastern</option>
	<option value="6"
	<c:if test='${requestScope.userProfile.ethnicity == 6}'>
	selected='selected'
	</c:if>
	>Native American</option>
	<option value="7"
	<c:if test='${requestScope.userProfile.ethnicity == 7}'>
	selected='selected'
	</c:if>
	>Pacific Islander</option>
	<option value="8"
	<c:if test='${requestScope.userProfile.ethnicity == 8}'>
	selected='selected'
	</c:if>
	>White / Caucasian</option>
	<option value="9"
	<c:if test='${requestScope.userProfile.ethnicity == 9}'>
	selected='selected'
	</c:if>
	>Other</option>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.bodyType"/>: </td>
<td class='portlet-table-td-left'>
<select name='bodyType' size='1'  class='portlet-form-select' STYLE="width: 120px">
	<option value="0"
	<c:if test='${requestScope.userProfile.bodyType == 0}'>
	selected='selected'
	</c:if>
	>No Answer</option>
	<option value="1"
	<c:if test='${requestScope.userProfile.bodyType == 1}'>
	selected='selected'
	</c:if>
	>Slim / Slender</option>
	<option value="2"
	<c:if test='${requestScope.userProfile.bodyType == 2}'>
	selected='selected'
	</c:if>
	>Athletic</option>
	<option value="3"
	<c:if test='${requestScope.userProfile.bodyType == 3}'>
	selected='selected'
	</c:if>
	>Average</option>
	<option value="4"
	<c:if test='${requestScope.userProfile.bodyType == 4}'>
	selected='selected'
	</c:if>
	>Some extra baggage</option>
	<option value="5"
	<c:if test='${requestScope.userProfile.bodyType == 5}'>
	selected='selected'
	</c:if>
	>More to love!</option>
	<option value="6"
	<c:if test='${requestScope.userProfile.bodyType == 6}'>
	selected='selected'
	</c:if>
	>Body builder</option>
</select>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.height"/>: </td>
<td class='portlet-table-td-left'>
<select name='height' size='1'  class='portlet-form-select'>
<c:forEach var="i" begin="0" end="300" step="1">
<option  value='<c:out value="${i}" />'
<c:if test='${requestScope.userProfile.height == i}'>
selected='selected'
</c:if>
><c:out value="${i}" /></option>
</c:forEach>
</select>
cm
</td>
</tr>
<tr valign='top'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.registerPurpose"/>: </td>
<td class='portlet-table-td-left'>
<input TYPE='radio' name='registerPurpose' value='0' 
<c:if test="${requestScope.userProfile.registerPurpose == '0'}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.purpose.personal"/></input><br/>
<input TYPE='radio' name='registerPurpose' value='1' 
<c:if test="${requestScope.userProfile.registerPurpose == '1'}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.purpose.networking"/></input><br/>
<input TYPE='radio' name='registerPurpose' value='2' 
<c:if test="${requestScope.userProfile.registerPurpose == '2'}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.purpose.friends"/></input><br/>
<input TYPE='radio' name='registerPurpose' value='3' 
<c:if test="${requestScope.userProfile.registerPurpose == '3'}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.purpose.dating"/></input><br/>
<input TYPE='radio' name='registerPurpose' value='4' 
<c:if test="${requestScope.userProfile.registerPurpose == '4'}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.purpose.serious"/></input><br/>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='60%'>
<tr>
<td class='portlet-table-td-right'>
<input type='submit' name='action' onClick="document.pressed='basic'" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>