package net.ittimeline.pandora.framework.common.biz.system.logger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import net.ittimeline.pandora.framework.common.biz.system.logger.dto.OperateLogCreateReqDTO;
import net.ittimeline.pandora.framework.common.constants.RpcConstants;
import net.ittimeline.pandora.framework.common.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * d
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 21:20
 * @since Java 25
 */
@FeignClient(name = RpcConstants.SYSTEM_NAME, primary = false) // TODO 芋艿：fallbackFactory =
@Tag(name = "RPC 服务 - 操作日志")
public interface OperateLogCommonApi {

    String PREFIX = RpcConstants.SYSTEM_PREFIX + "/operate-log";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "创建操作日志")
    CommonResult<Boolean> createOperateLog(@Valid @RequestBody OperateLogCreateReqDTO createReqDTO);

    /**
     * 【异步】创建操作日志
     *
     * @param createReqDTO 请求
     */
    @Async
    default void createOperateLogAsync(OperateLogCreateReqDTO createReqDTO) {
        createOperateLog(createReqDTO).checkError();
    }

}