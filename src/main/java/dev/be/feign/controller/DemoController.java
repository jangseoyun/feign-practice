package dev.be.feign.controller;

import dev.be.feign.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final DemoService demoService;

    @GetMapping("/get")
    public String getController() {
        demoService.get();
        return "get";
    }

    @GetMapping("/post")
    public String postController() {
        demoService.post();
        return "post";
    }

    @GetMapping("/error")
    public String errorController() {
        demoService.errorDecoder();
        return "error";
    }
}
