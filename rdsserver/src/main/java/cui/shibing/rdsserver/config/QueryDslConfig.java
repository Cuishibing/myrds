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
    public SQLQueryFactory queryFactory(@Autowired DataSource dataSource) {
        MySQLTemplates mySQLTemplates = new MySQLTemplates();
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(mySQLTemplates);
        return new SQLQueryFactory(configuration, dataSource);
    }

}
