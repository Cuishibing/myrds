package cui.shibing.rdsserver.user.entity;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;

@QueryEntity
@Data
public class RdsUserEntity {
    private long id;

    /**
     * 账号，用户登录
     */
    private String account;

    /**
     * 名称
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    private Integer valid;

    private Long ctime;

    private Long utime;
}
