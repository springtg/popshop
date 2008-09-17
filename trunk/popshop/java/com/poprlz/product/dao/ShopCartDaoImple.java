package com.poprlz.product.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.google.inject.Inject;
import com.poprlz.dao.HsqlConnectionProvider;
import com.poprlz.product.web.bean.ShopCart;

public class ShopCartDaoImple implements IShopCartDao {

	@Inject
	private HsqlConnectionProvider<Connection> hsqlConnectionProvider;

	@Inject
	private QueryRunner dbOperator;

	private static final String LoadShopCartQueryBySessionId = "SELECT sessionId,userInfoId,userName,createDate,lastAcessDate,clientIP,totalPrice FROM shopCart Where sessionId=?";

	public ShopCart loadEntity(String sessionId) {
		
		ShopCart shopCart=null;
		try {
			List<ShopCart> shopCartList = (List<ShopCart>) dbOperator.query(
					hsqlConnectionProvider.get(), LoadShopCartQueryBySessionId,
					sessionId, new ShopCartListResultSetHandler());
			
			if(!(shopCartList==null || shopCartList.size()<1)){
				shopCart=shopCartList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shopCart;
	}

	
	private static final String ModifyShopCartSqlCmd="UPDATE shopCart Set userInfoId=?,userName=?,lastAcessDate=NOW(),clientIP=?,totalPrice=? WHERE sessionId=? ";
	public ShopCart modifyEntity(ShopCart entity) {
		
		Object[] params={
				entity.getUserInfoId(),
				entity.getUserName(),
				entity.getClientIP(),
				entity.getTotalPrice(),
				entity.getSessionId()
				 
		};
		try {
			dbOperator.update(hsqlConnectionProvider.get(), ModifyShopCartSqlCmd, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loadEntity(entity.getSessionId());
	}

	public List<ShopCart> queryEntity(String querySql) {
		try {
			List<ShopCart> shopCartList = (List<ShopCart>) dbOperator.query(
					hsqlConnectionProvider.get(), querySql,new ShopCartListResultSetHandler());
			
			 return shopCartList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	private static final String RemoveShopCartSqlCmd="DELETE FROM shopCart Where sessionId=?";
	public boolean removeEntity(ShopCart entity) {
		try {
			dbOperator.update(hsqlConnectionProvider.get(), RemoveShopCartSqlCmd, entity.getSessionId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	private static final String SaveShopCartSqlCmd="INSERT INTO shopCart (sessionId,userInfoId,userName,createDate,lastAcessDate,clientIP,totalPrice) VALUES (?,?,?,Now(),Now(),?,?)";
	public ShopCart saveAndLoadEntity(ShopCart entity) {

		Object[] params={
				entity.getSessionId(),
				entity.getUserInfoId(),
				entity.getUserName(),
				entity.getClientIP(),
				entity.getTotalPrice()
				
				 
		};
		try {
			dbOperator.update(hsqlConnectionProvider.get(), SaveShopCartSqlCmd, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loadEntity(entity.getSessionId());
	}

}
