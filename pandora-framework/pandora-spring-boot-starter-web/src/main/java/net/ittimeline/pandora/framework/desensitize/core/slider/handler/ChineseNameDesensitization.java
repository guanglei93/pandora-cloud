package net.ittimeline.pandora.framework.desensitize.core.slider.handler;

import net.ittimeline.pandora.framework.desensitize.core.slider.annotation.ChineseNameDesensitize;

/**
 * {@link ChineseNameDesensitize} 的脱敏处理器
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:54
 * @since Java 25
 */
public class ChineseNameDesensitization extends AbstractSliderDesensitizationHandler<ChineseNameDesensitize> {

    @Override
    Integer getPrefixKeep(ChineseNameDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(ChineseNameDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(ChineseNameDesensitize annotation) {
        return annotation.replacer();
    }

}

