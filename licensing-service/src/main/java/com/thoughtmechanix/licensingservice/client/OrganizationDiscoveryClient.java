package com.thoughtmechanix.licensingservice.client;

import com.thoughtmechanix.licensingservice.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by adere on 22.08.2019.
 */
@Component
public class OrganizationDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient; //This is the class you’ll use to interact with Ribbon

    public Organization getOrganization(String organizationId) {

        RestTemplate restTemplate = new RestTemplate();

        List<ServiceInstance> instances = discoveryClient.getInstances("organization-service");
        //You aren’t taking advantage of Ribbon’s client side load-balancing.
        //By calling the DiscoveryClient directly, you get back a list of services, but it becomes your responsibility
        // to choose which service instances returned you’re going to invoke.
        if (instances.size() == 0) return null;
        String serviceUri = String.format("%s/v1/organizations/%s", instances.get(0).getUri().toString(), organizationId);

        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        serviceUri,
                        HttpMethod.GET,
                        null, Organization.class, organizationId);

        return restExchange.getBody();
    }
}
