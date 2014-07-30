package org.amicofragile.qb;

public interface SelectItem {
	public abstract String toSql(SqlDialect dialect);
}
