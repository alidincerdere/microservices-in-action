package com.thoughtmechanix.licensingservice.services;

import com.thoughtmechanix.licensingservice.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adere on 14.08.2019.
 */
@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

}
