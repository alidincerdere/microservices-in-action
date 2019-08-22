package com.thoughtmechanix.licensingservice.controller;

import com.thoughtmechanix.licensingservice.models.License;
import com.thoughtmechanix.licensingservice.repository.LicenseRepository;
import com.thoughtmechanix.licensingservice.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adere on 10.08.2019.
 */
@RestController
@RequestMapping (value = "/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    @Autowired
    private LicenseService service;

    @RequestMapping(value ="/{licenseId}" , method = RequestMethod.GET)
    public License getLicences(@PathVariable("organizationId") String organizationId,
                                      @PathVariable("licenseId") String licenseId) {
        License license = service.getLicense(organizationId, licenseId);
        return license;
    }

    @RequestMapping(value = "/{licenseId}/{clientType}", method = RequestMethod.GET)
    public License getLicensesWithClient(@PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId, @PathVariable("clientType") String clientType) {

        License license = service.getLicense(organizationId, licenseId, clientType);

        return license;

    }

}
