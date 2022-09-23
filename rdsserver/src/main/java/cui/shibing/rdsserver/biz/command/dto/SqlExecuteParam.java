package cui.shibing.rdsserver.biz.command.dto;

import lombok.Data;

import java.util.List;

@Data
public class SqlExecuteParam {
    private Long databaseInfoId;

    private String sql;

    private List<String> excludeFields;
}
