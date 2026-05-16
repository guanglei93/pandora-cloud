package net.ittimeline.pandora.framework.common.exception.util;

import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import net.ittimeline.pandora.framework.common.exception.ErrorCode;
import net.ittimeline.pandora.framework.common.exception.ServiceException;
import net.ittimeline.pandora.framework.common.exception.enums.GlobalErrorCodeConstants;

/**
 * 业务逻辑异常工具类
 * 目的在于，格式化异常信息提示。
 * 考虑到 String.format 在参数不正确时会报错，因此使用 {} 作为占位符，并使用 {@link #doFormat(int, String, Object...)} 方法来格式化
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 11:04
 * @since Java 25
 */
@Slf4j
public class ServiceExceptionUtil {
    // ========== 和 ServiceException 的集成 ==========

    public static ServiceException exception(ErrorCode errorCode) {
        return exception0(errorCode.getCode(), errorCode.getMsg());
    }

    public static ServiceException exception(ErrorCode errorCode, Object... params) {
        return exception0(errorCode.getCode(), errorCode.getMsg(), params);
    }

    public static ServiceException exception0(Integer code, String messagePattern, Object... params) {
        String message = doFormat(code, messagePattern, params);
        return new ServiceException(code, message);
    }

    public static ServiceException invalidParamException(String messagePattern, Object... params) {
        return exception0(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), messagePattern, params);
    }

    // ========== 格式化方法 ==========

    /**
     * 将错误编号对应的消息使用 params 进行格式化。
     *
     * @param code           错误编号
     * @param messagePattern 消息模版
     * @param params         参数
     * @return 格式化后的提示
     */
    @VisibleForTesting//这个方法本来应该是私有的，但为了测试才提升了可见性，不要在业务代码中调用它
    public static String doFormat(int code, String messagePattern, Object... params) {
        // 预分配 StringBuilder 容量，避免扩容开销
        StringBuilder sbuf = new StringBuilder(messagePattern.length() + 50);
        int i = 0;  // 当前处理位置
        int j;      // 占位符位置
        int l;      // 参数索引
        // 遍历所有参数，逐个替换 {} 占位符
        for (l = 0; l < params.length; l++) {
            j = messagePattern.indexOf("{}", i);
            if (j == -1) {
                // 占位符不足，记录错误并返回已处理部分
                log.error("[doFormat][参数过多：错误码({})|错误内容({})|参数({})", code, messagePattern, params);
                if (i == 0) {
                    return messagePattern;
                } else {
                    sbuf.append(messagePattern.substring(i));
                    return sbuf.toString();
                }
            } else {
                // 替换占位符：复制占位符前的内容，追加参数值
                sbuf.append(messagePattern, i, j);
                sbuf.append(params[l]);
                i = j + 2;  // 跳过 {} 占位符
            }
        }
        // 检查是否还有未替换的占位符
        if (messagePattern.indexOf("{}", i) != -1) {
            log.error("[doFormat][参数过少：错误码({})|错误内容({})|参数({})", code, messagePattern, params);
        }
        // 追加剩余部分
        sbuf.append(messagePattern.substring(i));
        return sbuf.toString();
    }

}
