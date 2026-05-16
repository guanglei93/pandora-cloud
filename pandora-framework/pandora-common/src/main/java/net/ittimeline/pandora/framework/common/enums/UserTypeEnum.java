package net.ittimeline.pandora.framework.common.enums;

import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.ittimeline.pandora.framework.common.core.ArrayValuable;

import java.util.Arrays;

/**
 * 全局用户类型枚举
 * @author tony 18601767221@163.com
 * @version 2026/5/16 15:45
 * @since Java 25
 */
@AllArgsConstructor
@Getter
public enum UserTypeEnum implements ArrayValuable<Integer> {
    /**
     * 面向 c 端，普通用户
     */
    MEMBER(1, "会员"),
    /**
     * 面向 b 端，管理后台
     */
    ADMIN(2, "管理员");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(UserTypeEnum::getValue).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer value;
    /**
     * 类型名
     */
    private final String name;

    public static UserTypeEnum valueOf(Integer value) {
        return ArrayUtil.firstMatch(userType -> userType.getValue().equals(value), UserTypeEnum.values());
    }

    @Override
    public Integer[] array() {
        return ARRAYS;
    }
}
