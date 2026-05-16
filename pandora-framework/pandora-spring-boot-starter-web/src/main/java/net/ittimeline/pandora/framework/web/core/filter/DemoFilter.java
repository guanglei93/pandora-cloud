package net.ittimeline.pandora.framework.web.core.filter;

import cn.hutool.core.util.StrUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.ittimeline.pandora.framework.common.pojo.CommonResult;
import net.ittimeline.pandora.framework.common.util.web.servlet.ServletUtils;
import net.ittimeline.pandora.framework.web.core.util.WebFrameworkUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import static net.ittimeline.pandora.framework.common.exception.enums.GlobalErrorCodeConstants.DEMO_DENY;

/**
 * 演示 Filter，禁止用户发起写操作，避免影响测试数据
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 18:09
 * @since Java 25
 */
public class DemoFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String method = request.getMethod();
        return !StrUtil.equalsAnyIgnoreCase(method, "POST", "PUT", "DELETE")  // 写操作时，不进行过滤率
                || WebFrameworkUtils.getLoginUserId(request) == null; // 非登录用户时，不进行过滤
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        // 直接返回 DEMO_DENY 的结果。即，请求不继续
        ServletUtils.writeJSON(response, CommonResult.error(DEMO_DENY));
    }

}
