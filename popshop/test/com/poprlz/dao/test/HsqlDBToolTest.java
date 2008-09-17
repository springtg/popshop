package com.poprlz.dao.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.poprlz.dao.HsqlDBTool;

public class HsqlDBToolTest {
	HsqlDBTool tool=HsqlDBTool.getInstance();

	@Test
	public void testGetConnection() throws SQLException {
		tool.getConnection();
		
		 
	}

	@Test
	public void testCloseConnection() {
		tool.close();
	}

}
