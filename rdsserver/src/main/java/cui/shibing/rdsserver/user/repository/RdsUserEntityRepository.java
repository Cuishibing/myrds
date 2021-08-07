package cui.shibing.rdsserver.user.repository;

import com.querydsl.sql.SQLQueryFactory;
import cui.shibing.rdsserver.common.BaseRepository;
import cui.shibing.rdsserver.entity.QTRdsUser;
import cui.shibing.rdsserver.entity.TRdsUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RdsUserEntityRepository extends BaseRepository {

    @Autowired
    private SQLQueryFactory queryFactory;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TRdsUser findById(long id) {
        if (id == 0) {
            return null;
        }
        QTRdsUser table = QTRdsUser.tRdsUser;
        return queryFactory.selectFrom(table).where(table.id.eq(id)).fetchOne();
    };

}
