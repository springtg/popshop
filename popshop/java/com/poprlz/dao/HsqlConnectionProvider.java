package com.poprlz.dao;

import java.sql.SQLException;

import com.google.inject.Provider;

public class HsqlConnectionProvider<Conection> implements Provider<Conection> {

	public Conection get() {
		// TODO Auto-generated method stub
		try {
			return (Conection) HsqlDBTool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
