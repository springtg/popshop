<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Mini-Web 帐号管理</title>
	<%@ include file="/common/meta.jsp"%>
	<link href="${ctx}/css/default.css" type="text/css" rel="stylesheet" />
	<script src="${ctx}/js/jquery.js" type="text/javascript"></script>
	<script  src="${ctx}/js/table.js" type="text/javascript"></script>
</head>

<body>
<div id="menu">
	<h3>
	<a href="${ctx}/security/user.action">帐号列表</a>
	<a href="${ctx}/security/role.action">角色列表</a> 
	<a href="${ctx}/company/company.action">公司列表</a> 
	<a href="${ctx}/j_spring_security_logout">退出登录</a>
	</h3> 
</div>

<div id="message"><s:actionmessage theme="mytheme"/></div>
<form id="mainForm" action="task.action" method="get">
<div id="filter">
 
 	产品名称: <input type="text" name="filter_LIKE_productName" value="${param['filter_LIKE_productName']}" size="9"/>
	<input type="button" value="搜索" onclick="search()"/>
</div> 
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}"/>
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<div id="listContent">
<table>
	<tr>
		<th><a href="javascript:sort('id','asc')"><b>序号</b></a></th>
		<th><a href="javascript:sort('company.companyName','asc')""><b>公司名称</b></a></th>
		<th><a href="javascript:sort('productName','asc')""><b>加工产品名称</b></a></th>
		<th><a href="javascript:sort('color','asc')""><b>颜色</b></a></th>
		<th><a href="javascript:sort('quantity','asc')""><b>计划数</b></a></th>
	 
		<th><b>操作</b></th>
	</tr>

	<s:iterator value="page.result">
		<tr>
			<td>${id}&nbsp;</td>
			<td>${company.companyName}&nbsp;</td>
			<td>${productName}&nbsp;</td>
			<td>${color}&nbsp;</td>
			<td>${quantity}&nbsp;</td>
			 		
			<td>&nbsp; 
				<security:authorize ifAnyGranted="A_MODIFY_USER">
					<a href="task!input.action?id=${id}">修改</a>、
					<a href="task!delete.action?id=${id}">删除</a>
				</security:authorize>
			</td>
		</tr>
	</s:iterator>
</table>
</div>

<div id="footer">
	第${page.pageNo}页, 共${page.totalPages}页 
	<a href="javascript:jumpPage(1)">首页</a>
	<s:if test="page.hasPre"><a href="javascript:jumpPage(${page.prePage})">上一页</a></s:if>
	<s:if test="page.hasNext"><a href="javascript:jumpPage(${page.nextPage})">下一页</a></s:if>
	<a href="javascript:jumpPage(${page.totalPages})">末页</a>
	
	<security:authorize ifAnyGranted="A_MODIFY_USER">
		<a href="task!input.action">增加加工工序</a>
	</security:authorize>
</div>
</form>
</body>
</html>
