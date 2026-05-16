package net.ittimeline.pandora.framework.desensitize.core.slider.handler;

import net.ittimeline.pandora.framework.desensitize.core.slider.annotation.CarLicenseDesensitize;

/**
 * {@link CarLicenseDesensitize} 的脱敏处理器
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:52
 * @since Java 25
 */
public class CarLicenseDesensitization extends AbstractSliderDesensitizationHandler<CarLicenseDesensitize> {

    @Override
    Integer getPrefixKeep(CarLicenseDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(CarLicenseDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(CarLicenseDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    public String getDisable(CarLicenseDesensitize annotation) {
        return annotation.disable();
    }

}