package cui.shibing.rdsserver.user.domain.factory;

import cui.shibing.rdsserver.entity.TRdsUser;
import cui.shibing.rdsserver.user.domain.RdsUser;

import cui.shibing.rdsserver.user.repository.RdsUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RdsUserFactory  {

    @Autowired
    private RdsUserEntityRepository repository;

    public RdsUser load(long id) {
        TRdsUser tRdsUser = repository.findById(id);

        return null;
    }
}
