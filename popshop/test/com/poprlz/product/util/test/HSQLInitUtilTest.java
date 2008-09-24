package com.poprlz.product.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.poprlz.product.util.HSQLInitUtil;

public class HSQLInitUtilTest {

	@Test
	public void testInitDBSQL() {
		HSQLInitUtil init=new HSQLInitUtil();
		init.initDBSQL();
		init.shutDownHsqlDB();
		
	}

}
