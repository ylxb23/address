package com.zero.address.app.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * dataSource
 * @date 2018年1月10日 下午5:24:04
 * @author zero
 */
@Configuration
@MapperScan(basePackages= {"com.zero.address.dao"})
public class DataSourceConfigure {
	
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix="datasource.mysql")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources("classpath:/mappers/*.xml"));
		return bean.getObject();
	}
	
	@Bean(name="dataSourceTransactionManager")
	public DataSourceTransactionManager firstDataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
}
