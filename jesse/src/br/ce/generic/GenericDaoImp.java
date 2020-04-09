package br.ce.generic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = false)
@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public abstract class GenericDaoImp {

	public final JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate((DriverManagerDataSource) CustomApplicationContextAware.getBean("dataSource"));
	}

	public final Long save(final StringBuilder query) throws Exception {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				return connection.prepareStatement(query.toString(), new String[] { "cd_id" });
			}
		}, keyHolder);

		return new Long(keyHolder.getKey().longValue());
	}

	public final List<Map<String, Object>> executeSqlSelect(StringBuilder query) {
		return getJdbcTemplate().queryForList(query.toString());
	}

	public final void executeCommand(StringBuilder query) {
		getJdbcTemplate().execute(query.toString());
	}
}