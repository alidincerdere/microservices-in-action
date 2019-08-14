package com.thoughtmechanix.licensingservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by adere on 10.08.2019.
 */

@Entity
@Table(name = "licenses")
public class License{

    @Id
    @Column(name = "license_id", nullable = false)
    private String id;

    @Column(name = "organization_id", nullable = false)
    private String organizationId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "license_type", nullable = false)
    private String licenseType;


}
