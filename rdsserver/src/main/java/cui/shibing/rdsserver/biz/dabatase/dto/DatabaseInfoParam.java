package cui.shibing.rdsserver.biz.dabatase.dto;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class DatabaseInfoParam {
    private Long id;
    private String name;

    private String host;
    private Integer port;
    private String defaultDb;

    private String userName;
    private String password;

    public String validateCreateScene() {
        if (StringUtils.isBlank(name)) {
            return "名称不能为空";
        }
        if (StringUtils.isBlank(host)) {
            return "Host不能为空";
        }
        if (port == null || port <=0) {
            return "Port不能为空，且不能小于0";
        }
        if (StringUtils.isBlank(defaultDb)) {
            return "默认db不能为空";
        }
        if (StringUtils.isBlank(userName)) {
            return "Username不能为空";
        }
        if (StringUtils.isBlank(password)) {
            return "密码不能为空";
        }
        return null;
    }

    public String validateUpdateScene() {
        if (id == null || id <=0) {
            return "id不能为空，且不能小于0";
        }
        return validateCreateScene();
    }
}
