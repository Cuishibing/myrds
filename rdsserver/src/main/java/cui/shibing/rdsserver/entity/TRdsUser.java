package cui.shibing.rdsserver.entity;

import javax.annotation.Generated;

/**
 * TRdsUser is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class TRdsUser {

    private String account;

    private Long ctime;

    private Long id;

    private String name;

    private String password;

    private Long utime;

    private Integer valid;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

