package com.thoughtmechanix.licensingservice.models;

import javax.persistence.*;

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

    @Transient
    private String organizationName ="";

    @Transient
    private String contactName ="";

    @Transient
    private String contactPhone ="";

    @Transient
    private String contactEmail ="";

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

    public License withOrganizationName(String organizationName) {
        this.setOrganizationName(organizationName);
        return this;
    }

    public License withContactName(String contactName) {
        this.setContactName(contactName);
        return this;
    }

    public License withContactEmail(String contactEmail) {
        this.setContactEmail(contactEmail);
        return this;
    }

    public License withContactPhone(String contactPhone) {
        this.setContactPhone(contactPhone);
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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
