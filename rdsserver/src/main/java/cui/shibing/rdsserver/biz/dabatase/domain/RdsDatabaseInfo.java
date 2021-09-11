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

    private Long userId;

    private Long utime;

    private Integer valid;


}
