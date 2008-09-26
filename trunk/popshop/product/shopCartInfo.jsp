<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/xml; charset=UTF-8" %>
<center>
	<h4>
		<a href="http://127.0.0.1:8083/prestashop/order.php">Cart</a>
				<span class="hidden" id="block_cart_expand"> </span>
		<span id="block_cart_collapse"> </span>
			</h4>
<div class="block_content" id="cart_block_content">	
	 
	<!-- block summary -->		
 		
	
	<div class="collapsed" id="cart_block_summary">
		<span class="ajax_cart_quantity"/>
		<span class="ajax_cart_product_txt_s hidden">products</span>
		<span class="ajax_cart_product_txt hidden">product</span>
		<span class="ajax_cart_total"/>
		<span class="ajax_cart_no_product">(empty)</span>
	</div>
 	
	<!-- block list of products -->
	<div class="expanded" id="cart_block_list">
<c:choose>
<c:when test="${not empty shopCartInfo.productItemInfoList}">
	
			<dl class="products">
						
<c:forEach items="${shopCartInfo.productItemInfoList}" var="shopCartProductItem">	 
	 
								<dt class="item" id="cart_block_product_7_19">
				<span class="quantity-formated"><span class="quantity"><c:out value="${shopCartProductItem.orderQuantity}"/></span>x</span>
				<a title="iPod touch" href="javascript:productInfoLoadAction(<c:out value="${shopCartProductItem.productId}"/>);" class="cart_block_product_name"><c:out value="${shopCartProductItem.productName}"/></a>
				<a title="remove this product from my cart" href="javascript:saveProductItemAction(<c:out value="${shopCartProductItem.productId}"/>,-<c:out value="${shopCartProductItem.orderQuantity}"/>);" class="ajax_cart_block_remove_link"> </a>
				<span class="price">$ <c:out value="${shopCartProductItem.orderQuantity*shopCartProductItem.price}"/></span>
			</dt>
						<dd class="last_item" id="cart_block_combination_of_7_19">
				<a title="Product detail" href="javascript:productInfoLoadAction(<c:out value="${shopCartProductItem.productId}"/>);">8Go</a>
			</dd>
</c:forEach>							
		</dl>
</c:when>		
<c:otherwise>
		
			<p id="cart_block_no_products" class="hidden">No products</p>
</c:otherwise>			
</c:choose>

<c:choose>
<c:when test="${not empty shopCartInfo.productItemInfoList}">		
				
		<p id="cart-prices">
			<span>Shipping</span>
			<span class="price ajax_cart_shipping_cost" id="cart_block_shipping_cost">$ 11.73</span>
			<br/>
						<span>Total</span>
			<span class="price ajax_block_cart_total" id="cart_block_total"><c:out value="${shopCartInfo.totalPrice}"/></span>
		</p>
</c:when>		
<c:otherwise>	
		<p id="cart-prices">
			<span>Shipping</span>
			<span class="price ajax_cart_shipping_cost" id="cart_block_shipping_cost">$ 0.00</span>
			<br/>
						<span>Total</span>
			<span class="price ajax_block_cart_total" id="cart_block_total">$ 0.00</span>
		</p>	
</c:otherwise>			
</c:choose>		
		<p id="cart-buttons">
			<a title="Cart" class="button_small" href="javascript:shopCartInfoLoadAction();">Cart</a>
			<a title="Check out" class="exclusive" id="button_order_cart" href="http://127.0.0.1:8083/prestashop/order.php?step=1">Check out</a>
		</p>
	</div>
 </div>

</center>