<%@ page contentType="text/xml; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Block categories module -->
<center>
 
	<h4><a href="#" title="New products">New products</a></h4>
	<div class="block_content">
 
<s:iterator value="productList">		
		<dl class="products">
					 
			<dd class="item"><a href="#"><s:property value="productName"/></a>&nbsp;<a href="/demo/1-ipod-nano.html"><img alt=">>" src="img/bullet.gif"/></a></dd>					
			<dt class="item"><a href="#" title="iPod shuffle"><s:property value="productName"/></a></dt>
		</dl>
 
	 
 </s:iterator>
 		
		
		
		<p><a href="#" title="All new products" class="button_large">All new products</a></p>
	</div> 
	
	 <div>
		
 	 
			
	 				   

	</div>	
</center>
<!-- /Block categories module -->
