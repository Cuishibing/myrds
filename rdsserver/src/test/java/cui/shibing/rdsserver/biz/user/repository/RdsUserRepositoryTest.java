package cui.shibing.rdsserver.biz.user.repository;

import cui.shibing.rdsserver.App;
import cui.shibing.rdsserver.entity.TRdsUser;
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
public class RdsUserRepositoryTest {

    @Autowired
    private RdsUserRepository repository;

    @Test
    public void testInsertAndFindById() {
        TRdsUser user = new TRdsUser();
        user.setName("fake_name");
        user.setAccount("fake_account");
        user.setCtime(System.currentTimeMillis());
        user.setUtime(System.currentTimeMillis());
        user.setPassword("fake_password");
        user.setValid(1);

        boolean insertResult = repository.insert(user);
        assertTrue(insertResult);

        TRdsUser dbUser = repository.findById(user.getId());
        assertNotNull(dbUser);
        assertEquals(user.getName(), dbUser.getName());
        assertEquals(user.getAccount(), dbUser.getAccount());
        assertEquals(user.getCtime(), dbUser.getCtime());
        assertEquals(user.getUtime(), dbUser.getUtime());
        assertEquals(user.getPassword(), dbUser.getPassword());
        assertEquals(user.getValid(), dbUser.getValid());
    }
}