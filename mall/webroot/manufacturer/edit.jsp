<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<%@ include file="/common/meta.jsp"%>
	<%@ include file="/common/css.jsp"%>
	<%@ include file="/common/javascript.jsp"%>
	
		
</head>

<body>
<%@ include file="/common/header.jsp"%>
<%@ include file="/common/navigation.jsp"%>

<!--   main content-->
<div id="message"><!--  s:actionmessage theme="mytheme"/--></div>
<form action="save.action" method="post">


	manufacturersId: <input type="text" name="manufacturersId" value="${manufacturer.manufacturersId}"/><br/>
	manufacturersName:<input type="text" name="manufacturersName" value="${manufacturer.manufacturersName}"/><br/>
	manufacturersImage:<input type="text" name="manufacturersImage" value="${manufacturer.manufacturersImage}"/><br/>
	manufacturersUrl:<input type="text" name="manufacturersUrl" value="${manufacturer.manufacturersUrl}"/><br/>
	urlClicked:<input type="text" name="urlClicked" value="${manufacturer.urlClicked}"/><br/>
	<input type="submit" value="submit" /> 
 
 
</form>
<!--   main content end -->
<%@ include file="/common/footer.jsp"%>


</body>
</html>