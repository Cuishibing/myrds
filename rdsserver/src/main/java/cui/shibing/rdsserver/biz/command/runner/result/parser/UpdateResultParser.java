package cui.shibing.rdsserver.biz.command.runner.result.parser;

import cui.shibing.rdsserver.biz.command.runner.CommandType;
import cui.shibing.rdsserver.biz.command.runner.Result;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UpdateResultParser implements ResultParser {
    @Override
    public Set<CommandType> supportCommandType() {
        Set<CommandType> supportType = new HashSet<>();
        supportType.add(CommandType.UPDATE);
        return supportType;
    }

    @Override
    public Result parse(Object t) throws SQLException {
        if (!(t instanceof Integer)) {
            throw new IllegalArgumentException("param is not instance of Integer");
        }
        Integer count = (Integer) t;
        Result result = new Result();


        List<String> columnNames = new ArrayList<>();
        columnNames.add("Count");
        result.setColumnNames(columnNames);

        List<List<String>> rows = new ArrayList<>();

        List<String> row = new ArrayList<>();
        row.add(String.valueOf(count));
        rows.add(row);

        result.setRows(rows);
        return result;
    }
}
