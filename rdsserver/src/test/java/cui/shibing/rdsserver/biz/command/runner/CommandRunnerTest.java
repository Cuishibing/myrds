package cui.shibing.rdsserver.biz.command.runner;

import cui.shibing.rdsserver.App;
import cui.shibing.rdsserver.biz.command.runner.parser.ResultParserFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootTest(classes = App.class)
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@Transactional
@Rollback
public class CommandRunnerTest {

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {
        commandRunner = new CommandRunner(dataSource, ResultParserFactory.instance);
    }

    private CommandRunner commandRunner;

    @Test
    public void runQueryCommand() throws SQLException {
        Command command = Command.query("show variables like '%name'");

        Result result = commandRunner.run(command);

        System.out.println(result);
    }
}