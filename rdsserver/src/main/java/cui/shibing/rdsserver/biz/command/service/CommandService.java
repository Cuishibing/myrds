package cui.shibing.rdsserver.biz.command.service;

import cui.shibing.rdsserver.biz.command.dto.SqlExecuteParam;
import cui.shibing.rdsserver.biz.command.runner.Command;
import cui.shibing.rdsserver.biz.command.runner.CommandRunner;
import cui.shibing.rdsserver.biz.command.runner.Result;
import cui.shibing.rdsserver.biz.command.runner.result.parser.ResultParserFactory;
import cui.shibing.rdsserver.biz.dabatase.domain.RdsDatabaseInfo;
import cui.shibing.rdsserver.biz.dabatase.domain.factory.RdsDatabaseInfoFactory;
import cui.shibing.rdsserver.biz.dabatase.repository.RdsDatabaseInfoRepository;
import cui.shibing.rdsserver.common.BizException;
import cui.shibing.rdsserver.entity.TRdsDatabaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
@Transactional
public class CommandService {

    @Autowired
    private RdsDatabaseInfoRepository databaseInfoRepository;

    public Result execute(SqlExecuteParam param) throws SQLException {
        if (param.getDatabaseInfoId() == null) {
            throw new BizException("400", "数据id为null");
        }
        TRdsDatabaseInfo databaseStore = databaseInfoRepository.findById(param.getDatabaseInfoId());
        if (databaseStore == null) {
            throw new BizException("400", "数据库信息不存在");
        }
        RdsDatabaseInfo database = RdsDatabaseInfoFactory.createDomain(databaseStore);

        DataSource dataSource = database.createDataSource();
        CommandRunner commandRunner = CommandRunner.builder().dataSource(dataSource).parserFactory(ResultParserFactory.instance).build();
        return commandRunner.run(Command.query(param.getSql()));
    }

}
