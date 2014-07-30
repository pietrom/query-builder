package org.amicofragile.qb;

import static org.junit.Assert.*;
import static org.amicofragile.qb.QueryHelper.*;

import org.junit.Test;

public class SelectTest {
	@Test(expected = QueryBuilderException.class)
	public void selectWithoutFromResultsInException() throws Exception {
		Query select = new Select("a", "b", "c");
		select.getSql(null);
	}

	@Test
	public void selectGivenFieldsFromGivenTable() throws Exception {
		Query select = new Select("a", "b", "c").from(table("a_table"));
		String sql = select.getSql(null);
		assertEquals("select a, b, c from a_table", sql);
	}

	@Test
	public void selectCountFromGivenTable() throws Exception {
		Query select = new Select(count()).from(table("a_table"));
		String sql = select.getSql(null);
		assertEquals("select count(*) from a_table", sql);
	}

	@Test
	public void selectFieldsWithAlias() throws Exception {
		Query select = new Select(field("a", "aa"), field("b", "bb")).from(table("a_table"));
		String sql = select.getSql(null);
		assertEquals("select a as aa, b as bb from a_table", sql);
	}

	@Test
	public void selectGivenFieldsFromGivenTableUsingSelectItemModel() throws Exception {
		Query select = new Select(field("a"), field("b"), field("c")).from(table("a_table"));
		String sql = select.getSql(null);
		assertEquals("select a, b, c from a_table", sql);
	}

	@Test
	public void selectGivenFieldsFromGivenTableName() throws Exception {
		Query select = new Select("a", "b", "c").from("a_table");
		String sql = select.getSql(null);
		assertEquals("select a, b, c from a_table", sql);
	}

	@Test
	public void selectGivenFieldsFromGivenTableNames() throws Exception {
		Query select = new Select("a", "b", "c").from("a_table", "b_table");
		String sql = select.getSql(null);
		assertEquals("select a, b, c from a_table, b_table", sql);
	}

	@Test
	public void selectStarFromGivenTable() throws Exception {
		Query select = new Select().from(table("a_table"));
		String sql = select.getSql(null);
		assertEquals("select * from a_table", sql);
	}

	@Test
	public void selectStarFromGivenTableUsingSynonymous() throws Exception {
		Query select = new Select().from(table("a_table", "a_syn"));
		String sql = select.getSql(null);
		assertEquals("select * from a_table a_syn", sql);
	}

	@Test
	public void selectStarFromMultipleTablesUsingSynonymous() throws Exception {
		Query select = new Select().from(table("a_table", "a_syn"), table("b_table", "b_syn"), table("c_table", "c_syn"));
		String sql = select.getSql(null);
		assertEquals("select * from a_table a_syn, b_table b_syn, c_table c_syn", sql);
	}
}
