package com.poprlz.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

 

import com.mchange.v2.c3p0.DataSources;

public class HsqlDBTool {

	private static HsqlDBTool hsqlDBTool = null;

	public static final ThreadLocal<Connection> threadConnection = new ThreadLocal<Connection>();
 
	private static DataSource dataSource;

	public static void initHsqlDataSource() {

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

	public static  Connection getConnection() throws SQLException {
		 Connection c =threadConnection.get();
		 if(c==null){
			 if(dataSource==null)
				 initHsqlDataSource();
				 
			 c = dataSource.getConnection();
			 threadConnection.set(c);
		 }

		return c;
	}
	
	public static  boolean closeConnection(){
		
		 Connection conn =threadConnection.get();
		 if(conn!=null){
			 try {
				closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 threadConnection.set(null);
		 
		 return true;
			 
		
	}

	public static  void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	public static  void close() {
		try {
			DataSources.destroy(dataSource);
		} catch (SQLException sqle) {

		}
	}

}
