package dev.be.feign.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //데이터가 null인경우 null로 받는것이 아니라 아예 필드를 제외시킨다
public class BaseRequestInfo {
    private String name;
    private Long age;
}
