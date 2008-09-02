<%@ page contentType="text/xml; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Block categories module -->
<div id="categories_block_left" class="block">

	<h4>Categories</h4>
	<div class="block_content">
		<ul class="tree dhtml">
		
		<s:iterator value="catList">
 	 <li >
			<a href="javascript:searchProductInfo(<s:property value="categorieId"/>)"  title="<s:property value="information"/>"><s:property value="catName"/></a>
	</li>
 		</s:iterator>
 
					  </ul>

	</div>	
</div>
<!-- /Block categories module -->

 
 