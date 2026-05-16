package net.ittimeline.pandora.framework.desensitize.core.slider.handler;

import net.ittimeline.pandora.framework.desensitize.core.slider.annotation.BankCardDesensitize;

/**
 * {@link BankCardDesensitize} 的脱敏处理器
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:50
 * @since Java 25
 */
public class BankCardDesensitization extends AbstractSliderDesensitizationHandler<BankCardDesensitize> {

    @Override
    Integer getPrefixKeep(BankCardDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(BankCardDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(BankCardDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    public String getDisable(BankCardDesensitize annotation) {
        return "";
    }

}
