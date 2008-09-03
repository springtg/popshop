<%@ page contentType="text/xml; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Block categories module -->
<center>
 
 <h4><a href="/demo/manufacturer.php" title="Manufacturers">Manufacturers</a></h4>
	<div class="block_content">
				<ul class="bullet">
					
<s:iterator value="manufacturerList">
 	 <li>
			<a href="javascript:searchProductInfo(<s:property value="manufacturerId"/>)"  title="<s:property value="information"/>"><s:property value="manufacturerName"/></a>
	 </li>
</s:iterator>
				</ul>
		 <form action="/demo/index.php" method="get">
			<p>
				<select id="manufacturer_list" onclick="autoUrl('manufacturer_list', '');">
 
					<s:iterator value="manufacturerList">
 	 
					<option value="<s:property value="manufacturerId"/>"><s:property value="manufacturerName"/></option>
	 
					</s:iterator>
				</select>
			</p>
		</form>
		</div>
</center>		