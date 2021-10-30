package cui.shibing.rdsserver.biz.dabatase.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RdsDatabaseInfo {

    private Long ctime;

    private String defaultDb;

    private String host;

    private Long id;

    private String name;

    private String password;

    private Integer port;

    private String userName;

    private Long utime;

    private Integer valid;

    public void createNew(String name, String host, int port, String userName, String password, String defaultDb) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;

        this.defaultDb = defaultDb;

        this.ctime = System.currentTimeMillis();
        this.utime = System.currentTimeMillis();

        this.valid = 1;
    }

    public void updateInfo(String name, String host, int port, String userName, String password, String defaultDb) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.defaultDb = defaultDb;

        this.utime = System.currentTimeMillis();
    }
}
