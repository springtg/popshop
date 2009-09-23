<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>公司资料管理</title>
	<%@ include file="/common/meta.jsp"%>
	<link href="${ctx}/css/default.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/js/validate/jquery.validate.css" type="text/css" rel="stylesheet" />
	<script src="${ctx}/js/jquery.js" type="text/javascript"></script>
	<script src="${ctx}/js/validate/jquery.validate.js" type="text/javascript"></script>
	<script src="${ctx}/js/validate/messages_cn.js" type="text/javascript"></script>
 
</head>

<body>
<h3><s:if test="id == null">创建</s:if><s:else>修改</s:else>加工工序</h3>
<div id="inputContent">
<form id="inputForm" action="process!save.action" method="post">
<input type="hidden" name="id" value="${id}" />
<input type="hidden" name="status" value="${status}" />
<table class="inputView">
	<tr>
		<td>加工工序:</td>
		<td><input type="text" name="processName" size="40" id="processName" value="${processName}" /></td>
	</tr>
	 
	 
	<tr>
		<td colspan="2">
			<input type="submit" value="提交" />&nbsp; 
			<input type="button" value="取消" onclick="history.back()"/>
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>