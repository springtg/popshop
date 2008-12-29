package com.poprlz.product.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import java.net.URL;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.poprlz.dao.HsqlDBTool;

public class HSQLInitUtil {

	private static String resource = "/webshopHsqlInit.sql";

	public boolean initDBSQL() {

		try {
			URL url = this.getClass().getResource(resource);

			StringBuffer buffer = new StringBuffer();

			BufferedReader read = new BufferedReader(new FileReader(url.getFile()));
			
			String readData=read.readLine();
			
			while(readData!=null){
				buffer.append(readData);
				readData=read.readLine();
			}
			
			String[] sqlCmd=buffer.toString().split(";");
			
			 
			
			QueryRunner dbOperator=new QueryRunner();
			
			for(int i=0;i<sqlCmd.length;i++){
				System.out.println(sqlCmd[i]);
				dbOperator.update(HsqlDBTool.getConnection(), sqlCmd[i]);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		// url.getFile()

		return true;
	}
	
	public boolean shutDownHsqlDB(){
		
		 
		QueryRunner dbOperator=new QueryRunner();
		
		try {
			dbOperator.update(HsqlDBTool.getConnection(), "SHUTDOWN");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}

}
