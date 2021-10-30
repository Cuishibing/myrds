package cui.shibing.rdsserver.config;

import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.function.Supplier;

public class MConnectionProvider implements Supplier<Connection> {
    private final DataSource dataSource;

    public MConnectionProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection get() {
        return DataSourceUtils.getConnection(this.dataSource);
    }
}
