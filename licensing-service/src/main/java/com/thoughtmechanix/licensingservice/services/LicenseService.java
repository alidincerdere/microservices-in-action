package com.thoughtmechanix.licensingservice.services;

import com.thoughtmechanix.licensingservice.client.OrganizationDiscoveryClient;
import com.thoughtmechanix.licensingservice.client.OrganizationFeignClient;
import com.thoughtmechanix.licensingservice.client.OrganizationRestTemplateClient;
import com.thoughtmechanix.licensingservice.config.ServiceConfig;
import com.thoughtmechanix.licensingservice.models.License;
import com.thoughtmechanix.licensingservice.models.Organization;
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

    @Autowired
    private OrganizationDiscoveryClient organizationDiscoveryClient;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    @Autowired
    private OrganizationRestTemplateClient organizationRestClient;


    public License getLicense (String organizationId, String licenseId) {

        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);

        return license.withComment(config.getExampleProperty());
    }

    public License getLicense (String organizationId, String licenseId, String clientType) {

        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);

        Organization org = retrieveOrgInfo(organizationId, clientType);

        return license.withComment(config.getExampleProperty())
                .withContactEmail(org.getContactEmail())
                .withContactName(org.getContactName())
                .withContactPhone(org.getContactPhone())
                .withOrganizationName(org.getName());
    }

    private Organization retrieveOrgInfo(String organizationId, String clientType) {

        Organization organization = null;

        switch (clientType) {
            case "feign":
                System.out.println("I am using the feign client");
                organization = organizationFeignClient.getOrganization(organizationId);
                break;
            case "rest":
                System.out.println("I am using the rest client");
                organization = organizationRestClient.getOrganization(organizationId);
                break;
            case "discovery":
                System.out.println("I am using the discovery client");
                organization = organizationDiscoveryClient.getOrganization(organizationId);
                break;
            default:
                organization = organizationRestClient.getOrganization(organizationId);
        }

        return organization;
    }

    public List<License> getLicenseByOrg(String organizationId) {

        return licenseRepository.findByOrganizationId(organizationId);
    }

    public void saveLicense(License license) {

        //license.withId(UUID.randomUUID().toString());

        licenseRepository.save(license);
    }

}
