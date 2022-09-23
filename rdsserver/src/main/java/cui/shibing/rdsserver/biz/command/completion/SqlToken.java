package cui.shibing.rdsserver.biz.command.completion;

import lombok.Data;

@Data
public class SqlToken {

    private int type;

    private String value;
}
