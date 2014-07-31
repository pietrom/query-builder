package org.amicofragile.qb.dialect;

public class OracleDialect implements SqlDialect {
	@Override
	public String concat(String left, String right) {
		return String.format("concat(%s, %s)", left, right);
	}
}
