package cui.shibing.rdsserver.biz.dabatase.domain.factory;

import cui.shibing.rdsserver.biz.dabatase.domain.RdsDatabaseInfo;
import cui.shibing.rdsserver.entity.TRdsDatabaseInfo;

public class RdsDatabaseInfoFactory {

    public static RdsDatabaseInfo createDomain(TRdsDatabaseInfo store) {
        if (store == null) {
            return null;
        }

        RdsDatabaseInfo domain = new RdsDatabaseInfo();

        domain.setName(store.getName());
        domain.setCtime(store.getCtime());
        domain.setDefaultDb(store.getDefaultDb());
        domain.setHost(store.getHost());
        domain.setId(store.getId());
        domain.setUserName(store.getUserName());
        domain.setPassword(store.getPassword());
        domain.setPort(store.getPort());
        domain.setUtime(store.getUtime());
        domain.setValid(store.getValid());

        return domain;
    }

    public static TRdsDatabaseInfo createStore(RdsDatabaseInfo domain) {
        TRdsDatabaseInfo store = new TRdsDatabaseInfo();

        store.setName(domain.getName());
        store.setCtime(domain.getCtime());
        store.setDefaultDb(domain.getDefaultDb());
        store.setHost(domain.getHost());
        store.setId(domain.getId());
        store.setUserName(domain.getUserName());
        store.setPassword(domain.getPassword());
        store.setPort(domain.getPort());
        store.setUtime(domain.getUtime());
        store.setValid(domain.getValid());

        return store;
    }
}
