package com.gxzy.bigdata.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Description:
 * Created by wwquan on 2020/5/20 9:28
 */
@Configuration
@MapperScan(basePackages = {"com.gxzy.bigdata.user.dao", "com.gxzy.bigdata.einfo.dao"}, sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryDataSourceConfig {
    static final String MAPPER_LOCATION = "classpath*:**/mysqlsqlmap/*.xml";


    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;


    @Bean
    public SqlSessionFactory primarySqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(primaryDataSource); // 使用第一个数据源
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(PrimaryDataSourceConfig.MAPPER_LOCATION));
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(primarySqlSessionFactory()); // 使用上面配置的Factory
        return template;

    }
}
