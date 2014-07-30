package org.amicofragile.qb;

public class ConcatItem implements SelectItem {
	private final SelectItem left, right;

	public ConcatItem(SelectItem left, SelectItem right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toSql(SqlDialect dialect) {
		return dialect.concat(left.toSql(dialect), right.toSql(dialect));
	}
}
