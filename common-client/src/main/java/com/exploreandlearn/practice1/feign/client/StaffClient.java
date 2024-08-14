package com.exploreandlearn.practice1.feign.client;

import com.exploreandlearn.practice1.feign.model.StaffResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "STAFFAPPLICATION", path = "/api/v1/staff")
public interface StaffClient {

    @GetMapping(value = "/getBySection", produces = "application/json")
    public StaffResponse getBySection(@RequestParam("section") String section);
}
