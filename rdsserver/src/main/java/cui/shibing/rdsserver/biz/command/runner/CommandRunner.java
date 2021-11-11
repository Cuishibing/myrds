package cui.shibing.rdsserver.biz.command.runner;

import cui.shibing.rdsserver.biz.command.runner.parser.ResultParserFactory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Setter
@Getter
@Builder
public class CommandRunner {

    private DataSource dataSource;

    private ResultParserFactory parserFactory;

    public Result run(Command command) throws SQLException {
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {
            CommandType type = command.getType();
            switch (type) {
                case QUERY: {
                    ResultSet resultSet = statement.executeQuery(command.getSql());
                    return parserFactory.create(type).parse(resultSet);
                }
                case UPDATE: {
                    int count = statement.executeUpdate(command.getSql());
                    return parserFactory.create(type).parse(count);
                }
                default:
                    throw new IllegalArgumentException("un supported command type:" + type.name());
            }
        }
    }

}
