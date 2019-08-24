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
                        "http://organization-service/v1/organizations/{organizationId}", //we have the applicationId it the URL
                        HttpMethod.GET,
                        null, Organization.class, organizationId);
        //The Ribbon-enabled RestTemplate will parse the URL passed into it and use whatever is passed in as the server
        //name as the key to query Ribbon for an instance of a service. The actual service location and port are
        //completely abstracted from the developer.

        //In addition, by using the RestTemplate class, Ribbon will round-robin load balance all requests among all
        // the service instances.



        return restExchange.getBody();
    }
}
