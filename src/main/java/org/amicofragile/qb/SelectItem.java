package org.amicofragile.qb;

public class SelectItem {
	private final String item;

	public SelectItem(String item) {
		this.item = item;
	}
	
	public String toSql() {
		return item;
	}
}
