package org.example.auth.global.adaptor.out;

import org.example.auth.domain.user.model.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "${custom.feign-url}", contextId = "userServiceClientForAuth")
@Component
public interface UserServiceClient {

    @PostMapping("/user/user-email")
    User getUserByEmail(@RequestBody String email);
}
