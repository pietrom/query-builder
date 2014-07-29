package org.amicofragile.qb;

import org.apache.commons.lang3.StringUtils;

public class Select implements Query {
	private final String[] fields;
	private Table from;

	public Select(String... fields) {
		this.fields = fields;
	}

	public Query from(Table table) {
		this.from = table;
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
		return from.toSql();
	}

	private String buildFieldsList() {
		if (fields.length == 0) {
			return "*";
		}
		return StringUtils.join(fields, ", ");
	}
}
