<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<table border="0" cellpadding="0" cellspacing="0" width="99%">
<tr>
<td class="portlet-table-td-left">Do you have a question about something? Read through our Frequently Asked Questions and move your mouse on them to find the answers you're looking for!
</td>
</tr>
<tr>
<td class="portlet-table-td-left">
<BR/>

<UL>
<LI><span onmouseover="javascript:showDesc(event,'Yes! Every feature and function you currently see on the site is FREE. <c:out value="${sessionScope.org.webId}"/> is supported solely by advertising. In the future, <c:out value="${sessionScope.org.webId}"/> may add paid Premium Services, but all the features and functions you have currently been enjoying on the <c:out value="${sessionScope.org.webId}"/> site will always remain FREE!','<c:out value="${requestScope.responseId}"/>');"
   onmouseout="javascript:hideDesc();">Is <c:out value="${sessionScope.org.webId}"/> free?</span></LI>
</UL>
</td>
</tr>
<tr>
<td class="portlet-table-td-right">
<input type='button' name='action' onClick="javascript:Light.closePortlet('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.close"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</fmt:bundle>
</body>
</html>