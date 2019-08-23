package com.thoughtmechanix.organizationservice.service;

import com.thoughtmechanix.organizationservice.model.Organization;
import com.thoughtmechanix.organizationservice.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by adere on 24.08.2019.
 */
@Component
public class OrganizationsCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(OrganizationsCommandLineRunner.class);

    @Autowired
    private OrganizationRepository repository;

    @Override
    public void run(String... strings) throws Exception {

        log.info("setting up DB");

        Organization organization = new Organization("10", "home", "Ali Dincer", "5544433", "afasadd@sadad.com");

        repository.save(organization);

        log.info("done");

    }
}
