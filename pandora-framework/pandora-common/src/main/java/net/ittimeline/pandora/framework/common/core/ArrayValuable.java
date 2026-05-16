package net.ittimeline.pandora.framework.common.core;

/**
 * 可生成 T 数组的接口
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 13:59
 * @since Java 25
 */
public interface ArrayValuable<T> {
    /**
     * @return 数组
     */
    T[] array();
}
