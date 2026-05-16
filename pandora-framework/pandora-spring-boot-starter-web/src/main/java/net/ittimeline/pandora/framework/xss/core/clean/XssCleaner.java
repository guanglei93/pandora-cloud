package net.ittimeline.pandora.framework.xss.core.clean;

/**
 * 对 html 文本中的有 Xss 风险的数据进行清理
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 19:46
 * @since Java 25
 */
public interface XssCleaner {

    /**
     * 清理有 Xss 风险的文本
     *
     * @param html 原 html
     * @return 清理后的 html
     */
    String clean(String html);
}
