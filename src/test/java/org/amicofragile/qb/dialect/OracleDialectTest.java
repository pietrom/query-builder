package org.amicofragile.qb.dialect;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OracleDialectTest {
	@Test
	public void concatWithPlusSymbol() throws Exception {
		SqlDialect dialect = new OracleDialect();
		assertEquals("concat(L, R)", dialect.concat("L", "R"));
	}
}
