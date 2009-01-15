<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<script language="JavaScript">

  keyDownDirection  = function (e, id,type) {  
	  var KeyID;
	  if (window.event) {	
		keyID = window.event.keyCode;
	  } else {
	    keyID = e.which;
	  } 
	  if ( keyID == 13){ 
	    if(type=='from')
	      document.forms['form_'+id]['psTo'].focus();
	    else
	      submitDirection(id);    
	  }
	  return !(keyID == 13);
  }
  
  submitDirection = function (id){
    var driving="http://maps.google.com/maps?saddr="+document.forms['form_'+id]['psFrom'].value+"&daddr="+document.forms['form_'+id]['psTo'].value;
 	window.open(driving); 
  } 

</script>
<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.from"/>
</td>
<td class='portlet-table-td-left'>
<input type='text' name='psFrom' class='portlet-form-input-field' size='30'
	 onkeypress="return keyDownDirection(event,'<c:out value="${requestScope.responseId}"/>','from');" /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.to"/>
</td>
<td class='portlet-table-td-left'>
<input type='text' name='psTo' class='portlet-form-input-field' size='30'
	 onkeypress="return keyDownDirection(event,'<c:out value="${requestScope.responseId}"/>','to');" /> 
</td>
</tr>
<tr>
<td class='portlet-table-td-right' colspan='2'>
<input name='Submit' type='button' class='portlet-form-button' value='<fmt:message key="portlet.button.go"/>' 
	 onclick="javascript:submitDirection('<c:out value="${requestScope.responseId}"/>');" />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>