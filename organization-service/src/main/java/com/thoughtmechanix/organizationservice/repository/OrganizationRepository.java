package com.thoughtmechanix.organizationservice.repository;

import com.thoughtmechanix.organizationservice.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by adere on 23.08.2019.
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization,String> {

     Organization findByOrganizationId(String organizationId);
}
