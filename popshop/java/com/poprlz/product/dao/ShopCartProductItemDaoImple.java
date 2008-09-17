package com.poprlz.product.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.google.inject.Inject;
import com.poprlz.dao.HsqlConnectionProvider;
import com.poprlz.product.web.bean.ShopCartProductItem;

public class ShopCartProductItemDaoImple implements IShopCartProductItemDao {
	@Inject
	private HsqlConnectionProvider<Connection> hsqlConnectionProvider;

	@Inject
	private QueryRunner dbOperator;

	private static final String LoadProuctItemSQL = "SELECT PRODUCTITEMID,SESSIONID,PRODUCTID,PRODUCTNAME,PRICE,ORDERQUANTITY,DESCRIPTION,WEIGHT,URL,IMAGEID,IMGPATH  FROM SHOPCARTPRODUCTITEM Where PRODUCTITEMID=?";

	public ShopCartProductItem loadEntity(Integer productId) {

		ShopCartProductItem shopCartProductItem = null;
		try {
			List<ShopCartProductItem> shopCartProductItemList = (List<ShopCartProductItem>) dbOperator
					.query(hsqlConnectionProvider.get(), LoadProuctItemSQL,
							productId,
							new ShopCartProductItemListResultSetHandler());

			if (!(shopCartProductItemList == null || shopCartProductItemList
					.size() < 1)) {
				shopCartProductItem = shopCartProductItemList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shopCartProductItem;
	}

	private static final String UpdateProuctItemSQL = "UPDATE SHOPCARTPRODUCTITEM SET SESSIONID=?,PRODUCTID=?,PRODUCTNAME=?,PRICE=?,ORDERQUANTITY=?,DESCRIPTION=?,WEIGHT=?,URL=?,IMAGEID=?,IMGPATH=?   Where PRODUCTITEMID=?";

	public ShopCartProductItem modifyEntity(ShopCartProductItem entity) {
		Object[] params = {
				entity.getSessionId(),
				entity.getProductId(),
				entity.getProductName(),
				// PRODUCTNAME=?,PRICE=?,ORDERQUANTITY=?,DESCRIPTION=?,WEIGHT=?,
				// URL=?,IMAGEID=?,IMGPATH=?
				entity.getPrice(), entity.getOrderQuantity(),
				entity.getDescription(), entity.getWeight(), entity.getURL(),
				entity.getImageId(), entity.getImgPath(),
				entity.getProductItemId()

		};
		try {
			dbOperator.update(hsqlConnectionProvider.get(),
					UpdateProuctItemSQL, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loadEntity(entity.getProductItemId());
	}

	public List<ShopCartProductItem> queryEntity(String querySql) {
		try {
			List<ShopCartProductItem> shopCartProductItemList = (List<ShopCartProductItem>) dbOperator
					.query(hsqlConnectionProvider.get(), querySql,
							new ShopCartProductItemListResultSetHandler());

			return shopCartProductItemList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private static final String QueryProuctItemBySessionIdSQL = "SELECT PRODUCTITEMID,SESSIONID,PRODUCTID,PRODUCTNAME,PRICE,ORDERQUANTITY,DESCRIPTION,WEIGHT,URL,IMAGEID,IMGPATH  FROM SHOPCARTPRODUCTITEM Where SESSIONID=?";

	public List<ShopCartProductItem> queryEntityBySessionId(String sessionId) {
		try {
			List<ShopCartProductItem> shopCartProductItemList = (List<ShopCartProductItem>) dbOperator
					.query(hsqlConnectionProvider.get(),
							QueryProuctItemBySessionIdSQL, sessionId,
							new ShopCartProductItemListResultSetHandler());

			return shopCartProductItemList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static final String RemoveProuctItemSQL = "DELETE FROM  SHOPCARTPRODUCTITEM    Where PRODUCTITEMID=? ";

	public boolean removeEntity(ShopCartProductItem entity) {
		try {
			dbOperator.update(hsqlConnectionProvider.get(),
					RemoveProuctItemSQL, entity.getProductItemId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static final String RemoveProuctItemBySessionIdSQL = "DELETE FROM  SHOPCARTPRODUCTITEM    Where SESSIONID=? ";

	public boolean removeEntityBySsssionId(ShopCartProductItem entity) {
		try {
			dbOperator.update(hsqlConnectionProvider.get(),
					RemoveProuctItemSQL, entity.getSessionId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static final String SaveProuctItemSQL = "INSERT INTO SHOPCARTPRODUCTITEM(SESSIONID,PRODUCTID,PRODUCTNAME,PRICE,ORDERQUANTITY,DESCRIPTION,WEIGHT,URL,IMAGEID,IMGPATH) VALUES(?,?,?,?,?,?,?,?,?,?)";

	public int saveAndLoadEntity(ShopCartProductItem entity) {
		Object[] params = {
				entity.getSessionId(),
				entity.getProductId(),
				entity.getProductName(),
				// PRODUCTNAME=?,PRICE=?,ORDERQUANTITY=?,DESCRIPTION=?,WEIGHT=?,
				// URL=?,IMAGEID=?,IMGPATH=?
				entity.getPrice(), entity.getOrderQuantity(),
				entity.getDescription(), entity.getWeight(), entity.getURL(),
				entity.getImageId(), entity.getImgPath()

		};
		int result = 0;
		try {
			result = dbOperator.update(hsqlConnectionProvider.get(),
					SaveProuctItemSQL, params);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
