package cui.shibing.rdsserver.biz.dabatase.repository;

import com.querydsl.sql.SQLQueryFactory;
import cui.shibing.rdsserver.entity.QTRdsDatabaseInfo;
import cui.shibing.rdsserver.entity.TRdsDatabaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RdsDatabaseInfoRepository {

    @Autowired
    private SQLQueryFactory queryFactory;

    public boolean insert(TRdsDatabaseInfo info) {
        if (info == null) {
            return false;
        }

        QTRdsDatabaseInfo table = QTRdsDatabaseInfo.tRdsDatabaseInfo;
        Long id = queryFactory.insert(table).populate(info).executeWithKey(table.id);
        info.setId(id);

        return id != null;
    }

    public boolean delete(Long id) {
        if (id == null) {
            return false;
        }

        QTRdsDatabaseInfo table = QTRdsDatabaseInfo.tRdsDatabaseInfo;

        return queryFactory.delete(table).where(table.id.eq(id)).execute() == 1;
    }

    public boolean logicDelete(Long id) {
        if (id == null) {
            return false;
        }
        QTRdsDatabaseInfo table = QTRdsDatabaseInfo.tRdsDatabaseInfo;

        return queryFactory.update(table).set(table.valid, 0).where(table.id.eq(id)).execute() == 1;
    }
}
