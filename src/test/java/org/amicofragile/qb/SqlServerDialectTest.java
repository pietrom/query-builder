package org.amicofragile.qb;

import static org.junit.Assert.*;

import org.junit.Test;

public class SqlServerDialectTest {
	@Test
	public void concatWithPlusSymbol() throws Exception {
		SqlDialect dialect = new SqlServerDialect();
		assertEquals("L + R", dialect.concat("L", "R"));
	}
}
