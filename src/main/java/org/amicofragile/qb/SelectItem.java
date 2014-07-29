package org.amicofragile.qb;

import org.apache.commons.lang3.StringUtils;

public class SelectItem {
	private final String item;
	private final String alias;

	public SelectItem(String item) {
		this(item, null);
	}

	public SelectItem(String item, String alias) {
		this.item = item;
		this.alias = alias;
	}

	public String toSql() {
		String sql = item;
		if (StringUtils.isNotEmpty(alias)) {
			sql = String.format("%s as %s", item, alias);
		}
		return sql;
	}
}
