package cui.shibing.rdsserver.biz.command.runner;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Result {

    private List<String> columnNames;

    private List<List<String>> rows;
}
