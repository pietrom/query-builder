package org.amicofragile.qb;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConcatItemTest {
	@Test
	public void concatenatesItemsUsingDialectSpecs() throws Exception {
		final SqlDialect dialect = new SqlDialect() {
			public String concat(String x, String y) {
				return x + " ++ " + y;
			}
		};
		SelectItem item = new SimpleItem("XXX");
		SelectItem concat = new ConcatItem(item, item);
		assertEquals("XXX ++ XXX", concat.toSql(dialect));
	}
}
