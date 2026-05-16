package net.ittimeline.pandora.framework.common.util.web.spring;

import cn.hutool.extra.spring.SpringUtil;

import java.util.Objects;

/**
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 14:49
 * @since Java 25
 */
public class SpringUtils extends SpringUtil {
    /**
     * 是否为生产环境
     *
     * @return 是否生产环境
     */
    public static boolean isProd() {
        String activeProfile = getActiveProfile();
        return Objects.equals("prod", activeProfile);
    }

}
