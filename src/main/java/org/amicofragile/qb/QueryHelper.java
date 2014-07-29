package org.amicofragile.qb;

public class QueryHelper {

	public static Table table(String tableName) {
		return new Table(tableName);
	}

	public static SelectItem field(String fieldName) {
		return new SelectItem(fieldName);
	}

	public static SelectItem field(String fieldName, String alias) {
		return new SelectItem(fieldName, alias);
	}

	public static Table table(String tableName, String synonymous) {
		return new Table(tableName, synonymous);
	}

	public static SelectItem count() {
		return new SelectItem("count(*)");
	}
}
