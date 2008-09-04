<%@ page contentType="text/xml; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Block categories module -->
<center>
 
	<h4><a href="/demo/new-products.php" title="New products">New products</a></h4>
	<div class="block_content">
			<ul class="product_images">
			<li><a href="/demo/11-gu-gu-jiao-123456.html" title=""><img src="/demo/img/p/en-default-medium.jpg" alt="aaa" /></a></li>
			<li><a href="/demo/10-rrr-1542.html" title="Window Sticker"><img src="/demo/img/p/10-37-medium.jpg" alt="Window Sticker" /></a></li>

		</ul>
		<dl class="products">
					<dt class="first_item"><a href="/demo/11-gu-gu-jiao-123456.html" title="Gu Gu Jiao">Gu Gu Jiao</a></dt>
								<dt class="item"><a href="/demo/10-rrr-1542.html" title="Window Sticker">Window Sticker</a></dt>
								<dt class="item"><a href="/demo/1-ipod-nano.html" title="iPod Nano">iPod Nano</a></dt>
			<dd class="item"><a href="/demo/1-ipod-nano.html">A thinner design. Five stylish colors. A...</a>&nbsp;<a href="/demo/1-ipod-nano.html"><img alt=">>" src="/demo/themes/prestashop/img/bullet.gif"/></a></dd>					<dt class="item"><a href="/demo/2-ipod-shuffle.html" title="iPod shuffle">iPod shuffle</a></dt>

			<dd class="item"><a href="/demo/2-ipod-shuffle.html">In five brilliant colors and just $79, the 1GB...</a>&nbsp;<a href="/demo/2-ipod-shuffle.html"><img alt=">>" src="/demo/themes/prestashop/img/bullet.gif"/></a></dd>					<dt class="last_item"><a href="/demo/5-macbook-air.html" title="MacBook Air">MacBook Air</a></dt>
			<dd class="last_item"><a href="/demo/5-macbook-air.html">MacBook Air is ultrathin, ultraportable, and...</a>&nbsp;<a href="/demo/5-macbook-air.html"><img alt=">>" src="/demo/themes/prestashop/img/bullet.gif"/></a></dd>				</dl>
		<p><a href="/demo/new-products.php" title="All new products" class="button_large">All new products</a></p>
	</div> 
	 <div>
		<s:iterator value="productList">
 	 
			<a href="javascript:searchProductInfo(<s:property value="productId"/>)"  title="<s:property value="productName"/>"><s:property value="productName"/></a>
	 
 		</s:iterator>
 
	 				   

	</div>	
</center>
<!-- /Block categories module -->
