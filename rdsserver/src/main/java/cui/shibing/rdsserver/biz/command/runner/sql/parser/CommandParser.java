package cui.shibing.rdsserver.biz.command.runner.sql.parser;

import cui.shibing.rdsserver.biz.command.runner.Command;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CommandParser {
    public Command parse(String sql) {
        if (StringUtils.isBlank(sql)) {
            throw new IllegalArgumentException("sql is blank");
        }

        if (sql.contains("update") || sql.contains("delete") || sql.contains("insert")) {
            return Command.update(sql);
        }
        return Command.query(sql);
    }
}
