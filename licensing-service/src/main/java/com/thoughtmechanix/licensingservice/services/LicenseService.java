package com.thoughtmechanix.licensingservice.services;

import com.thoughtmechanix.licensingservice.config.ServiceConfig;
import com.thoughtmechanix.licensingservice.models.License;
import com.thoughtmechanix.licensingservice.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by adere on 14.08.2019.
 */
@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    ServiceConfig config;

    public License getLicense (String organizationId, String licenseId) {

        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);

        return license.withComment(config.getExampleProperty());
    }

    public List<License> getLicenseByOrg(String organizationId) {

        return licenseRepository.findByOrganizationId(organizationId);
    }

    public void saveLicense(License license) {

        //license.withId(UUID.randomUUID().toString());

        licenseRepository.save(license);
    }

}
