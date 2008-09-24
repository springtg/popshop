package com.poprlz.dao.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.poprlz.dao.HsqlDBTool;

public class HsqlDBToolTest {
	 

	@Test
	public void testGetConnection() throws SQLException {
		
		String sql="	CREATE TABLE shopCart( "+
		"	sessionId CHAR(100) NOT NULL PRIMARY KEY, "+
		"	userInfoId INTEGER NOT NULL, "+
		"	userName VARCHAR(100), "+
		"	createDate DATE, "+
		"	lastAcessDate DATE, "+
		"	clientIP CHAR(100), "+
		"	totalPrice DECIMAL(10,2) "+
		"	)";


		String sqlCmd="	CREATE TABLE SHOPCARTPRODUCTITEM( "+
		"	PRODUCTITEMID INTEGER NOT NULL IDENTITY PRIMARY KEY, "+
		"	SESSIONID CHAR(100) NOT NULL , "+
		"	PRODUCTID INTEGER NOT NULL, "+
		"	PRODUCTNAME VARCHAR(100), "+
		"	PRICE DECIMAL(10,2), "+
		"	ORDERQUANTITY INTEGER, "+
		"	DESCRIPTION LONGVARCHAR, "+
		"	WEIGHT DECIMAL(10,2), "+
		"	URL  VARCHAR(100), "+
		"	IMAGEID INTEGER, "+
		"	IMGPATH  VARCHAR(100)  "+
		"	)";
		
		QueryRunner dbOperator=new QueryRunner();
		
		dbOperator.update(HsqlDBTool.getConnection(), sql);
		dbOperator.update(HsqlDBTool.getConnection(), sqlCmd);
		dbOperator.update(HsqlDBTool.getConnection(), "SHUTDOWN");
		
		 
	}

	@Test
	public void testCloseConnection() {
		System.getProperty("user.dir");
		HsqlDBTool.close();
	}

}
