<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Main Page Index</title>
<link rel="stylesheet" type="text/css" href="css/maintenance.css">
<link rel="stylesheet" type="text/css" href="css/global.css">

<script language="javascript" src="jquery/jquery-1.2.6.js"></script>
<script language="javascript" src="js/product.js"></script>

</head>

<body>
 
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
<thead>
  <tr>
    <td><a href="javascript:centerColumnLoadInfo('mainPage.php')" title="mainPage" class="button">mainPage</a>
	<a href="javascript:centerColumnLoadInfo('productListDemo.php')" title="productList" class="button">productList</a>
	<a href="javascript:centerColumnLoadInfo('priductInfoDemo.php')" title="ProductInfo" class="button">ProductInfo</a>
	<a href="javascript:centerColumnLoadInfo('login.php')" title="login.php" class="button">login</a>
	<a href="javascript:centerColumnLoadInfo('register.php')" title="login.php" class="button">register</a>
	<a href="javascript:centerColumnLoadInfo('summury.php')" title="login.php" class="button">summury</a>
	<a href="javascript:centerColumnLoadInfo('Shipping.php')" title="login.php" class="button">Shipping</a>
	<a href="javascript:categoriesListAction()" title="login.php" class="button">catList</a>
	<a href="javascript:manufacturerListAction()" title="login.php" class="button">manufacturerListAction</a>
		 
	 </td>
  </tr>
 </thead>
 <tbody> 
  <tr>
    <td align="center">
	
	
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
<tbody>
  <tr>
    <td valign="top"  id="left_column" class="column">

				<!-- Block tags module -->
				<!--  
<div id="tags_block_left" class="block tags_block">
	<h4>Tags</h4>
	<p class="block_content">
			<a href="/demo/search.php?tag=apple" title="More about apple" class="tag_level1 first_item">apple</a>
			<a href="/demo/search.php?tag=adhesive" title="More about adhesive" class="tag_level1 item">adhesive</a>
			<a href="/demo/search.php?tag=sticker" title="More about sticker" class="tag_level1 item">sticker</a>

			<a href="/demo/search.php?tag=superdrive" title="More about superdrive" class="tag_level1 item">superdrive</a>
			<a href="/demo/search.php?tag=label" title="More about label" class="tag_level1 item">label</a>
			<a href="/demo/search.php?tag=Ipod+touch" title="More about Ipod touch" class="tag_level1 last_item">Ipod touch</a>
		</p>
</div>
-->
 
<!-- Block categories module -->
<div id="categories_block_left" class="block">
	<h4>Categories</h4>
	<div class="block_content">
	 
		<ul class="tree dhtml dynamized" style="display: block;">
	 
		<s:iterator value="catList">
 	 <li>
			<a href="javascript:searchProductInfo(<s:property value="categorieId"/>)"  title="<s:property value="information"/>"><s:property value="catName"/></a>
	 </li>
 		</s:iterator>
 
	</ul>				   

	</div>	
</div>
<!-- /Block categories module --><!-- Block manufacturers module -->
<div id="manufacturers_block_left" class="block blockmanufacturer">
	<h4><a href="/demo/manufacturer.php" title="Manufacturers">Manufacturers</a></h4>
	<div class="block_content">
		<ul class="bullet">
						
<c:forEach items="${manufacturerList}" var="manufacturer" begin="0" end="2">
         <li>
			<a href="javascript:productSearchAction(0,'',${manufacturer.manufacturerId})"  title="${manufacturer.information}">${manufacturer.manufacturerName}</a>
	 </li>
 </c:forEach>
 
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
</div>
<!-- /Block manufacturers module --><!-- Block informations module -->
<div id="informations_block_left" class="block">

	<h4>Information</h4>
	<ul class="block_content">
		<li><a href="/demo/delivery.php" title="">Delivery</a></li>
		<li><a href="/demo/mentions.php" title="">Legal notice</a></li>
		<li><a href="/demo/conditions.php" title="">Conditions</a></li>
		<li><a href="/demo/about-us.php" title="">About us</a></li>

	</ul>
</div>
<!-- /Block informations module --><!-- MODULE Block advertising -->
<div class="advertising_block">
	<a href="http://www.prestashop.com" title="Advertising"><img src="./modules/blockadvertising/advertising.jpg" alt="Advertising" /></a>
</div>
<!-- /MODULE Block advertising --><!-- Block payment logo module -->
<div id="paiement_logo_block_left" class="paiement_logo_block">
	<a href="/demo/secure-payment.php">
		<img src="/demo/themes/prestashop/img/logo_paiement_visa.jpg" alt="visa" />
		<img src="/demo/themes/prestashop/img/logo_paiement_mastercard.jpg" alt="mastercard" />
		<img src="/demo/themes/prestashop/img/logo_paiement_paypal.jpg" alt="paypal" />

	</a>
</div>
<!-- /Block payment logo module --><!-- Block links module -->
<div id="links_block_left" class="block">
	<h4>
			
		</h4>
	<ul class="block_content bullet">
			<li><a href="asdfasdf"></a></li>
		</ul>
</div>
<!-- /Block links module -->


	
	</td>
	
	
	
	
    <td valign="top" id="center_column">
	
	
	
 <!-- MODULE Home Featured Products -->
<div id="featured-products_block_center" class="block products_block">
	<h4>featured products</h4>
	<div class="block_content">
		<ul style="height:752px;">
			<s:iterator value="productInfoViewList.items">
 	 <li class="ajax_block_product item">
		
					<h5><a href="javascript:productInfoLoadAction(<s:property value="productId"/>);" title="<s:property value="productName"/>"><s:property value="productName"/></a></h5>
					<p class="product_desc"><a href="javascript:productInfoLoadAction(<s:property value="productId"/>);" title="More">#<s:property value="description"/>...</a></p>
					
					<a href="javascript:productInfoLoadAction(<s:property value="productId"/>);" title="<s:property value="productName"/>" class="product_image"><img src="<%=request.getContextPath()%><s:property value="productImage.path"/>" alt="<s:property value="productImage.alt"/>" width="129" height="129"></a>
					
					<p>
						<span class="price">$ <s:property value="price"/></span>
						<a class="button" href="javascript:productInfoLoadAction(<s:property value="productId"/>);" title="View">View</a>
												<a class="exclusive ajax_add_to_cart_button" rel="ajax_id_product_2" href="javascript:saveProductItemAction(<s:property value="productId"/>,1);" title="Add to cart">Add to cart</a>
											</p>
					 
	 </li>
 		</s:iterator>								 	 
											 
		</ul>

	</div>
</div>
<!-- /MODULE Home Featured Products -->	

	
	</td>
    <td valign="top" id="right_column">
	
<div class="block exclusive" id="cart_block">
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
</div>


<!-- /MODULE Block cart -->

<!-- MODULE Block new products -->
<div id="new-products_block_right" class="block products_block">
	<h4><a href="/demo/new-products.php" title="New products">New products</a></h4>
	<div class="block_content">
			<ul class="product_images">
		<c:forEach items="${lastedProductInfoViewList.items}" var="productInfoView" begin="0" end="1">
         <li><a href="${productInfoView.productId}" title="${productInfoView.productName}"><img width="80" height="80" src="${productInfoView.productImage.path}" alt="" /></a></li>
        </c:forEach>
 

		</ul>
		<dl class="products">
		
		<!--
		<dt class="first_item"><a href="/demo/11-gu-gu-jiao-123456.html" title="Gu Gu Jiao">Gu Gu Jiao</a></dt>
								<dt class="item"><a href="/demo/10-rrr-1542.html" title="Window Sticker">Window Sticker</a></dt>
								<dt class="item"><a href="/demo/1-ipod-nano.html" title="iPod Nano">iPod Nano</a></dt>
			<dd class="item"><a href="/demo/1-ipod-nano.html">A thinner design. Five stylish colors. A...</a>&nbsp;<a href="/demo/1-ipod-nano.html"><img alt=">>" src="/demo/themes/prestashop/img/bullet.gif"/></a></dd>					<dt class="item"><a href="/demo/2-ipod-shuffle.html" title="iPod shuffle">iPod shuffle</a></dt>

			<dd class="item"><a href="/demo/2-ipod-shuffle.html">In five brilliant colors and just $79, the 1GB...</a>&nbsp;<a href="/demo/2-ipod-shuffle.html"><img alt=">>" src="/demo/themes/prestashop/img/bullet.gif"/></a></dd>					<dt class="last_item"><a href="/demo/5-macbook-air.html" title="MacBook Air">MacBook Air</a></dt>
			<dd class="last_item"><a href="/demo/5-macbook-air.html">MacBook Air is ultrathin, ultraportable, and...</a>&nbsp;<a href="/demo/5-macbook-air.html"><img alt=">>" src="/demo/themes/prestashop/img/bullet.gif"/></a></dd>
			-->
		<c:forEach items="${lastedProductInfoViewList.items}" var="productInfoView" begin="2">
		
			<dd class="item"><a href="${productInfoView.productId}">${productInfoView.description}</a>&nbsp;<a href="${productInfoView.productId}"><img alt=">>" src="img/bullet.gif"/></a></dd>					<dt class="item"><a href="${productInfoView.productId}" title="${productInfoView.productName}">${productInfoView.productName}</a></dt>
					
			 </c:forEach>
			
							</dl>
		<p><a href="/demo/new-products.php" title="All new products" class="button_large">All new products</a></p>
	</div>
	</div>
<!-- /MODULE Block new products --><!-- MODULE Block best sellers -->

<div id="best-sellers_block_right" class="block products_block">
	<h4><a href="/demo/best-sales.php">Top sellers</a></h4>
	<div class="block_content">
			<ul class="product_images">
			<c:forEach items="${topSaleProductInfoViewList.items}" var="productInfoView" begin="0" end="1">
			<li><a href="${productInfoView.productId}" title="${productInfoView.productName}"><img  width="80" height="80"  src="${productInfoView.productImage.path}" alt="${productInfoView.productName}" /></a></li>
			</c:forEach>
					</ul>
		<dl>
		
		<c:forEach items="${topSaleProductInfoViewList.items}" var="productInfoView">
					<dt class="first_item"><a href="${productInfoView.productId}" title="${productInfoView.productName}">${productInfoView.productName}</a></dt>

			<dd class="first_item">${productInfoView.description}</dd>				
			
		</c:forEach>	
			</dl>
		<p><a href="/demo/best-sales.php" title="All best sellers" class="button_large">All best sellers</a></p>
		</div>
</div>
<!-- /MODULE Block best sellers --><!-- MODULE Block specials -->
<div id="special_block_right" class="block products_block exclusive blockspecials">
	<h4><a href="/demo/prices-drop.php" title="Specials">Specials</a></h4>
	<div class="block_content">

		<ul class="products">
		<c:forEach items="${topViewProductInfoViewList.items}" var="productInfoView" begin="0" end="0">
			<li class="product_image">
				<a href="${productInfoView.productId}"><img src="/demo/img/p/1-1-medium.jpg" alt="${productInfoView.productName}" title="${productInfoView.productName}" /></a>
			</li>
			<li>
				<h5><a href="${productInfoView.productId}" title="${productInfoView.productName}">${productInfoView.productName}</a></h5>
				<span class="price-discount">${productInfoView.price} &euro;</span>
				<span class="reduction">(-10%)</span>				<span class="price">${productInfoView.price} &euro;</span>

			</li>
			</c:forEach>
		</ul>
		<p>
			<a href="/demo/prices-drop.php" title="All specials" class="button">All specials</a>
		</p>
	</div>
</div>
	
	</td>
  </tr>
  </tbody>
</table>

	
	
	
	
	
	</td>
  </tr>
  </tbody>
  <tfoot>
  <tr>
    <td>&nbsp;</td>
  </tr>
  </tfoot>
</table>
 
</body>
</html>

