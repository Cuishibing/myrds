package cui.shibing.rdsserver.biz.command.dto;

import lombok.Data;

@Data
public class SqlExecuteParam {
    private Long databaseInfoId;

    private String sql;
}
