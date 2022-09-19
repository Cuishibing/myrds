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
        instance.register(new UpdateResultParser());
    }


    public void register(ResultParser parser) {
        for (CommandType commandType : parser.supportCommandType()) {
            parserRegistry.put(commandType, parser);
        }
    }

    public ResultParser create(CommandType type) {
        return parserRegistry.get(type);
    }

}
