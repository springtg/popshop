<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@	taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   

<%@ page import="com.poprlz.common.CommonConstant" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
	<s:form action="systemModify.do">
		
		<input type="hidden" name="systemId" value="${systemEntity.systemId}"></input><br/>
		systemCode:<input type="text" name="systemCode" value="${systemEntity.systemCode}"  readonly="true"></input><br/>
		status:<select name="status">
		<option value="<%=CommonConstant.STATUS_ACTIVE%>"><%=CommonConstant.STATUS_ACTIVE%></option>
		<option value="<%=CommonConstant.STATUS_SUSPEND%>"><%=CommonConstant.STATUS_SUSPEND%></option>
		
		</select>
		<br/>
		description:<textarea name="description" cols="20" rows="8">${systemEntity.description}</textarea> <br/>
	 
	 
		<s:submit></s:submit>
	
	</s:form>
 
 
 
 
</body>
</html>