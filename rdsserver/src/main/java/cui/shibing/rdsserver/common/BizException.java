package cui.shibing.rdsserver.common;

import lombok.Getter;

public class BizException extends RuntimeException {

    @Getter
    private String code;

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }
}
