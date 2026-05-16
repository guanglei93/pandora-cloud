package net.ittimeline.pandora.framework.common.biz.system.oauth2;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.ittimeline.pandora.framework.common.biz.system.oauth2.dto.OAuth2AccessTokenCheckRespDTO;
import net.ittimeline.pandora.framework.common.constants.RpcConstants;
import net.ittimeline.pandora.framework.common.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * RPC 服务 - OAuth2.0 令牌
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 20:59
 * @since Java 25
 */
@FeignClient(name = RpcConstants.SYSTEM_NAME) // TODO 芋艿：fallbackFactory =
@Tag(name = "RPC 服务 - OAuth2.0 令牌")
public interface OAuth2TokenCommonApi {

    String PREFIX = RpcConstants.SYSTEM_PREFIX + "/oauth2/token";


    @GetMapping(PREFIX + "/check")
    @Operation(summary = "校验访问令牌")
    @Parameter(name = "accessToken", description = "访问令牌", required = true, example = "tudou")
    CommonResult<OAuth2AccessTokenCheckRespDTO> checkAccessToken(@RequestParam("accessToken") String accessToken);


}
