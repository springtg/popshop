<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
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
<br/>
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-msg-error' >
<c:out value="${requestScope.error}"/>
</td>
</tr>
</table>
</c:if>
<form name='form_<c:out value="${requestScope.responseId}"/>' action="<portlet:actionURL />" onsubmit="javascript:return validateSignUp(this);">
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr>
<td class='portlet-table-td-left' width='10%'>
</td>
<td class='portlet-table-td-left'>
<br/><br/>
<b><fmt:message key="portlet.registration.label.signup.message1"/></b>
<br/>
<fmt:message key="portlet.registration.label.signup.message2"/>
<br/><br/>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='98%'>
<tr>
<td class='portlet-table-td-right'>*<fmt:message key="portlet.label.email"/>: </td>
<td class='portlet-table-td-left'>
<input type='text' name='email' value='' class='portlet-form-input-field' size='30' onchange="validateUserId(this.value,'<c:out value="${requestScope.responseId}"/>');" AUTOCOMPLETE='OFF'/>
<img src='<%= request.getContextPath() %>/light/images/faq.gif' title='<fmt:message key="portlet.label.faq.email"/>' style='border: 0px;' width='16' height='16'/>
</td>
</tr>
<tr>
<td class='portlet-table-td-right'>*<fmt:message key="portlet.label.userPassword"/>: </td>
<td class='portlet-table-td-left'>
<input type='password' name='password' value=''
class='portlet-form-input-field' size='30' />
</td>
</tr>
<tr>
<td class='portlet-table-td-right'>*<fmt:message key="portlet.label.confirmPassword"/>:</td>
<td class='portlet-table-td-left'>
<input type='password' name='confirmPassword' value=''
class='portlet-form-input-field' size='30' />
</td>
</tr>
<tr>
<td class='portlet-table-td-right'>*<fmt:message key="portlet.label.displayName"/>: </td>
<td class='portlet-table-td-left'>
<input type='text' name='displayName' value=''
class='portlet-form-input-field' size='30' />
</td>
</tr>
<tr>
<td class='portlet-table-td-right'>*<fmt:message key="portlet.label.myUrl"/>: </td>
<td class='portlet-table-td-left'>
http://www.<c:out value="${sessionScope.org.space}"/>
<input type='text' name='myUri' value='' class='portlet-form-input-field' size='18' onchange="validateMyUri(this.value,'<c:out value="${requestScope.responseId}"/>');" AUTOCOMPLETE='OFF'/> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right'></td>
<td class='portlet-table-td-left'>
<input type="checkbox" name="accept" value="1" > 
<fmt:message key="portlet.message.accept1"/>
<span class='portlet-item'> 
<a href="javascript:void(0);" onclick="javascript:Light.portal.showTerms();"><fmt:message key="portlet.message.accept2"/></a>
</span>
<fmt:message key="portlet.message.accept3"/>
<span class='portlet-item'>  
<a href="javascript:void(0);" onclick="javascript:Light.portal.showPrivacy();"><fmt:message key="portlet.message.accept4"/></a>   
</span>
</input>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='80%'>
<tr>
<td class='portlet-table-td-right'>
<input type='submit' name='action' onClick="document.pressed='step1'" value='<fmt:message key="portlet.button.next"/>' class='portlet-form-button' />

<input type='button' name='action' onClick="javascript:Light.cancelSignUp('<c:out value="${requestScope.responseId}"/>');" value='<fmt:message key="portlet.button.cancel"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>