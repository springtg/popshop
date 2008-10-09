<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/xml; charset=UTF-8" %>
<center>
	 
<h2>Shopping cart summary</h2>

<!-- Steps -->
<ul id="order_step" class="step">
	<li class="step_current">
				Summary
	</li>
	<li class="step_todo">
				Login
	</li>
	<li class="step_todo">
				Address
	</li>
	<li class="step_todo">
				Shipping
	</li>
	<li class="step_todo" id="step_end">
				Payment
	</li>
</ul>
<!-- /Steps -->

<c:choose>
<c:when test="${not empty shopCartInfo.productItemInfoList}">
<p>
	Your shopping cart contains 4 products</p>
<div class="table_block" id="order-detail-content">
	<table class="std" id="cart_summary">
		<thead>
			<tr>
				<th class="cart_product first_item">Product</th>
				<th class="cart_description item">Description</th>
				<th class="cart_ref item">Ref.</th>
				<th class="cart_availability item">Avail.</th>
				<th class="cart_unit item">Unit price</th>
				<th class="cart_quantity item">Qty</th>
				<th class="cart_total last_item">Total</th>
			</tr>
		</thead>

		<tbody>
					<tr class="first_item item cart_item">
				<td class="cart_product">
					<a href="/prestashop/product.php?id_product=1"><img alt="iPod Nano" src="/prestashop/img/p/1-1-small.jpg"/></a>
				</td>
				<td class="cart_description">
					<h5><a href="/prestashop/product.php?id_product=1">iPod Nano</a></h5>
					<a href="/prestashop/product.php?id_product=1">Disk space: 4GB, Color: Metal</a>				</td>
				<td class="cart_ref">--</td>
				<td class="cart_availability">
											<img alt="Available" src="/prestashop/themes/prestashop/img/icon/available.gif"/>
									</td>
				<td class="cart_unit"><span class="price">$ 342.66</span></td>
				<td class="cart_quantity">
					<a title="Delete" href="/prestashop/cart.php?delete&amp;id_product=1&amp;ipa=4&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_delete"><img class="icon" alt="Delete" src="/prestashop/themes/prestashop/img/icon/delete.gif"/></a>
					<p>1</p>
					<a title="Add" href="/prestashop/cart.php?add&amp;id_product=1&amp;ipa=4&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_up"><img alt="Add" src="/prestashop/themes/prestashop/img/icon/quantity_up.gif"/></a><br/>
					<a title="Subtract" href="/prestashop/cart.php?add&amp;id_product=1&amp;ipa=4&amp;op=down&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_down"><img alt="Subtract" src="/prestashop/themes/prestashop/img/icon/quantity_down.gif"/></a>
				</td>
				<td class="cart_total"><span class="price">$ 342.66</span></td>
			</tr>
					<tr class="alternate_item cart_item">
				<td class="cart_product">
					<a href="/prestashop/product.php?id_product=2"><img alt="iPod shuffle" src="/prestashop/img/p/2-5-small.jpg"/></a>
				</td>
				<td class="cart_description">
					<h5><a href="/prestashop/product.php?id_product=2">iPod shuffle</a></h5>
					<a href="/prestashop/product.php?id_product=2">Color: Metal</a>				</td>
				<td class="cart_ref">--</td>
				<td class="cart_availability">
											<img alt="Available" src="/prestashop/themes/prestashop/img/icon/available.gif"/>
									</td>
				<td class="cart_unit"><span class="price">$ 116.13</span></td>
				<td class="cart_quantity">
					<a title="Delete" href="/prestashop/cart.php?delete&amp;id_product=2&amp;ipa=9&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_delete"><img class="icon" alt="Delete" src="/prestashop/themes/prestashop/img/icon/delete.gif"/></a>
					<p>1</p>
					<a title="Add" href="/prestashop/cart.php?add&amp;id_product=2&amp;ipa=9&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_up"><img alt="Add" src="/prestashop/themes/prestashop/img/icon/quantity_up.gif"/></a><br/>
					<a title="Subtract" href="/prestashop/cart.php?add&amp;id_product=2&amp;ipa=9&amp;op=down&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_down"><img alt="Subtract" src="/prestashop/themes/prestashop/img/icon/quantity_down.gif"/></a>
				</td>
				<td class="cart_total"><span class="price">$ 116.13</span></td>
			</tr>
					<tr class="item cart_item">
				<td class="cart_product">
					<a href="/prestashop/product.php?id_product=6"><img alt="MacBook" src="/prestashop/img/p/6-20-small.jpg"/></a>
				</td>
				<td class="cart_description">
					<h5><a href="/prestashop/product.php?id_product=6">MacBook</a></h5>
									</td>
				<td class="cart_ref">--</td>
				<td class="cart_availability">
											<img alt="Available" src="/prestashop/themes/prestashop/img/icon/available.gif"/>
									</td>
				<td class="cart_unit"><span class="price">$ 2,058.00</span></td>
				<td class="cart_quantity">
					<a title="Delete" href="/prestashop/cart.php?delete&amp;id_product=6&amp;ipa=0&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_delete"><img class="icon" alt="Delete" src="/prestashop/themes/prestashop/img/icon/delete.gif"/></a>
					<p>1</p>
					<a title="Add" href="/prestashop/cart.php?add&amp;id_product=6&amp;ipa=0&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_up"><img alt="Add" src="/prestashop/themes/prestashop/img/icon/quantity_up.gif"/></a><br/>
					<a title="Subtract" href="/prestashop/cart.php?add&amp;id_product=6&amp;ipa=0&amp;op=down&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_down"><img alt="Subtract" src="/prestashop/themes/prestashop/img/icon/quantity_down.gif"/></a>
				</td>
				<td class="cart_total"><span class="price">$ 2,058.00</span></td>
			</tr>
					<tr class="last_item alternate_item cart_item">
				<td class="cart_product">
					<a href="/prestashop/product.php?id_product=7"><img alt="iPod touch" src="/prestashop/img/p/7-24-small.jpg"/></a>
				</td>
				<td class="cart_description">
					<h5><a href="/prestashop/product.php?id_product=7">iPod touch</a></h5>
					<a href="/prestashop/product.php?id_product=7">Disk space: 8Go</a>				</td>
				<td class="cart_ref">--</td>
				<td class="cart_availability">
											<img alt="Available" src="/prestashop/themes/prestashop/img/icon/available.gif"/>
									</td>
				<td class="cart_unit"><span class="price">$ 424.83</span></td>
				<td class="cart_quantity">
					<a title="Delete" href="/prestashop/cart.php?delete&amp;id_product=7&amp;ipa=19&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_delete"><img class="icon" alt="Delete" src="/prestashop/themes/prestashop/img/icon/delete.gif"/></a>
					<p>1</p>
					<a title="Add" href="/prestashop/cart.php?add&amp;id_product=7&amp;ipa=19&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_up"><img alt="Add" src="/prestashop/themes/prestashop/img/icon/quantity_up.gif"/></a><br/>
					<a title="Subtract" href="/prestashop/cart.php?add&amp;id_product=7&amp;ipa=19&amp;op=down&amp;token=555a169fa1738621cf7574a6fbcd2cc0" class="cart_quantity_down"><img alt="Subtract" src="/prestashop/themes/prestashop/img/icon/quantity_down.gif"/></a>
				</td>
				<td class="cart_total"><span class="price">$ 424.83</span></td>
			</tr>
				</tbody>
				
						<tfoot>
			<tr class="cart_total_product">
				<td colspan="6">Total products:</td>
				<td class="price">$ 2,941.62</td>
			</tr>
												<tr class="cart_total_delivery">
				<td colspan="6">Total shipping:</td>
				<td class="price">$ 11.73</td>
			</tr>
						<tr class="cart_total_price">
				<td colspan="6">Total:</td>
				<td class="price">$ 2,953.35</td>
			</tr>
		</tfoot>
		</table>
</div>


<p class="cart_navigation">
	<a title="Next" class="exclusive" href="/prestashop/order.php?step=1">Next »</a>
	<a title="Continue shopping" class="button_large" href="http://127.0.0.1:8083/prestashop/order.php">« Continue shopping</a>
</p>
</c:when>		
<c:otherwise>

</c:otherwise>			
</c:choose>	 


</center>