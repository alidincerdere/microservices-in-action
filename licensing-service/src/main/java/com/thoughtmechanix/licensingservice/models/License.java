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
    private String licenseId;

    @Column(name = "organization_id", nullable = false)
    private String organizationId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "license_type")
    private String licenseType;

    private String comment;


    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public License withComment(String comment) {

        this.setComment(comment);
        return this;
    }

    public License withId(String id){
        this.setLicenseId( id );
        return this;
    }

    public License withOrganizationId(String organizationId){
        this.setOrganizationId(organizationId);
        return this;
    }

    public License withProductName(String productName){
        this.setProductName(productName);
        return this;
    }

    public License withLicenseType(String licenseType){
        this.setLicenseType(licenseType);
        return this;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public String getProductName() {
        return productName;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public String getComment() {
        return comment;
    }
}
