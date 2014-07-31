package org.amicofragile.qb.dialect;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SqlServerDialectTest {
	@Test
	public void concatWithPlusSymbol() throws Exception {
		SqlDialect dialect = new SqlServerDialect();
		assertEquals("L + R", dialect.concat("L", "R"));
	}
}
