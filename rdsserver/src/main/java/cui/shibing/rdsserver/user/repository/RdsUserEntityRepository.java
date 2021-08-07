package cui.shibing.rdsserver.user.repository;

import com.mysql.cj.xdevapi.Expression;
import com.querydsl.core.Tuple;
import com.querydsl.sql.SQLBindings;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.mysql.MySQLQueryFactory;
import cui.shibing.rdsserver.user.entity.QRdsUserEntity;
import cui.shibing.rdsserver.user.entity.RdsUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class RdsUserEntityRepository {

    @Autowired
    private SQLQueryFactory queryFactory;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RdsUserEntity findById(long id) {
        if (id == 0) {
            return null;
        }

        QRdsUserEntity table = new QRdsUserEntity("t_rds_user");



        return null;

    };

}
