package cui.shibing.rdsserver.biz.command.runner.result.parser;

import cui.shibing.rdsserver.biz.command.runner.CommandType;
import cui.shibing.rdsserver.biz.command.runner.Result;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class ResultSetResultParser implements ResultParser {
    @Override
    public Set<CommandType> supportCommandType() {
        Set<CommandType> supportType = new HashSet<>();
        supportType.add(CommandType.QUERY);
        return supportType;
    }

    @Override
    public Result parse(Object t) throws SQLException {
        if (!(t instanceof ResultSet)) {
            throw new IllegalArgumentException("param is not instance of ResultSet");
        }
        ResultSet resultSet = (ResultSet) t;
        Result result = new Result();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        List<String> columnNames = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }
        result.setColumnNames(columnNames);

        List<List<String>> rows = new ArrayList<>();

        while (resultSet.next()) {
            List<String> row = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(Objects.toString(resultSet.getObject(i)));
            }
            rows.add(row);
        }

        result.setRows(rows);
        return result;
    }
}
