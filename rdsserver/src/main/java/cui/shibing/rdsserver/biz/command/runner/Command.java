package cui.shibing.rdsserver.biz.command.runner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Command {

    private CommandType type;

    private String sql;

    public static Command query(String sql) {
        Command command = new Command();
        command.type = CommandType.QUERY;
        command.sql = sql;
        return command;
    }

    public static Command update(String sql) {
        Command command = new Command();
        command.type = CommandType.UPDATE;
        command.sql = sql;
        return command;
    }

}
