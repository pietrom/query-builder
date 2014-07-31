package org.amicofragile.qb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class QueryHelperTest {
	private static final String SYNONYMOUS = "a_syn";
	private static final String TABLE_NAME = "a_table";

	@Test
	public void createTable() throws Exception {
		Table t = QueryHelper.table(TABLE_NAME);
		assertEquals(TABLE_NAME, t.getName());
		assertNull(t.getSynonymous());
	}

	@Test
	public void createTableProvidingSynonymous() throws Exception {
		Table t = QueryHelper.table(TABLE_NAME, SYNONYMOUS);
		assertEquals(TABLE_NAME, t.getName());
		assertEquals(SYNONYMOUS, t.getSynonymous());
	}
}
