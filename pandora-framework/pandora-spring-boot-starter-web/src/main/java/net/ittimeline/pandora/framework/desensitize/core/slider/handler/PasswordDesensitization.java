package net.ittimeline.pandora.framework.desensitize.core.slider.handler;

import net.ittimeline.pandora.framework.desensitize.core.slider.annotation.PasswordDesensitize;

/**
 * {@link PasswordDesensitize} 的码脱敏处理器
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:59
 * @since Java 25
 */
public class PasswordDesensitization extends AbstractSliderDesensitizationHandler<PasswordDesensitize> {
    @Override
    Integer getPrefixKeep(PasswordDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(PasswordDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(PasswordDesensitize annotation) {
        return annotation.replacer();
    }

}
