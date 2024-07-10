package com.dhotels.hotelsbackend.controllers;

import com.dhotels.hotelsbackend.helpers.BusinessUpdateRequest;
import com.dhotels.hotelsbackend.helpers.NewBusinessTypeRequest;
import com.dhotels.hotelsbackend.helpers.RegisterBusinessRequest;
import com.dhotels.hotelsbackend.modules.Business;
import com.dhotels.hotelsbackend.modules.BusinessType;
import com.dhotels.hotelsbackend.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;


    @ResponseBody
    @PostMapping("/registerBusiness/{id}")
    public ResponseEntity<Business> registerBusiness(
            @PathVariable("id") Integer userId,
            @RequestBody RegisterBusinessRequest registerBusinessRequest
            ){

        Business business = businessService.registerBusiness(
                userId, registerBusinessRequest
        );

        return  new ResponseEntity<Business>(
                business, HttpStatus.CREATED
        );
    }

    @ResponseBody
    @PostMapping("/updateBusiness/{id}")
    public ResponseEntity<Business> updateBusiness(
            @PathVariable("id") Integer businessId,
            @RequestBody BusinessUpdateRequest businessUpdateRequest
            ){

        Business business = businessService.updateBusiness(
                businessId,
                businessUpdateRequest
        );

        return new ResponseEntity<Business>(
                business, HttpStatus.OK
        );
    }


    @ResponseBody
    @DeleteMapping("/deleteBusiness/{id}")
    public ResponseEntity<Void> deleteBusiness(
            @PathVariable("id") Integer businessId
    ){

        businessService.deleteBusiness(businessId);

        return  new ResponseEntity<Void>(HttpStatus.OK);
    }


    @ResponseBody
    @GetMapping("/getBusiness/{id}")
    public ResponseEntity<Business> getBusinessById(
            @PathVariable("id") Integer businessId
    ){
        Business business = businessService.getBusinessById(businessId);

        return new ResponseEntity<Business>(
                business, HttpStatus.OK
        );
    }


    @ResponseBody
    @GetMapping("/getBusinessByUser/{id}")
    public ResponseEntity<List<Business>> getBusinessesByOwner(
            @PathVariable("id") Integer ownerId
    ){
        List<Business> businesses = businessService.getAllBusinessesByOwner(ownerId);

        return new ResponseEntity<List<Business>>(
                businesses, HttpStatus.OK
        );
    }


    @ResponseBody
    @GetMapping("/getBusinessByType/{id}")
    public ResponseEntity<List<Business>> getBusinessesByType(
            @PathVariable("id") Integer typeId
    ){
        List<Business> businesses = businessService.getAllBusinessesByBusinessType(typeId);

        return new ResponseEntity<List<Business>>(
                businesses, HttpStatus.OK
        );
    }


    @ResponseBody
    @PostMapping("/addBusinessType")
    public ResponseEntity<BusinessType> registerBusiness(
            @RequestBody NewBusinessTypeRequest businessTypeRequest
            ){

        BusinessType businessType = businessService.addBusinessType(
                businessTypeRequest
        );

        return  new ResponseEntity<BusinessType>(
                businessType, HttpStatus.CREATED
        );
    }


    @ResponseBody
    @DeleteMapping("/deleteBusinessType/{id}")
    public ResponseEntity<Void> deleteBusinessType(
            @PathVariable("id") Integer typeId
    ){

        businessService.removeBusinessType(typeId);

        return  new ResponseEntity<Void>(HttpStatus.OK);
    }


}
