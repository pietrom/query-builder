package org.amicofragile.qb;

import java.util.LinkedList;
import static org.amicofragile.qb.QueryHelper.*;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Select implements Query {
	private final List<String> items;
	private List<String> from;

	public Select() {
		this.items = new LinkedList<String>();
	}

	public Select(String... fields) {
		this();
		for (String field : fields) {
			items.add(field(field).toSql());
		}
	}

	public Select(SelectItem... items) {
		this();
		for (SelectItem item : items) {
			this.items.add(item.toSql());
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
	public String getSql() {
		return String.format("select %s from %s", buildFieldsList(), buildFromClause());
	}

	private String buildFromClause() {
		if (from == null) {
			throw new QueryBuilderException("Error building 'select' statement: 'from' clause missing");
		}

		return StringUtils.join(from, ", ");
	}

	private String buildFieldsList() {
		if (items.isEmpty()) {
			return "*";
		}
		return StringUtils.join(items, ", ");
	}
}
