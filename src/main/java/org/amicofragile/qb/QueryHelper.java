package org.amicofragile.qb;

public class QueryHelper {

	public static Table table(String tableName) {
		return new Table(tableName);
	}

	public static SimpleItem field(String fieldName) {
		return new SimpleItem(fieldName);
	}

	public static SimpleItem field(String fieldName, String alias) {
		return new SimpleItem(fieldName, alias);
	}

	public static Table table(String tableName, String synonymous) {
		return new Table(tableName, synonymous);
	}

	public static SimpleItem count() {
		return new SimpleItem("count(*)");
	}
}
