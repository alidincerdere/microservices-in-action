package com.thoughtmechanix.licensingservice.client;

import com.thoughtmechanix.licensingservice.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by adere on 22.08.2019.
 */
@Component
public class OrganizationRestTemplateClient {


    @Autowired
    RestTemplate restTemplate;

    public Organization getOrganization(String organizationId) {



        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        "http://organization-service/v1/organizations/{organizationId}",
                        HttpMethod.GET,
                        null, Organization.class, organizationId);

        return restExchange.getBody();
    }
}
