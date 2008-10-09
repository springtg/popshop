<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<center>



<!-- Category image -->

<h2 class="category_title">
Laptops
<span>
2 products
</span>
</h2>




<!-- Products list -->
<ul id="product_list" class="clear">

<s:iterator value="productInfoViewList.items">
 
 				
<li class="ajax_block_product first_item item">
<div class="center_block">
<a href="javascript:productInfoLoadAction(<s:property value="productId"/>);"  class="product_img_link"
	title="<s:property value="productName"/>">
<img src="<%=request.getContextPath()%><s:property value="productImage.path"/>" alt="<s:property value="productImage.alt"/>" width="129" height="129"/>
</a>
<h3>
<a href="javascript:productInfoLoadAction(<s:property value="productId"/>);"
	title="<s:property value="productName"/>">
<s:property value="productName"/>
</a>
</h3>
<p class="product_desc">
<a href="javascript:productInfoLoadAction(<s:property value="productId"/>);">
<s:property value="description"/>
</a>
</p>
</div>
<div class="right_block">

<span class="price">
$ <s:property value="price"/>
</span>
<span class="availability">
Available
</span>
<a class="button ajax_add_to_cart_button exclusive"
	rel="ajax_id_product_<s:property value="productId"/>"
	href="javascript:saveProductItemAction(<s:property value="productId"/>,1);">
Add to cart
</a>
<a class="button" href="javascript:productInfoLoadAction(<s:property value="productId"/>);"
	title="View">
View
</a>
</div>
<br class="clear"/>
</li>
</s:iterator> 
</ul>
<!-- /Products list -->
<!-- Pagination -->
<div id="pagination" class="pagination">
 
</div>
<!-- /Pagination -->
</center>
