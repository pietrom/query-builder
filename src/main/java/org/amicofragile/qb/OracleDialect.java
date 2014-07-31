package org.amicofragile.qb;

public class OracleDialect implements SqlDialect {
	@Override
	public String concat(String left, String right) {
		return String.format("concat(%s, %s)", left, right);
	}
}
