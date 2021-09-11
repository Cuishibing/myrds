package cui.shibing.rdsserver.biz.user.repository;

import com.querydsl.sql.SQLQueryFactory;
import cui.shibing.rdsserver.entity.QTRdsUser;
import cui.shibing.rdsserver.entity.TRdsUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RdsUserRepository {

    @Autowired
    private SQLQueryFactory queryFactory;

    public TRdsUser findById(long id) {
        if (id == 0) {
            return null;
        }
        QTRdsUser table = QTRdsUser.tRdsUser;
        return queryFactory.selectFrom(table).where(table.id.eq(id)).fetchOne();
    }

    public long countByAccount(String account) {
        if (account == null || "".equals(account)) {
            return 0;
        }
        QTRdsUser table = QTRdsUser.tRdsUser;
        return queryFactory.selectFrom(table).where(table.account.eq(account)).fetchCount();
    }

    public boolean insert(TRdsUser user) {
        if (user == null) {
            return false;
        }
        QTRdsUser table = QTRdsUser.tRdsUser;
        Long id = queryFactory.insert(table).populate(user).executeWithKey(table.id);
        user.setId(id);

        return id != null;
    }

}
