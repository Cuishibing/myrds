package cui.shibing.rdsserver.biz.command.runner.parser;

import cui.shibing.rdsserver.biz.command.runner.CommandType;
import cui.shibing.rdsserver.biz.command.runner.Result;

import java.sql.SQLException;

public interface ResultParser {
    CommandType supportCommandType();

    Result parse(Object t) throws SQLException;
}
