package cui.shibing.rdsserver.biz.user.domain.factory;

import cui.shibing.rdsserver.biz.user.domain.RdsUser;
import cui.shibing.rdsserver.entity.TRdsUser;

public class RdsUserFactory {


    public static RdsUser createDomain(TRdsUser tRdsUser) {
        if (tRdsUser == null) {
            return null;
        }
        RdsUser rdsUser = new RdsUser();

        rdsUser.setAccount(tRdsUser.getAccount());
        rdsUser.setCtime(tRdsUser.getCtime());
        rdsUser.setId(tRdsUser.getId());
        rdsUser.setName(tRdsUser.getName());
        rdsUser.setPassword(tRdsUser.getPassword());
        rdsUser.setUtime(tRdsUser.getUtime());
        rdsUser.setValid(tRdsUser.getValid());

        return rdsUser;
    }

    public static TRdsUser createStore(RdsUser rdsUser) {
        if (rdsUser == null) {
            return null;
        }

        TRdsUser tRdsUser = new TRdsUser();

        tRdsUser.setAccount(rdsUser.getAccount());
        tRdsUser.setCtime(rdsUser.getCtime());
        tRdsUser.setId(rdsUser.getId());
        tRdsUser.setName(rdsUser.getName());
        tRdsUser.setPassword(rdsUser.getPassword());
        tRdsUser.setUtime(rdsUser.getUtime());
        tRdsUser.setValid(rdsUser.getValid());

        return tRdsUser;
    }
}
