package net.ittimeline.pandora.framework.desensitize.core.regex.handler;

import net.ittimeline.pandora.framework.desensitize.core.regex.annotation.EmailDesensitize;

/**
 * {@link EmailDesensitize} 的脱敏处理器
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:45
 * @since Java 25
 */
public class EmailDesensitizationHandler extends AbstractRegexDesensitizationHandler<EmailDesensitize> {

    @Override
    String getRegex(EmailDesensitize annotation) {
        return annotation.regex();
    }

    @Override
    String getReplacer(EmailDesensitize annotation) {
        return annotation.replacer();

    }
}
