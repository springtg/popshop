package com.poprlz.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.poprlz.product.entity.ProductImage;
import com.poprlz.product.web.ProductInfoView;

public class ProductInfoViewResultSetHandler implements ResultSetHandler {

	public Object handle(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<ProductInfoView> productInfoViewList = new ArrayList<ProductInfoView>();
		ProductImage productImage = null;
		ProductInfoView productInfoView = null;
		while (rs.next()) {
			// "SELECT prd.productId,prd.quantity,prd.model, prd.productName,
			// prd.price,prd.dateAdded,prd.lastModified, prd.dateAvailable,
			// prd.description, prd.weight, prd.URL, prd.stutas, prd.taxId,
			// prd.manufacturerId, prd.viewed, prd.ordered ,"
			// +
			// " prdImg.imageId,prdImg.path,prdImg.alt,prdImg.content,prdImg.mark "
			productInfoView = new ProductInfoView();
			productInfoView.setProductId(rs.getInt("productId"));
			productInfoView.setQuantity(rs.getInt("quantity"));
			productInfoView.setModel(rs.getString("model"));
			productInfoView.setProductName(rs.getString("productName"));

			// prd.price,prd.dateAdded,prd.lastModified, prd.dateAvailable,
			productInfoView.setPrice(rs.getBigDecimal("price"));
			productInfoView.setDateAdded(rs.getDate("dateAdded"));
			productInfoView.setLastModified(rs.getDate("lastModified"));
			productInfoView.setDateAvailable(rs.getDate("dateAvailable"));

			// prd.description, prd.weight, prd.URL, prd.stutas, prd.taxId,
			productInfoView.setDescription(rs.getString("description"));
			productInfoView.setWeight(rs.getBigDecimal("weight"));
			productInfoView.setURL(rs.getString("URL"));
			productInfoView.setStutas(rs.getInt("stutas"));

			// prd.manufacturerId, prd.viewed, prd.ordered ,"
			productInfoView.setViewed(rs.getInt("viewed"));
			productInfoView.setOrdered(rs.getInt("ordered"));

			// +
			// " prdImg.imageId,prdImg.path,prdImg.alt,prdImg.content,prdImg.mark "
			productImage = new ProductImage();
			productImage.setImageId(rs.getInt("imageId"));
			productImage.setContent(rs.getString("content"));
			productImage.setMark(rs.getString("mark"));
			productImage.setAlt(rs.getString("alt"));
			productImage.setPath(rs.getString("path"));

			productInfoView.setProductImage(productImage);
			productInfoViewList.add(productInfoView);

		}
		return productInfoViewList;
	}

}
