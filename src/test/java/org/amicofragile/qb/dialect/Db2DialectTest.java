package org.amicofragile.qb.dialect;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Db2DialectTest {
	@Test
	public void concatWithPlusSymbol() throws Exception {
		SqlDialect dialect = new Db2Dialect();
		assertEquals("concat(L, R)", dialect.concat("L", "R"));
	}
}
