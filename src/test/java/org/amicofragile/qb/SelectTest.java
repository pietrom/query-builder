package org.amicofragile.qb;

import static org.junit.Assert.*;
import static org.amicofragile.qb.QueryHelper.*;

import org.junit.Test;

public class SelectTest {
	@Test(expected=QueryBuilderException.class)
	public void selectWithoutFromResultsInException() throws Exception {
		Query select = new Select("a", "b", "c");
		select.getSql();
	}
	
	@Test
	public void selectGivenFieldsFromGivenTable() throws Exception {
		Query select = new Select("a", "b", "c").from(table("a_table"));
		String sql = select.getSql();
		assertEquals("select a, b, c from a_table", sql);
	}
	
	@Test
	public void selectStarFromGivenTable() throws Exception {
		Query select = new Select().from(table("a_table"));
		String sql = select.getSql();
		assertEquals("select * from a_table", sql);
	}
}
