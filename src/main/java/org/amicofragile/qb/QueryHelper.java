package org.amicofragile.qb;

public class QueryHelper {

	public static Table table(String tableName) {
		return new Table(tableName);
	}

	public static Table table(String tableName, String synonymous) {
		return new Table(tableName, synonymous);
	}
}
