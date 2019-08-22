package com.thoughtmechanix.organizationservice.controller;

import com.thoughtmechanix.organizationservice.model.Organization;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adere on 22.08.2019.
 */
@RestController
@RequestMapping(value = "v1/organizations")
public class OrganizationServiceController {

    @RequestMapping(value="/{organizationId}",method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
        return null;
    }
}
