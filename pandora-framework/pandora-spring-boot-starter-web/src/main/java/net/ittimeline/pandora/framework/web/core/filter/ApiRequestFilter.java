package net.ittimeline.pandora.framework.web.core.filter;

import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.ittimeline.pandora.framework.web.config.WebProperties;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 过滤 /admin-api、/app-api 等 API 请求的过滤器
 * @author tony 18601767221@163.com
 * @version 2026/5/16 18:05
 * @since Java 25
 */
@RequiredArgsConstructor
public abstract class ApiRequestFilter extends OncePerRequestFilter {

    protected final WebProperties webProperties;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // 只过滤 API 请求的地址
        String apiUri = request.getRequestURI().substring(request.getContextPath().length());
        return !StrUtil.startWithAny(apiUri, webProperties.getAdminApi().getPrefix(), webProperties.getAppApi().getPrefix());
    }

}