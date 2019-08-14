package com.thoughtmechanix.licensingservice.repository;

import com.thoughtmechanix.licensingservice.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adere on 14.08.2019.
 */
@Repository
public interface LicenseRepository extends CrudRepository<License,String> {

    List<License> findByOrganizationId(String organizationId);

    License findByOrOrganizationIdAndLicenseId(String organizationId, String licenseId);


}
