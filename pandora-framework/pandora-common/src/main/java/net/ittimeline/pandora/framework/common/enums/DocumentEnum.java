package net.ittimeline.pandora.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文档地址
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 15:38
 * @since Java 25
 */
@Getter
@AllArgsConstructor
public enum DocumentEnum {
    REDIS_INSTALL("https://github.com/guanglei93/pandora-cloud/tree/framework-support/.qoder/repowiki/zh/content", "Redis 安装文档"),
    TENANT("https://github.com/guanglei93/pandora-cloud/tree/framework-support/.qoder/repowiki/zh/content", "SaaS 多租户文档");
    /**
     * 文档地址
     */
    private final String url;
    /**
     * 文档备注
     */
    private final String memo;
}
