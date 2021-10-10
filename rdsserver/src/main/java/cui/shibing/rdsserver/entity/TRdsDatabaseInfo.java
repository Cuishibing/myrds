package cui.shibing.rdsserver.entity;

import javax.annotation.Generated;

/**
 * TRdsDatabaseInfo is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class TRdsDatabaseInfo {

    private Long ctime;

    private String defaultDb;

    private String host;

    private Long id;

    private String password;

    private Integer port;

    private Long utime;

    private Integer valid;

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public String getDefaultDb() {
        return defaultDb;
    }

    public void setDefaultDb(String defaultDb) {
        this.defaultDb = defaultDb;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Long getUtime() {
        return utime;
    }

    public void setUtime(Long utime) {
        this.utime = utime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

}

