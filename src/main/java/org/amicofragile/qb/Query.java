package org.amicofragile.qb;

import org.amicofragile.qb.dialect.SqlDialect;

public interface Query {
	public abstract String getSql(SqlDialect dialect);
}
