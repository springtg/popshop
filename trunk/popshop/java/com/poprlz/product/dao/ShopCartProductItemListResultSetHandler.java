package com.poprlz.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.poprlz.product.web.bean.ShopCart;
import com.poprlz.product.web.bean.ShopCartProductItem;

public class ShopCartProductItemListResultSetHandler implements
		ResultSetHandler {

	public Object handle(ResultSet rs) throws SQLException {
		List<ShopCartProductItem> shopCartProductItemList = new ArrayList<ShopCartProductItem>();

		ShopCartProductItem shopCartProductItem = null;
		while (rs.next()) {
			 
			shopCartProductItem = new ShopCartProductItem();
			 // PRODUCTITEMID,SESSIONID,PRODUCTID,PRODUCTNAME,
			shopCartProductItem.setProductItemId(rs.getInt("PRODUCTITEMID"));
			shopCartProductItem.setSessionId(rs.getString("SESSIONID"));
			shopCartProductItem.setProductId(rs.getInt("PRODUCTID"));
			shopCartProductItem.setProductName(rs.getString("PRODUCTNAME"));
			//PRICE,ORDERQUANTITY,DESCRIPTION,
			shopCartProductItem.setPrice(rs.getBigDecimal("PRICE"));
			shopCartProductItem.setOrderQuantity(rs.getInt("ORDERQUANTITY"));
			shopCartProductItem.setDescription(rs.getString("DESCRIPTION"));
			//WEIGHT,URL,IMAGEID,IMGPATH 
			shopCartProductItem.setWeight(rs.getBigDecimal("WEIGHT"));
			shopCartProductItem.setURL(rs.getString("URL"));
			shopCartProductItem.setImageId(rs.getInt("IMAGEID"));
			shopCartProductItem.setImgPath("IMGPATH");
			shopCartProductItemList.add(shopCartProductItem);

		}

		return shopCartProductItemList;
	}

}
