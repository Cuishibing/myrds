package cui.shibing.rdsserver.biz.command.runner;

import lombok.Builder;
import lombok.Getter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Getter
@Builder
public class CommandRunner {
    private String host;
    private String user;
    private String password;
    private String db;

    public Result runCommand(Command command) {
        Statement statement = createStatement();


    }

    private Statement createStatement() {
        return null;
    }
}
