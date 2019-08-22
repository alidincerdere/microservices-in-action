package com.thoughtmechanix.licensingservice.client;

import com.thoughtmechanix.licensingservice.models.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by adere on 22.08.2019.
 */
@FeignClient("organization-service")
public interface OrganizationFeignClient {

    @RequestMapping(value = "/v1/organizations/{organizationId}", method = RequestMethod.GET, consumes = "application/json")
    Organization getOrganization(@PathVariable("organizationId") String organizationId);
}
