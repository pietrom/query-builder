package org.amicofragile.qb;

import java.util.LinkedList;
import static org.amicofragile.qb.QueryHelper.*;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Select implements Query {
	private final String[] fields;
	private List<String> from;

	public Select(String... fields) {
		this.fields = fields;
	}

	public Query from(String first, String... others) {
		this.from = new LinkedList<String>();
		from.add(table(first).toSql());
		Table[] o = new Table[others.length];
		for (String other : others) {
			from.add(table(other).toSql());
		}
		return this;
	}

	public Query from(Table first, Table... other) {
		this.from = new LinkedList<String>();
		from.add(first.toSql());
		for (Table t : other) {
			from.add(t.toSql());
		}
		return this;
	}

	@Override
	public String getSql() {
		return String.format("select %s from %s", buildFieldsList(), buildFromClause());
	}

	private String buildFromClause() {
		if (from == null) {
			throw new QueryBuilderException("Error building 'select' statement: 'from' clause missing");
		}

		return StringUtils.join(from, ", ");
	}

	private String buildFieldsList() {
		if (fields.length == 0) {
			return "*";
		}
		return StringUtils.join(fields, ", ");
	}
}
