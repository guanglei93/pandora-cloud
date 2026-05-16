package net.ittimeline.pandora.framework.security.core.rpc;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import net.ittimeline.pandora.framework.common.util.web.json.JsonUtils;
import net.ittimeline.pandora.framework.security.core.LoginUser;
import net.ittimeline.pandora.framework.security.core.util.SecurityFrameworkUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * d
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 21:12
 * @since Java 25
 */
@Slf4j
public class LoginUserRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        LoginUser user = SecurityFrameworkUtils.getLoginUser();
        if (user == null) {
            return;
        }
        try {
            String userStr = JsonUtils.toJsonString(user);
            userStr = URLEncoder.encode(userStr, StandardCharsets.UTF_8); // 编码，避免中文乱码
            requestTemplate.header(SecurityFrameworkUtils.LOGIN_USER_HEADER, userStr);
        } catch (Exception ex) {
            log.error("[apply][序列化 LoginUser({}) 发生异常]", user, ex);
            throw ex;
        }
    }

}