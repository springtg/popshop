<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@	taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User System Manager</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>systemId</th>
			<th>systemCode</th>
			<th>description</th>
			<th>status</th>
			<th>systemId</th>
			<th>systemId</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${!empty systemList}">
		<c:forEach items="${systemList}" var="system"  varStatus="status">
		<tr>
			<td><c:out value="${system.systemId}"></c:out></td>
			<td><c:out value="${system.systemCode}"></c:out></td>
			<td><c:out value="${system.description}"></c:out></td>
			<td><c:out value="${system.status}"></c:out></td>
			<td><a href="systemModifySetup.do?systemId=${system.systemId}">edit</a></td>
			<td><c:out value="${system.systemId}"></c:out></td>
		</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			 
		</c:otherwise>
	</c:choose>
		
	</tbody>
</table>

 
 
 
 
 
 
</body>
</html>