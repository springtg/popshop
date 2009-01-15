<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<script language="JavaScript">

  keyDownMap  = function (e, id) {  
	  var KeyID;
	  if (window.event) {	
		keyID = window.event.keyCode;
	  } else {
	    keyID = e.which;
	  } 
	  if ( keyID == 13){ 	   
	      submitMap(id);    
	  }
	  return !(keyID == 13);
  }
  
  submitMap = function (id){
    var map="http://maps.google.com/maps?q="+document.forms['form_'+id]['address'].value;
 	window.open(map); 
  } 

</script>
<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left'>
<fmt:message key="portlet.label.address"/>
</td>
<td class='portlet-table-td-left'>
<input type='text' name='address' class='portlet-form-input-field' size='30'
	 onkeypress="return keyDownMap(event,'<c:out value="${requestScope.responseId}"/>');" /> 
<input name='Submit' type='button' class='portlet-form-button' value='<fmt:message key="portlet.button.go"/>' 
	 onclick="javascript:submitMap('<c:out value="${requestScope.responseId}"/>');" />
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>