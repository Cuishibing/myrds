package cui.shibing.rdsserver.biz.command.completion;

import lombok.Data;

@Data
public class CompletionParam {
    private Long dbId;

    private String input;

    private Integer cursorIndex;
}
