package cui.shibing.rdsserver.biz.dabatase.repository;

import cui.shibing.rdsserver.App;
import cui.shibing.rdsserver.entity.TRdsDatabaseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@SpringBootTest(classes = App.class)
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@Transactional
@Rollback
public class RdsDatabaseInfoRepositoryTest {

    @Autowired
    private RdsDatabaseInfoRepository rdsDatabaseInfoRepository;

    @Test
    public void testInsert() {
        TRdsDatabaseInfo info = new TRdsDatabaseInfo();
        info.setName("localhost");
        info.setUserName("root");
        info.setPassword("root");
        info.setDefaultDb("rdsdb");
        info.setHost("localhost");
        info.setPort(3306);
        info.setCtime(System.currentTimeMillis());
        info.setUtime(System.currentTimeMillis());
        info.setValid(1);
        boolean insert = rdsDatabaseInfoRepository.insert(info);
        assertTrue(insert);
    }

}