package net.ittimeline.pandora.framework.common.util.foundational.collection;

import cn.hutool.core.collection.CollUtil;

import java.util.Set;

/**
 * Set集合工具类
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 14:39
 * @since Java 25
 */
public class SetUtils {
    @SafeVarargs
    public static <T> Set<T> asSet(T... objs) {
        return CollUtil.newHashSet(objs);
    }

}
