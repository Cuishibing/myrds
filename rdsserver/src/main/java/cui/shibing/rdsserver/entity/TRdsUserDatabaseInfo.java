package cui.shibing.rdsserver.entity;

import javax.annotation.Generated;

/**
 * TRdsUserDatabaseInfo is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class TRdsUserDatabaseInfo {

    private Long ctime;

    private Long databaseInfoId;

    private Long id;

    private Long userId;

    private Long utime;

    private Integer valid;

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getDatabaseInfoId() {
        return databaseInfoId;
    }

    public void setDatabaseInfoId(Long databaseInfoId) {
        this.databaseInfoId = databaseInfoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

