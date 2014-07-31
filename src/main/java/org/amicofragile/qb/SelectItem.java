package org.amicofragile.qb;

import org.amicofragile.qb.dialect.SqlDialect;

public interface SelectItem {
	public abstract String toSql(SqlDialect dialect);
}
