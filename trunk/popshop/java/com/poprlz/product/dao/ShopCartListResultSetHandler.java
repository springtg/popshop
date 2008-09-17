package com.poprlz.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poprlz.product.web.bean.ShopCart;

import org.apache.commons.dbutils.ResultSetHandler;

public class ShopCartListResultSetHandler implements ResultSetHandler {

	public Object handle(ResultSet rs) throws SQLException {
		List<ShopCart> shopCartList = new ArrayList<ShopCart>();

		ShopCart shopCart = null;
		while (rs.next()) {
			// sessionId,userInfoId,userName,createDate,lastAcessDate,clientIP,
			// totalPrice
			shopCart = new ShopCart();
			shopCart.setSessionId(rs.getString("sessionId"));
			shopCart.setUserInfoId(rs.getInt("userInfoId"));
			shopCart.setUserName(rs.getString("userName"));
			shopCart.setCreateDate(rs.getDate("createDate"));
			shopCart.setLastAcessDate(rs.getDate("lastAcessDate"));
			shopCart.setClientIP(rs.getString("clientIP"));
			shopCart.setTotalPrice(rs.getBigDecimal("totalPrice"));
			shopCartList.add(shopCart);

		}

		return shopCartList;
	}

}
