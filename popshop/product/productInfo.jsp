<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/xml; charset=UTF-8" %>
<span>
 

<!-- Breadcrumb -->
<!--<div class="breadcrumb">
	<a title="return to Home" href="/prestashop/">Home</a><span class="navigation-pipe">></span><span class="navigation_end"><a href="/prestashop/category.php?id_category=2">iPods</a> > iPod Nano</span></div>
-->
<!-- /Breadcrumb -->
<div id="primary_block">

	<h2><c:out value="${productInfo.productName}"/> </h2>

	<!-- right infos-->
	<div id="pb-right-column">
		<!-- product img-->
		<div id="image-block">
		<c:forEach items="${productInfo.productImageList}" var="productImage" begin="0" end="0">
         <img title="${productImage.content}" id="bigpic" alt="${productImage.alt}" src="${productImage.path}"/>
		 </c:forEach>
						
				</div>

				<!-- thumbnails -->
		<div id="views_block">
		<a href="javascript:{}" title="Other views" id="view_scroll_left">Next</a>		<div id="thumbs_list">
			<ul style="width: 328px;">
				<c:forEach items="${productInfo.productImageList}" var="productImage" begin="1" varStatus="varStatus">	 
								<li>
					<a  rel="other-views" href="/prestashop/img/p/1-4-thickbox.jpg">
						<img width="80" height="80" title="${productImage.content}" alt="${productImage.alt}" src="${productImage.path}" id="thumb_${varStatus.index}"/>
					</a>
				</li>
				</c:forEach>
							</ul>
		</div>
		<a href="javascript:{}" title="Other views" id="view_scroll_right">Next</a>		</div>
			</div>

	<!-- left infos-->
	<div id="pb-left-column">
				<div id="short_description_block">
			<div class="rte" id="short_description_content"><c:out value="${productInfo.description}"/> </div>
						<p class="buttons_bottom_block"><a class="button" href="javascript:{}">More details</a></p>
					</div>
		
				<!-- colors -->
				<!--
		<div id="color_picker">
			<p>Pick a color:</p>
							<a onclick="updateColorSelect(4);" style="background: rgb(0, 140, 183) none repeat scroll 0% 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;" class="color_pick" id="color_4"/>
							<a onclick="updateColorSelect(6);" style="background: rgb(147, 213, 45) none repeat scroll 0% 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;" class="color_pick" id="color_6"/>
							<a onclick="updateColorSelect(3);" style="background: rgb(210, 214, 213) none repeat scroll 0% 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;" class="color_pick" id="color_3"/>
							<a onclick="updateColorSelect(5);" style="background: rgb(243, 52, 158) none repeat scroll 0% 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;" class="color_pick" id="color_5"/>
						<div class="clear"/>
		</div>
		-->
		<!-- add to cart form-->
		<form method="post" action="/prestashop/cart.php" id="buy_block">

			<!-- hidden datas -->
			<p class="hidden">
				<input type="hidden" value="555a169fa1738621cf7574a6fbcd2cc0" name="token"/>
				<input type="hidden" id="product_page_product_id" value="1" name="id_product"/>
				<input type="hidden" value="1" name="add"/>
				<input type="hidden" value="4" id="idCombination" name="id_product_attribute"/>
			</p>

			<!-- prices -->
			<p class="price">
									<span class="discount">Price lowered!</span>
								<br/>
				<span class="our_price_display"><span id="our_price_display">$342.66</span> incl. tax</span>
				<br/>
							</p>
							<p id="old_price"><span class="bold"><span id="old_price_display">$380.73</span> incl. tax</span></p>
										<p id="reduction_percent">(price reduced by <span id="reduction_percent_display">10</span> %)</p>
						
			
			<!-- attributes -->
			<div id="attributes">
						<p>
				<label for="group_2">Color :</label>
				<select onchange="javascript:findCombination();" id="group_2" name="group_2">
											<option value="4">Blue</option>
											<option value="6">Green</option>
											<option selected="selected" value="3">Metal</option>
											<option value="5">Pink</option>
									</select>
			</p>
						<p>
				<label for="group_1">Disk space :</label>
				<select onchange="javascript:findCombination();" id="group_1" name="group_1">
											<option value="1">2GB</option>
											<option selected="selected" value="2">4GB</option>
									</select>
			</p>
						</div>
			
			<!-- quantity wanted -->
			<p id="quantity_wanted_p"><label>Quantity :</label> <input type="text" maxlength="3" size="2" value="1" class="text" id="quantity_wanted" name="qty"/></p>

			<!-- availability -->
			<p id="availability_statut">
				<span id="availability_label">Availability:</span>
				<span id="availability_value" class="">En stock</span>
			</p>

			<!-- number of item in stock -->
			<p id="pQuantityAvailable">
				<span id="quantityAvailable">10</span>
				<span id="quantityAvailableTxt" style="display: none;">item in stock</span>
				<span id="quantityAvailableTxtMultiple">items in stock</span>
			</p>

			<p style="display: none;" id="last_quantities" class="warning-inline">Warning: Last items in stock!</p>

			<p class="buttons_bottom_block" id="add_to_cart"><input type="button" onclick="saveProductItemAction(<c:out value="${productInfo.productId}"/>,1)"  class="exclusive" value="Add to cart" name="Submit"/></p>
		</form>

		<!-- usefull links-->
		<ul id="usefull_link_block">
			<li><a href="javascript:print();">Print</a></li>
						<li><span class="span_link" id="view_full_size">View full size</span></li>
					</ul>

	</div>
</div>
<br class="clear"/>




<!-- description and features -->
<div class="clear" id="more_info_block">
	<ul class="idTabs" id="more_info_tabs">
		<li><a href="#idTab1" id="more_info_tab_more_info" class="">More info</a></li>		<li><a href="#idTab2" id="more_info_tab_data_sheet">Data sheet</a></li>		<li><a href="#idTab3" id="more_info_tab_data_sheet1">Data sheet</a></li>	<li><a href="#idTab4" id="more_info_tab_data_sheet2" >view</a></li>			
	</ul>
	<div class="sheets" id="more_info_sheets">
			<!-- full description -->
		<div class="rte block_hidden_only_for_screen" id="idTab1"><c:out value="${productInfo.description}"/></div>
				<!-- product's features -->
		<ul class="bullet" id="idTab2">
				<c:forEach items="${productInfo.productOptionList}" var="productOption">	 
					<li><span><c:out value="${productOption.name}"/> </span>:<c:out value="${productOption.value}"/> </li>
				</c:forEach>
					
		</ul>
		<ul class="sheets" id="idTab3">
					<c:forEach items="${productInfo.productAttributeList}" var="productAttribute">	 
					<li><span><c:out value="${productAttribute.name}"/> </span>:<c:out value="${productAttribute.value}"/> </li>
				</c:forEach>
					
		</ul>
		<ul class="sheets" id="idTab4">
					<c:forEach items="${productInfo.productReviewList}" var="productReview">	 
					<li><span><c:out value="${productReview.userInfo.userName}"/> </span>:<c:out value="${productReview.content}"/> </li>
				</c:forEach>
					
		</ul>		
	</div>
</div>

</span>