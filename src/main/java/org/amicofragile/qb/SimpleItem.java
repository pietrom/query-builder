package org.amicofragile.qb;

import org.amicofragile.qb.dialect.SqlDialect;
import org.apache.commons.lang3.StringUtils;

public class SimpleItem implements SelectItem {
	private final String item;
	private final String alias;

	public SimpleItem(String item) {
		this(item, null);
	}

	public SimpleItem(String item, String alias) {
		this.item = item;
		this.alias = alias;
	}

	public String toSql(SqlDialect dialect) {
		String sql = item;
		if (StringUtils.isNotEmpty(alias)) {
			sql = String.format("%s as %s", item, alias);
		}
		return sql;
	}
}
