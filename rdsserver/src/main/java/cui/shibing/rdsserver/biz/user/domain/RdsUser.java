package cui.shibing.rdsserver.biz.user.domain;

import cui.shibing.rdsserver.common.BizException;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Random;

@Getter
@Setter
public class RdsUser  {

    private String account;

    private Long ctime;

    private Long id;

    private String name;

    private String password;

    private Long utime;

    private Integer valid;

    public RdsUser newRdsUser(String account, String name) {
        this.setAccount(account);
        this.setName(name);

        this.setCtime(System.currentTimeMillis());
        this.setValid(1);

        String defaultPassword = Math.abs(new Random().nextInt(999999)) + "";
        this.setPassword(defaultPassword);

        return this;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (Objects.equals(oldPassword, this.getPassword())) {
            throw new BizException("error", "old password is error");
        }

        this.setPassword(newPassword);
    }
}
