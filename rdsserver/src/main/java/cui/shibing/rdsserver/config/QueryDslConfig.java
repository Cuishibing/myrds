package cui.shibing.rdsserver.config;

import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class QueryDslConfig {

    @Bean
    public MySQLTemplates mySQLTemplates() {
        return new MySQLTemplates();
    }

    @Bean
    public com.querydsl.sql.Configuration configuration(@Autowired MySQLTemplates mySQLTemplates) {
        return new com.querydsl.sql.Configuration(mySQLTemplates);
    }

    @Bean
    public SQLQueryFactory queryFactory(@Autowired DataSource dataSource, com.querydsl.sql.Configuration configuration) {
        return new SQLQueryFactory(configuration, dataSource);
    }

}
