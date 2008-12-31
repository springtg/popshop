<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%//JUST FOR JSP TAG LIB %>    
<%@include file="../common/tagHead.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Manager System</title>
<%@include file="../common/cssHead.jsp" %>
<%@include file="../common/jsHead.jsp" %>

<script type="text/javascript">

$(document).ready(function(){
    $("#leftMenu_UL").accordion();
  });

function loadMainDIV(url){
	$("#main_DIV").load(url);
}

</script>
 
 
</head>
<body>
<table  width="100%" height="900">
<thead>
<tr><td height="100">
 head
</td>
</tr>
</thead>
<tbody>
<tr>
<td height="561">

<table width="100%" height="700">
 
<tbody>
<tr>
<td width="30%">
  	<ul id="leftMenu_UL">
		<li>
			<div></div>
			<a href="#" onclick="loadMainDIV('systemList.do')">
				System Manager
				<div></div>
			</a>
			<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
			</div>

		</li>
		<li>
			<div></div>
			<a href='#' >Test 2<div ></div></a>
			<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
			</div>
		</li>
		<li>
			<div></div>

			<a href='#'>Test 3<div></div></a>
			<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
			</div>
		</li>
	</ul>


</td>

<td width="70%">
<div id="main_DIV">
 right
 </div>
</td>
</tr>
</tbody>
 
</table>
 
</td>
</tr>
</tbody>
<tfoot>
<tr>
<td   height="100">
 foot
</td>
</tr>
</tfoot>
</table>







</body>
</html>