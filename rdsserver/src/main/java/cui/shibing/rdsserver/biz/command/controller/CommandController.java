package cui.shibing.rdsserver.biz.command.controller;

import cui.shibing.rdsserver.biz.command.dto.SqlExecuteParam;
import cui.shibing.rdsserver.biz.command.runner.CommandRunner;
import cui.shibing.rdsserver.biz.command.runner.Result;
import cui.shibing.rdsserver.biz.command.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/command")
public class CommandController {

    @Autowired
    private CommandService commandService;

    @PostMapping("/execute")
    public Result execute(@RequestBody SqlExecuteParam param) throws SQLException {
        return commandService.execute(param);
    }
}
