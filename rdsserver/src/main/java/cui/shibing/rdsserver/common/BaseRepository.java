package cui.shibing.rdsserver.common;

import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.RelationalPath;
import com.querydsl.sql.dml.SQLDeleteClause;
import com.querydsl.sql.dml.SQLInsertClause;
import com.querydsl.sql.dml.SQLMergeClause;
import com.querydsl.sql.dml.SQLUpdateClause;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;

public class BaseRepository {

    @Autowired
    private MySQLTemplates templates;

    @Autowired
    private DataSource dataSource;

    @SneakyThrows
    private Connection getConnection() {
        return dataSource.getConnection();
    }

    public SQLUpdateClause update(RelationalPath<?> e){
        return new SQLUpdateClause(getConnection(), templates, e);
    }

    public SQLInsertClause insert(RelationalPath<?> e){
        return new SQLInsertClause(getConnection(), templates, e);
    }

    public SQLDeleteClause delete(RelationalPath<?> e){
        return new SQLDeleteClause(getConnection(), templates, e);
    }

    public SQLMergeClause merge(RelationalPath<?> e){
        return new SQLMergeClause(getConnection(), templates, e);
    }

}
