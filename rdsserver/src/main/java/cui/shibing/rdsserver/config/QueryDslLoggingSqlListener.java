package cui.shibing.rdsserver.config;

import com.querydsl.sql.SQLBaseListener;
import com.querydsl.sql.SQLBindings;
import com.querydsl.sql.SQLListenerContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueryDslLoggingSqlListener extends SQLBaseListener {

    @Override
    public void end(SQLListenerContext context) {
        SQLBindings sqlBindings = context.getSQLBindings();
        log.info(sqlBindings.getSQL() + sqlBindings.getNullFriendlyBindings());
    }
}
