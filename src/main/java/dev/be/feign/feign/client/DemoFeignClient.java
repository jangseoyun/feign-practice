package dev.be.feign.feign.client;

import dev.be.feign.common.dto.BaseResponseInfo;
import dev.be.feign.config.DemoFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "demo-client", //pk
        url = "${feign.url.prefix}", //target이 되는 서버의 url 값 (일반적으로는 yaml로 관리)
        configuration = DemoFeignConfig.class //적용할 configration
)
public interface DemoFeignClient {

    @GetMapping("/get") //-> http://localhost:8080/target_server/get
    ResponseEntity<BaseResponseInfo> callGet(@RequestHeader("CustomHeaderName") String customHeader,
                                             @RequestParam("name") String name,
                                             @RequestParam("age") Long age);
}
