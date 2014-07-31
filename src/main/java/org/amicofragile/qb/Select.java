package org.amicofragile.qb;

import static org.amicofragile.qb.QueryHelper.field;
import static org.amicofragile.qb.QueryHelper.table;

import java.util.LinkedList;
import java.util.List;

import org.amicofragile.qb.dialect.SqlDialect;
import org.apache.commons.lang3.StringUtils;

public class Select implements Query {
	private final List<SelectItem> items;
	private List<String> from;

	public Select() {
		this.items = new LinkedList<SelectItem>();
	}

	public Select(String... fields) {
		this();
		for (String field : fields) {
			items.add(field(field));
		}
	}

	public Select(SimpleItem... items) {
		this();
		for (SimpleItem item : items) {
			this.items.add(item);
		}
	}

	public Query from(String first, String... others) {
		this.from = new LinkedList<String>();
		from.add(table(first).toSql());
		for (String other : others) {
			from.add(table(other).toSql());
		}
		return this;
	}

	public Query from(Table first, Table... other) {
		this.from = new LinkedList<String>();
		from.add(first.toSql());
		for (Table t : other) {
			from.add(t.toSql());
		}
		return this;
	}

	@Override
	public String getSql(SqlDialect dialect) {
		return String.format("select %s from %s", buildFieldsList(dialect),
				buildFromClause(dialect));
	}

	private String buildFromClause(SqlDialect dialect) {
		if (from == null) {
			throw new QueryBuilderException(
					"Error building 'select' statement: 'from' clause missing");
		}
		return StringUtils.join(from, ", ");
	}

	private String buildFieldsList(SqlDialect dialect) {
		if (items.isEmpty()) {
			return "*";
		}
		final List<String> itemsAsString = getItemsAsString(dialect);
		return StringUtils.join(itemsAsString, ", ");
	}

	private List<String> getItemsAsString(SqlDialect dialect) {
		final List<String> result = new LinkedList<String>();
		for (SelectItem item : items) {
			result.add(item.toSql(dialect));
		}
		return result;
	}
}
