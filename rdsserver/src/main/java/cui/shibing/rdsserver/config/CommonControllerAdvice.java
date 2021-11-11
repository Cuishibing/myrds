package cui.shibing.rdsserver.config;

import cui.shibing.rdsserver.common.BizException;
import cui.shibing.rdsserver.common.BizResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@ControllerAdvice
public class CommonControllerAdvice implements ResponseBodyAdvice<Object> {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BizResponse<String> runtimeException(Exception e) {
        log.error("catch exception:", e);
        return new BizResponse<>("500", "Internal Error!", e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(BizException.class)
    public BizResponse<String> bizException(BizException e) {
        log.error("catch exception:", e);
        return new BizResponse<>(e.getCode(), e.getMessage(), "");
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (selectedContentType.isCompatibleWith(MediaType.APPLICATION_JSON)) {
            if (body instanceof BizResponse || BizException.class.isAssignableFrom(body.getClass())) {
                return body;
            } else {
                return new BizResponse<>("200", "success", body);
            }
        }
        return body;
    }
}
