package cui.shibing.rdsserver.user.domain.factory;

import cui.shibing.rdsserver.entity.TRdsUser;
import cui.shibing.rdsserver.user.domain.RdsUser;

import cui.shibing.rdsserver.user.repository.TRdsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RdsUserFactory  {

    @Autowired
    private TRdsUserRepository repository;

    public RdsUser load(long id) {
        TRdsUser tRdsUser = repository.findById(id);

        return null;
    }
}
