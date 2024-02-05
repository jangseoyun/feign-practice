package dev.be.feign.feign.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        if (template.method() == Request.HttpMethod.GET.name()) {
            //해당 요청에서 사용하는 query를 모두 가져온다.
            System.out.println("get DemoFeignInterceptor: queries : " + template.queries());
            return;
        }

        //post 요청일 경우
        String encodedRequestBody = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);
        System.out.println("post: DemoFeignInterceptor | requestBody : " + encodedRequestBody);

        //추가적으로 필요한 로직을 추가

        String convertRequestBody = encodedRequestBody;
        template.body(convertRequestBody);
    }
}
