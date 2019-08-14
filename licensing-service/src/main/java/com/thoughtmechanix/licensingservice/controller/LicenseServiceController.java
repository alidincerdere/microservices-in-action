package com.thoughtmechanix.licensingservice.controller;

import com.thoughtmechanix.licensingservice.models.License;
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

    @RequestMapping(value ="{licenseId}" , method = RequestMethod.GET)
    public License getLicences(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {
        return new License();
    }
}
