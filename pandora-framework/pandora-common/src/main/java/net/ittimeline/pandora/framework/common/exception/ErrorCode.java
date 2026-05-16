package net.ittimeline.pandora.framework.common.exception;

import lombok.Data;
import net.ittimeline.pandora.framework.common.exception.enums.GlobalErrorCodeConstants;
import net.ittimeline.pandora.framework.common.exception.enums.ServiceErrorCodeRange;

/**
 * 错误码对象
 * <p>
 * 全局错误码，占用 [0, 999], 参见 {@link GlobalErrorCodeConstants}
 * 业务异常错误码，占用 [1 000 000 000, +∞)，参见 {@link ServiceErrorCodeRange}
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 10:51
 * @since Java 25
 */
@Data
public class ErrorCode {
    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
