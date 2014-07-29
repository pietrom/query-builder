package org.amicofragile.qb;

public class Table {
	private final String name;
	private final String synonymous;

	public Table(String tableName) {
		this(tableName, null);
	}

	public Table(String tableName, String synonymous) {
		this.name = tableName;
		this.synonymous = synonymous;
	}

	public String getSynonymous() {
		return synonymous;
	}

	public String getName() {
		return name;
	}
}
