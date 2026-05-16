package net.ittimeline.pandora.framework.desensitize.core.regex.handler;

import net.ittimeline.pandora.framework.desensitize.core.regex.annotation.RegexDesensitize;

/**
 * {@link RegexDesensitize} 的正则脱敏处理器
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:43
 * @since Java 25
 */
public class DefaultRegexDesensitizationHandler extends AbstractRegexDesensitizationHandler<RegexDesensitize> {

    @Override
    String getRegex(RegexDesensitize annotation) {
        return annotation.regex();
    }

    @Override
    String getReplacer(RegexDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    public String getDisable(RegexDesensitize annotation) {
        return annotation.disable();
    }

}
