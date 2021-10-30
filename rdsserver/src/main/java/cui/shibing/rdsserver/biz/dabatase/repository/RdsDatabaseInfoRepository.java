package cui.shibing.rdsserver.biz.dabatase.repository;

import com.querydsl.sql.SQLQueryFactory;
import cui.shibing.rdsserver.entity.QTRdsDatabaseInfo;
import cui.shibing.rdsserver.entity.TRdsDatabaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RdsDatabaseInfoRepository {

    @Autowired
    private SQLQueryFactory queryFactory;

    public TRdsDatabaseInfo findById(long id) {
        QTRdsDatabaseInfo table = QTRdsDatabaseInfo.tRdsDatabaseInfo;
        return queryFactory.selectFrom(table).where(table.id.eq(id).and(table.valid.eq(1))).fetchOne();
    }

    public boolean insert(TRdsDatabaseInfo info) {
        if (info == null) {
            return false;
        }

        QTRdsDatabaseInfo table = QTRdsDatabaseInfo.tRdsDatabaseInfo;
        Long id = queryFactory.insert(table).populate(info).executeWithKey(table.id);
        info.setId(id);

        return id != null;
    }

    public boolean update(TRdsDatabaseInfo info) {
        if (info == null) {
            return false;
        }
        QTRdsDatabaseInfo table = QTRdsDatabaseInfo.tRdsDatabaseInfo;
        long count = queryFactory.update(table).populate(info).where(table.id.eq(info.getId())).execute();
        return count > 0;
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

    public List<TRdsDatabaseInfo> findAll() {
        QTRdsDatabaseInfo table = QTRdsDatabaseInfo.tRdsDatabaseInfo;
        return queryFactory.selectFrom(table).where(table.valid.eq(1)).fetch();
    }

    public TRdsDatabaseInfo findByName(String name) {
        QTRdsDatabaseInfo table = QTRdsDatabaseInfo.tRdsDatabaseInfo;
        return queryFactory.selectFrom(table).where(table.name.eq(name).and(table.valid.eq(1))).fetchOne();
    }

}
