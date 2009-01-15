<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<script language="JavaScript">

  keyDownFlickr  = function (e, id) {  
	  var KeyID;
	  if (window.event) {	
		keyID = window.event.keyCode;
	  } else {
	    keyID = e.which;
	  } 
	  if ( keyID == 13){ 	   
	      submitFlickr(id);    
	  }
	  return !(keyID == 13);
  }
  
  submitFlickr = function (id){
    var key = document.forms['form_'+id]['flickr'].value;
    var len = document.forms['form_'+id]['tag'].length;
    var tag ="all";
    for(var i = 0; i < len; i++) {
     if(document.forms['form_'+id]['tag'][i].checked){
        tag= document.forms['form_'+id]['tag'][i].value;
     }
    }
    window.open("http://www.flickr.com/search/?q="+key+"&m="+tag); 
  } 
  
</script>
<fmt:bundle basename="resourceBundle">
<form name="form_<c:out value="${requestScope.responseId}"/>">
<table border='0' cellpadding='0' cellspacing='0'>
<tr>
<td class='portlet-table-td-left'>
<img src='<%= request.getContextPath() %>/light/images/flickrlogo.jpg' style='border: 0px;'  width='100%' height='100%' align="middle" />
</td>
<td class='portlet-table-td-left'>
<input type='text' name='flickr' class='portlet-form-input-field' size='20'
	 onkeypress="return keyDownFlickr(event,'<c:out value="${requestScope.responseId}"/>');" /> 
<input name='Submit' type='button' class='portlet-form-button' value='<fmt:message key="portlet.button.go"/>' 
	 onclick="javascript:submitFlickr('<c:out value="${requestScope.responseId}"/>');" />
</td>
</tr>
<tr>
<tr>
<td class='portlet-table-td-left'></td>
<td class='portlet-table-td-left'>
<span class="portlet-item">
<input TYPE='radio' name='tag' value='all' checked="checked"><fmt:message key="portlet.label.fullText"/></input>
<input TYPE='radio' name='tag' value='tags'><fmt:message key="portlet.label.tagOnly"/></input>
<a href='http://www.flickr.com/search/' tagert="_blank"><fmt:message key="portlet.label.moreSearch"/></a>
</span>
</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>