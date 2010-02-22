<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Mini-Web 帐号管理</title>
	<%@ include file="/common/meta.jsp"%>
	<%@ include file="/common/css.jsp"%>
	<%@ include file="/common/javascript.jsp"%>
	
		
</head>

<body>
<%@ include file="/common/header.jsp"%>
<%@ include file="/common/navigation.jsp"%>

<!--   main content-->
<div id="message"><!--s:actionmessage theme="mytheme"/--></div>
<form id="mainForm" action="user.action" method="get">
 
<input type="hidden" name="page.pageNo" id="pageNo" value="${manufacturerPage.pageNo}"/>
<input type="hidden" name="page.orderBy" id="orderBy" value="${manufacturerPage.orderBy}"/>
<input type="hidden" name="page.order" id="order" value="${manufacturerPage.order}" />
<div id="listContent">
<table>
	<tr>
		<th><b>manufacturersId</b></th>
		<th><b>manufacturersName</b></th>
		<th><b>manufacturersImage</b></th>
		<th><b>manufacturersUrl</b></th>
		<th><b>urlClicked</b></th>
		<th><b>edit</b></th>
		<th><b>delete</b></th>
	</tr>

	<s:iterator value="manufacturerPage.result">
		<tr>
			<td>${manufacturersId}&nbsp;</td>
			<td>${manufacturersName}&nbsp;</td>
			<td>${manufacturersImage}&nbsp;</td>
			<td>${manufacturersUrl}&nbsp;</td>
			<td>${urlClicked}&nbsp;</td>			
			<td>&nbsp; 
				 
					<a href="manufacturerEdit.action?id=${manufacturersId}">edit</a>
					 
				 
			</td>
			<td>&nbsp; 
				 
					<a href="manufacturerDelete.action?id=${manufacturersId}">delete</a>
					 
				 
			</td>
		</tr>
	</s:iterator>
</table>
</div>
<div id="footer">
	第${manufacturerPage.pageNo}页, 共${manufacturerPage.totalPages}页 
	<a href="javascript:jumpPage(1)">首页</a>
	<s:if test="manufacturerPage.hasPre"><a href="javascript:jumpPage(${manufacturerPage.prePage})">上一页</a></s:if>
	<s:if test="manufacturerPage.hasNext"><a href="javascript:jumpPage(${manufacturerPage.nextPage})">下一页</a></s:if>
	<a href="javascript:jumpPage(${manufacturerPage.totalPages})">末页</a>
	
	 
		<a href="manufacturerEdit.action">new</a>
	 
</div>
</form>
 
<!--   main content end -->
<%@ include file="/common/footer.jsp"%>


</body>
</html>