package org.example.auth.global.adaptor.out;

import org.example.auth.domain.company.model.dto.CompanyDto;
import org.example.auth.domain.company.model.entity.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "company-service", url = "${custom.feign-url}", contextId = "companyServiceClientForAuth")
@Component
public interface CompanyServiceClient {

    @GetMapping("/company/company-email")
    Company getCompanyByEmail(@RequestParam("email") String email);
}