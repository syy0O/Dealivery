package org.example.orders.global.adaptor.out;

import org.example.orders.domain.company.model.entity.Company;
import org.example.orders.domain.user.model.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://localhost:8000/api", contextId = "userServiceClientForOrders")
@Component
public interface UserServiceClient {

    @GetMapping("/user/user-idx")
    User getUserByIdx(@RequestParam Long userIdx);

    @GetMapping("/company/company-idx")
    Company getCompanyByIdx(@RequestParam Long companyIdx);

}
