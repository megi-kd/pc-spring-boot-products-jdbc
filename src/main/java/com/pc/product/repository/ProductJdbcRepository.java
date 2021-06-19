package com.pc.product.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.pc.product.controller.ProductParams;
import com.pc.product.model.ProductResource;

@Repository
public class ProductJdbcRepository {

	private static final Logger log = LoggerFactory.getLogger(ProductJdbcRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private ProductRowMapper rowMapper = new ProductRowMapper();

	public List<ProductResource> findByProductParams(ProductParams params) {
		StringBuilder sqlQuery = new StringBuilder(" SELECT * FROM product ");
		String conditions = appendQueryCondition(params);
		if (conditions != null && !conditions.isEmpty()) {
			sqlQuery.append(" WHERE ");
			sqlQuery.append(conditions);
		}

		log.info("SQL:[{}] ", sqlQuery);
		return jdbcTemplate.query(sqlQuery.toString(), rowMapper);
	}

	/**
	 * Adding additional conditions based on ProductParams
	 * 
	 * @param ProductParams params
	 * @return String for sql_WHERE part
	 */
	private String appendQueryCondition(ProductParams params) {

		StringBuilder appendQuery = new StringBuilder();
		if (!ObjectUtils.isEmpty(params.getType())) {
			appendQuery.append(" type = '").append(params.getType()).append("'");
		}
		if (!ObjectUtils.isEmpty(params.getMin_price())) {
			if (appendQuery.length() > 0) {
				appendQuery.append(" AND ");
			}
			appendQuery.append(" price >= ").append(params.getMin_price());
		}
		if (!ObjectUtils.isEmpty(params.getMax_price())) {
			if (appendQuery.length() > 0) {
				appendQuery.append(" AND ");
			}
			appendQuery.append(" price <= ").append(params.getMax_price());
		}
		if (!ObjectUtils.isEmpty(params.getCity())) {
			if (appendQuery.length() > 0) {
				appendQuery.append(" AND ");
			}
			appendQuery.append(" city = '").append(params.getCity()).append("' ");
		}
		if (params.getProperty() != null) {
			if (!ObjectUtils.isEmpty(params.getProperty().getName())) {
				if (appendQuery.length() > 0) {
					appendQuery.append(" AND ");
				}
				appendQuery.append(" property_name = '").append(params.getProperty().getName()).append("' ");
			}
			if (!ObjectUtils.isEmpty(params.getProperty().getColor())) {
				if (appendQuery.length() > 0) {
					appendQuery.append(" AND property_name = 'color' ");
				} else {
					appendQuery.append(" property_name = 'color' ");
				}
				appendQuery.append(" AND property_value = '").append(params.getProperty().getColor()).append("' ");

			}
			if (!ObjectUtils.isEmpty(params.getProperty().getGb_limit_max())) {
				if (appendQuery.length() > 0) {
					appendQuery.append(" AND ");
				}
				appendQuery.append(" CAST (CASEWHEN ( property_name = 'gb_limit' , property_value, 0 ) AS INT ) <= ")
							.append(params.getProperty().getGb_limit_max());

			}
			if (!ObjectUtils.isEmpty(params.getProperty().getGb_limit_min())) {
				if (appendQuery.length() > 0) {
					appendQuery.append(" AND ");
				} 
				appendQuery.append(" CAST (CASEWHEN ( property_name = 'gb_limit' , property_value, 0 ) AS INT ) >= ")
							.append(params.getProperty().getGb_limit_min());
			}
		}

		return appendQuery.toString();
	}

	private class ProductRowMapper implements RowMapper<ProductResource> {

		@Override
		public ProductResource mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductResource p = new ProductResource();
			p.setType(rs.getString("type"));
			p.setProperties(rs.getString("properties"));
			p.setPrice(rs.getString("price"));
			p.setStoreAddress(rs.getString("store_address"));
			return p;
		}
	}
}
