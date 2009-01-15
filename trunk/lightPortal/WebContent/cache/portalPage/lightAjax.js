
if(window.DOMParser&&window.XMLSerializer&&window.Node&&Node.prototype&&Node.prototype.__defineGetter__){if(!Document.prototype.loadXML){Document.prototype.loadXML=function(s){var doc2=(new DOMParser()).parseFromString(s,"text/xml");while(this.hasChildNodes())
this.removeChild(this.lastChild);for(var i=0;i<doc2.childNodes.length;i++){this.appendChild(this.importNode(doc2.childNodes[i],true));}};}
Document.prototype.__defineGetter__("xml",function(){return(new XMLSerializer()).serializeToString(this);});}
Light.Ajax=function(){log("initialize Light.Ajax");}
Light.Ajax.prototype.sendRequestAndUpdate=function(requestName,container,options){var portlet=Light.getPortletById(container);var request=this.getXmlHttpObject();if(options.method==null)options.method="post";if(options.asynchronous==null)options.asynchronous=true;request.open(options.method,Light.portal.contextPath+portlet.requestUrl,options.asynchronous);request.onreadystatechange=function(){if(request.readyState==4){Light.ajax.onRequestComplete(request);}};if(options.method=='post')
request.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");else
request.setRequestHeader("Content-Type","text/xml");var parameter=options.parameters;if(options.postBody!=null&&options.postBody.length>0)parameter=options.postBody;request.send(options.method=='post'?parameter:null);}
Light.Ajax.prototype.sendRequest=function(requestName,options){var request=this.getXmlHttpObject();if(options.method==null)options.method="post";if(options.asynchronous==null)options.asynchronous=true;request.open(options.method,requestName,options.asynchronous);request.onreadystatechange=function(){if(request.readyState==4&&request.status==200){if(options.onSuccess!=null)
options.onSuccess(request);}};if(options.method=='post')
request.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");else
request.setRequestHeader("Content-Type","text/xml");var parameter=options.parameters;if(options.postBody!=null&&options.postBody.length>0)parameter=options.postBody;request.send(options.method=='post'?parameter:null);}
Light.Ajax.prototype.onRequestComplete=function(request){if(!request)
return;if(request.status!=200)
return;if(request.responseText!=null){var content=request.responseText;var index=content.indexOf("id='");while(index>0){var portletContent=content.substring(index+4);index=portletContent.indexOf("'")
var responseId=portletContent.substring(0,index);index=portletContent.indexOf("<div>");portletContent=portletContent.substring(index);index=portletContent.indexOf("</response>");var pContent=portletContent.substring(0,index);Light.setPortletContent(responseId,pContent);content=portletContent.substring(index);index=content.indexOf("id='");}}else if(request.responseXML!=null){var response=request.responseXML.getElementsByTagName("ajax-response");if(response==null||response.length!=1)
return;Light.ajax.processAjaxResponse(response[0].childNodes);}}
Light.Ajax.prototype.processAjaxResponse=function(xmlResponseElements){for(var i=0;i<xmlResponseElements.length;i++){var responseElement=xmlResponseElements[i];if(responseElement.nodeType!=1)
continue;var responseId=responseElement.getAttribute("id");Light.setPortletContent(responseId,Light.ajax.getContentAsString(responseElement));}}
Light.Ajax.prototype.getContentAsString=function(parentNode){return parentNode.xml!=undefined?Light.ajax.getContentAsStringIE(parentNode):Light.ajax.getContentAsStringMozilla(parentNode);}
Light.Ajax.prototype.getContentAsStringIE=function(parentNode){var contentStr="";for(var i=0;i<parentNode.childNodes.length;i++){var n=parentNode.childNodes[i];if(n.nodeType==4){contentStr+=n.nodeValue;}
else{contentStr+=n.xml;}}
return contentStr;}
Light.Ajax.prototype.getContentAsStringMozilla=function(parentNode){var xmlSerializer=new XMLSerializer();var contentStr="";for(var i=0;i<parentNode.childNodes.length;i++){var n=parentNode.childNodes[i];if(n.nodeType==4){contentStr+=n.nodeValue;}
else{contentStr+=xmlSerializer.serializeToString(n);}}
return contentStr;}
Light.Ajax.prototype.getXmlHttpObject=function(){var xmlhttp;try{xmlhttp=new ActiveXObject("Msxml2.XMLHTTP");}catch(e){try{xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");}catch(E){xmlhttp=false;}}
if(!xmlhttp&&typeof XMLHttpRequest!='undefined'){try{xmlhttp=new XMLHttpRequest();}catch(e){xmlhttp=false;}}
return xmlhttp;}