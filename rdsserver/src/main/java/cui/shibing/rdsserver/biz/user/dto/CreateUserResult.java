package cui.shibing.rdsserver.biz.user.dto;

import lombok.Data;

@Data
public class CreateUserResult {
    private Long userId;

    private String defaultPassword;
}
