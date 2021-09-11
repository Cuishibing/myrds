package cui.shibing.rdsserver.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BizResponse<T> {
    private String code;

    private String message;

    private T data;
}
