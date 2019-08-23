package com.thoughtmechanix.organizationservice.service;

import com.thoughtmechanix.organizationservice.model.Organization;
import com.thoughtmechanix.organizationservice.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by adere on 24.08.2019.
 */
@Component
public class OrganizationService {

    @Autowired
    private OrganizationRepository repository;


    public Organization getOrg(String organizationId) {
        return repository.findByOrganizationId(organizationId);
    }

    public void saveOrg(Organization org){
        org.setOrganizationId( UUID.randomUUID().toString());

        repository.save(org);

    }

    public void updateOrg(Organization org){
        repository.save(org);
    }

    public void deleteOrg(Organization org){
        repository.delete(org);
    }
}
