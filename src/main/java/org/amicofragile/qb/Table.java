package org.amicofragile.qb;

import org.apache.commons.lang3.StringUtils;

public class Table {
	private final String name;
	private final String synonymous;

	public Table(String tableName) {
		this(tableName, null);
	}

	public Table(String tableName, String synonymous) {
		this.name = tableName;
		this.synonymous = synonymous;
	}

	public String getSynonymous() {
		return synonymous;
	}

	public String getName() {
		return name;
	}

	public String toSql() {
		String sql = name;
		if (StringUtils.isNotEmpty(synonymous)) {
			sql += " " + synonymous;
		}
		return sql;
	}
}
