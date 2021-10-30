package cui.shibing.rdsserver.biz.user;

import cui.shibing.rdsserver.biz.user.domain.factory.RdsUserFactory;
import cui.shibing.rdsserver.common.BizException;
import cui.shibing.rdsserver.biz.user.domain.RdsUser;
import cui.shibing.rdsserver.biz.user.dto.CreateUserParam;
import cui.shibing.rdsserver.biz.user.dto.CreateUserResult;
import cui.shibing.rdsserver.biz.user.repository.RdsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    public RdsUserRepository rdsUserRepository;

    public CreateUserResult createUser(CreateUserParam param) {
        long existUser = rdsUserRepository.countByAccount(param.getAccount());
        if (existUser > 0) {
            throw new BizException("failed", "duplicated account:" + param.getAccount());
        }

        RdsUser user = new RdsUser();
        user.init(param.getAccount(), param.getName());

        rdsUserRepository.insert(RdsUserFactory.createStore(user));

        CreateUserResult result = new CreateUserResult();
        result.setUserId(user.getId());
        result.setDefaultPassword(user.getPassword());

        return result;
    }

}
