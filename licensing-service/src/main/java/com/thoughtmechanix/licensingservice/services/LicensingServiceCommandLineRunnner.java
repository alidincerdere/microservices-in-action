package com.thoughtmechanix.licensingservice.services;

import com.thoughtmechanix.licensingservice.models.License;
import com.thoughtmechanix.licensingservice.repository.LicenseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by adere on 14.08.2019.
 */
@Component
public class LicensingServiceCommandLineRunnner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(LicensingServiceCommandLineRunnner.class);

    @Autowired
    private LicenseRepository licenseRepository;

    @Override
    public void run(String... strings) throws Exception {

        log.info("setting up DB...");

        License license = new License().withId("10").withOrganizationId("10").withLicenseType("product license").withProductName("");

        licenseRepository.save(license);

        log.info("DB Setup complete");

    }
}
