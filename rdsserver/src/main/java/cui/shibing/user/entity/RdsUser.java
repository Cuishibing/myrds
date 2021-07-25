package cui.shibing.user.entity;

import lombok.Data;

@Data
public class RdsUser {
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
}
