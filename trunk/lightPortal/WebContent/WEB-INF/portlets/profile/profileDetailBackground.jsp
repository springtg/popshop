<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body> 
<jsp:include page="profileDetailHeader.jsp" ></jsp:include>
<br/>
<fmt:bundle basename="resourceBundle">
<form action="<portlet:actionURL/>">
<table border='0' cellpadding='0' cellspacing='0' width='80%'>
<tr valign='top'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.maritalStatus"/>: </td>
<td class='portlet-table-td-left'>
<input TYPE='radio' name='maritalStatus' value='1'
<c:if test="${requestScope.userProfile.maritalStatus == 1}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.marital.single"/></input><br/>
<input TYPE='radio' name='maritalStatus' value='2'
<c:if test="${requestScope.userProfile.maritalStatus == 2}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.marital.inRelationship"/></input><br/>
<input TYPE='radio' name='maritalStatus' value='3'
<c:if test="${requestScope.userProfile.maritalStatus == 3}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.marital.married"/></input><br/>
<input TYPE='radio' name='maritalStatus' value='4'
<c:if test="${requestScope.userProfile.maritalStatus == 4}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.marital.divorced"/></input><br/>
<input TYPE='radio' name='maritalStatus' value='0'
<c:if test="${requestScope.userProfile.maritalStatus == 0}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.unknow"/></input><br/>
</td>
</tr>
<br/>
<tr  valign='top'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.sexualOrientation"/>: </td>
<td class='portlet-table-td-left'>
<input TYPE='radio' name='sexualOrientation' value='1'
<c:if test="${requestScope.userProfile.sexualOrientation == 1}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.sexual.straight"/></input><br/>
<input TYPE='radio' name='sexualOrientation' value='2'
<c:if test="${requestScope.userProfile.sexualOrientation == 2}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.sexual.gay"/></input><br/>
<input TYPE='radio' name='sexualOrientation' value='3'
<c:if test="${requestScope.userProfile.sexualOrientation == 3}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.sexual.bi"/></input><br/>
<input TYPE='radio' name='sexualOrientation' value='4'
<c:if test="${requestScope.userProfile.sexualOrientation == 4}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.sexual.nosure"/></input><br/>
<input TYPE='radio' name='sexualOrientation' value='0'
<c:if test="${requestScope.userProfile.sexualOrientation == 0}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.unknow"/></input><br/>
</td>
</tr>
<br/>
<tr valign='top'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.hometown"/>: </td>
<td class='portlet-table-td-left'>
<input type='text' name='hometown' value='<c:out value="${requestScope.userProfile.hometown}"/>' class='portlet-form-input-field' size='18' /> 
</td>
</tr>
<br/>
<tr valign='top'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.religion"/>: </td>
<td class='portlet-table-td-left'>
<select name='religion' size='1' class='portlet-form-select'>
<option value="0"><fmt:message key="portlet.label.unknow"/></option>
	<option value="1"><fmt:message key="portlet.label.religion.agnostic"/></option>
	<option value="2"><fmt:message key="portlet.label.religion.atheist"/></option>
	<option value="3"><fmt:message key="portlet.label.religion.buddhist"/></option>
	<option value="4"><fmt:message key="portlet.label.religion.catholic"/></option>
	<option value="5"><fmt:message key="portlet.label.religion.christian"/></option>
	<option value="6"><fmt:message key="portlet.label.religion.hindu"/></option>
	<option value="7"><fmt:message key="portlet.label.religion.jewish"/></option>
	<option value="8"><fmt:message key="portlet.label.religion.mormon"/></option>
	<option value="9"><fmt:message key="portlet.label.religion.muslim"/></option>
	<option value="10"><fmt:message key="portlet.label.religion.protestant"/></option>
	<option value="15"><fmt:message key="portlet.label.religion.scientologist"/></option>
	<option value="12"><fmt:message key="portlet.label.religion.taoist"/></option>
	<option value="14"><fmt:message key="portlet.label.religion.wiccan"/></option>
	<option value="11"><fmt:message key="portlet.label.religion.other"/></option>
</select>
</td>
</tr>
<br/>
<tr valign='top'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.smoker"/>: </td>
<td class='portlet-table-td-left'>
<input TYPE='radio' name='smoker' value='1'
<c:if test="${requestScope.userProfile.smoker == 1}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.yes"/></input><br/>
<input TYPE='radio' name='smoker' value='2'
<c:if test="${requestScope.userProfile.smoker == 2}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.no"/></input><br/>
<input TYPE='radio' name='smoker' value='0' 
<c:if test="${requestScope.userProfile.smoker == 0}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.unknow"/></input><br/>
</td>
</tr>
<br/>
<tr valign='top' >
<td class='portlet-table-td-right'><fmt:message key="portlet.label.drinker"/>: </td>
<td class='portlet-table-td-left'>
<input TYPE='radio' name='drinker' value='1'
<c:if test="${requestScope.userProfile.drinker == 1}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.yes"/></input><br/>
<input TYPE='radio' name='drinker' value='2'
<c:if test="${requestScope.userProfile.drinker == 2}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.no"/></input><br/>
<input TYPE='radio' name='drinker' value='0' 
<c:if test="${requestScope.userProfile.drinker == 0}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.unknow"/></input><br/>
</td>
</tr>
<br/>
<tr valign='top'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.childrenStatus"/>: </td>
<td class='portlet-table-td-left'>
<input TYPE='radio' name='childrenStatus' value='1'
<c:if test="${requestScope.userProfile.childrenStatus == 1}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.children.no"/></input><br/>
<input TYPE='radio' name='childrenStatus' value='2'
<c:if test="${requestScope.userProfile.childrenStatus == 2}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.children.someday"/></input><br/>
<input TYPE='radio' name='childrenStatus' value='3'
<c:if test="${requestScope.userProfile.childrenStatus == 3}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.children.undecided"/></input><br/>
<input TYPE='radio' name='childrenStatus' value='4'
<c:if test="${requestScope.userProfile.childrenStatus == 4}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.children.notForMe"/></input><br/>
<input TYPE='radio' name='childrenStatus' value='5'
<c:if test="${requestScope.userProfile.childrenStatus == 5}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.children.parent"/></input><br/>
<input TYPE='radio' name='childrenStatus' value='0'
<c:if test="${requestScope.userProfile.childrenStatus == 0}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.unknow"/></input><br/>
</td>
</tr>
<br/>
<tr valign='top'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.education"/>: </td>
<td class='portlet-table-td-left'>
<input TYPE='radio' name='education' value='1'
<c:if test="${requestScope.userProfile.education == 1}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.education.highSchool"/></input><br/>
<input TYPE='radio' name='education' value='2'
<c:if test="${requestScope.userProfile.education == 2}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.education.someCollege"/></input><br/>
<input TYPE='radio' name='education' value='3'
<c:if test="${requestScope.userProfile.education == 3}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.education.inCollege"/></input><br/>
<input TYPE='radio' name='education' value='4'
<c:if test="${requestScope.userProfile.education == 4}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.education.gradCollege"/></input><br/>
<input TYPE='radio' name='education' value='5'
<c:if test="${requestScope.userProfile.education == 5}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.education.gradProf"/></input><br/>
<input TYPE='radio' name='education' value='6'
<c:if test="${requestScope.userProfile.education == 6}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.education.gradUniversity"/></input><br/>
<input TYPE='radio' name='education' value='0'
<c:if test="${requestScope.userProfile.education == 0}">
checked="checked"
</c:if>
><fmt:message key="portlet.label.unknow"/></input><br/>
</td>
</tr>
<br/>
<tr valign='buttom'>
<td class='portlet-table-td-right'><fmt:message key="portlet.label.income"/>: </td>
<td class='portlet-table-td-left'>
<select name='income' size='1' class='portlet-form-select'>
<option value='0'><fmt:message key="portlet.label.unknow"/></option>
<option value='1'><fmt:message key="portlet.label.income.1"/></option>
<option value='2'><fmt:message key="portlet.label.income.2"/></option>
<option value='3'><fmt:message key="portlet.label.income.3"/></option>
<option value='4'><fmt:message key="portlet.label.income.4"/></option>
<option value='5'><fmt:message key="portlet.label.income.5"/></option>
<option value='6'><fmt:message key="portlet.label.income.6"/></option>
<option value='7'><fmt:message key="portlet.label.income.7"/></option>
<option value='8'><fmt:message key="portlet.label.income.8"/></option>
<option value='9'><fmt:message key="portlet.label.income.9"/></option>
</select>
</td>
</tr>
</table>

<table border='0' cellpadding='0' cellspacing='0' width='90%'>
<tr>
<td class='portlet-table-td-right'>
<input type='submit' name='action' onClick="document.pressed='background'" value='<fmt:message key="portlet.button.save"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>