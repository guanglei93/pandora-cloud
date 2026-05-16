package net.ittimeline.pandora.framework.common.biz.infra.logger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import net.ittimeline.pandora.framework.common.biz.infra.logger.dto.ApiAccessLogCreateReqDTO;
import net.ittimeline.pandora.framework.common.constants.RpcConstants;
import net.ittimeline.pandora.framework.common.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * RPC 服务 - API 访问日志
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 18:30
 * @since Java 25
 */
@FeignClient(name = RpcConstants.INFRA_NAME) // TODO 芋艿：fallbackFactory =
@Tag(name = "RPC 服务 - API 访问日志")
public interface ApiAccessLogCommonApi {
    String PREFIX = RpcConstants.INFRA_PREFIX + "/api-access-log";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "创建 API 访问日志")
    CommonResult<Boolean> createApiAccessLog(@Valid @RequestBody ApiAccessLogCreateReqDTO createDTO);

    /**
     * 【异步】创建 API 访问日志
     *
     * @param createDTO 访问日志 DTO
     */
    @Async
    default void createApiAccessLogAsync(ApiAccessLogCreateReqDTO createDTO) {
        createApiAccessLog(createDTO).checkError();
    }
}
