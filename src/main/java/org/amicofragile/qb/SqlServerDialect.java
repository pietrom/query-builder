package org.amicofragile.qb;

public class SqlServerDialect implements SqlDialect {

	@Override
	public String concat(String left, String right) {
		return String.format("%s + %s", left, right);
	}
}
