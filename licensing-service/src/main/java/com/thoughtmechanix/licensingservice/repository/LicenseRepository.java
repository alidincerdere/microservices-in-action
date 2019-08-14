package com.thoughtmechanix.licensingservice.repository;

import com.thoughtmechanix.licensingservice.models.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adere on 14.08.2019.
 */
@Repository
public interface LicenseRepository extends JpaRepository<License,String> {

    List<License> findByOrganizationId(String organizationId);

    License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);


}
