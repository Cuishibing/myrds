package cui.shibing.rdsserver.biz.command.runner.result.parser;

import cui.shibing.rdsserver.biz.command.runner.CommandType;

import java.util.HashMap;
import java.util.Map;

public class ResultParserFactory {

    private ResultParserFactory(){}

    public static final ResultParserFactory instance = new ResultParserFactory();

    private static final Map<CommandType, ResultParser> parserRegistry = new HashMap<>();

    static {
        instance.register(new ResultSetResultParser());
    }


    public void register(ResultParser parser) {
        parserRegistry.put(parser.supportCommandType(), parser);
    }

    public ResultParser create(CommandType type) {
        return parserRegistry.get(type);
    }

}
