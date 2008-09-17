package com.poprlz.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class HsqlDBTool {

	private static HsqlDBTool hsqlDBTool = null;

	public synchronized static HsqlDBTool getInstance() {
 		if (hsqlDBTool == null)
			hsqlDBTool = new HsqlDBTool();
		
		return hsqlDBTool;

	}

	private HsqlDBTool() {
		this.initHsqlDataSource();
	}

	private DataSource dataSource;

	public void initHsqlDataSource() {

		try {
			String dataPath=HsqlDBTool.class.getResource("/").getPath()+"databases/webshop";
			String url="jdbc:hsqldb:file:"+dataPath;
		
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
			DataSource unpooled = DataSources.unpooledDataSource(
					url, "sa", "");

			dataSource = DataSources.pooledDataSource(unpooled);

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConnection() throws SQLException {
		final Connection c = dataSource.getConnection();

		return c;
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	public void close() {
		try {
			DataSources.destroy(dataSource);
		} catch (SQLException sqle) {

		}
	}

}
