package org.amicofragile.qb;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueryHelperTest {
	@Test
	public void createTable() throws Exception {
		Table t = QueryHelper.table("a_table");
		assertEquals("a_table", t.getName());
		assertNull(t.getSynonymous());
	}

	@Test
	public void createTableProvidingSynonymous() throws Exception {
		Table t = QueryHelper.table("a_table", "a_syn");
		assertEquals("a_table", t.getName());
		assertEquals("a_syn", t.getSynonymous());
	}
}
