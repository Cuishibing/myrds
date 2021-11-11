package cui.shibing.rdsserver.config;

import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class QueryDslConfig {

    @Bean
    public com.querydsl.sql.Configuration configuration() {
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(MySQLTemplates.builder().build());
        configuration.addListener(new QueryDslLoggingSqlListener());
        configuration.setExceptionTranslator(new SpringExceptionTranslator());
        return configuration;
    }

    @Bean
    public SQLQueryFactory queryFactory(@Autowired DataSource dataSource, com.querydsl.sql.Configuration configuration) {
        return new SQLQueryFactory(configuration, new SpringConnectionProvider(dataSource));
    }

}
