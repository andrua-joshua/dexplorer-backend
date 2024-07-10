package com.dhotels.hotelsbackend.services;

import com.dhotels.hotelsbackend.exception.ResourceNotFoubdException;
import com.dhotels.hotelsbackend.helpers.BusinessAmenitUpdateReq;
import com.dhotels.hotelsbackend.helpers.BusinessUpdateRequest;
import com.dhotels.hotelsbackend.helpers.NewBusinessTypeRequest;
import com.dhotels.hotelsbackend.helpers.RegisterBusinessRequest;
import com.dhotels.hotelsbackend.modules.*;
import com.dhotels.hotelsbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BusinessService {

    @Autowired
    BusinessRepository businessRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    BusinessTypeRepository businessTypeRepository;


    ///todo ---the possible values
    ///register business
    ///remove or delete business
    ///update business
    ///add business Category or Type <---
    ///get business Category or Type
    ///removing business Category or Type

    ///todo {Filtrations on the businesses database}
    ///get business by id
    ///get business by owner
    ///get business by category or owner

    ///todo {piece by piece updates}
    ///update amenities


    public Business registerBusiness(
            Integer userId,
            RegisterBusinessRequest registerBusinessRequest
    ){
        User user = userRepository.findById(userId)
                .orElseThrow(
                        ResourceNotFoubdException::new
                );

        Currency currency = currencyRepository.findById(
                registerBusinessRequest.getCurrency()
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Currency not found")
        );

        BusinessType businessType = businessTypeRepository.findById(
                registerBusinessRequest.getBusinessType()
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Business type not found")
        );

        User owner = userRepository.findById(
                userId
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "User not found")
        );

        Business business = new Business(
                registerBusinessRequest.getBusinessName(),
                registerBusinessRequest.getAddress(),
                registerBusinessRequest.getCity(),
                0,
                new ArrayList<String>(),
                currency,
                businessType,
                new ArrayList<DiningItem>(),
                new ArrayList<Room>(),
                owner,
                new ArrayList<String>(),
                new ArrayList<FavouriteBusiness>(),
                new Date()
        );

        Business savedBusiness = businessRepository.save(business);

        user.getBusinesses().add(savedBusiness);
        businessType.getBusinesses().add(savedBusiness);
        currency.getBusinesses().add(savedBusiness);

        userRepository.save(user);
        businessTypeRepository.save(businessType);
        currencyRepository.save(currency);

        return savedBusiness;
    }


    public Business updateBusiness(
            Integer businessId,
            BusinessUpdateRequest businessUpdateRequest
    ){
        Business business = businessRepository.findById(
                businessId
        ).orElseThrow(
                ResourceNotFoubdException::new
        );

        Currency currency = currencyRepository.findById(
                businessUpdateRequest.getCurrency()
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Resource Not found")
        );


        Currency prevCurrency = business.getCurrency();

        prevCurrency.getBusinesses().remove(business);

        business.setBusinessName(businessUpdateRequest.getBusinessName());
        business.setAddress(businessUpdateRequest.getAddress());
        business.setCity(businessUpdateRequest.getCity());
        business.setCurrency(currency);

        Business savedBusiness = businessRepository.save(business);

        currency.getBusinesses().add(savedBusiness);
        currencyRepository.save(currency);
        currencyRepository.save(prevCurrency);
        return savedBusiness;
    }


    public void deleteBusiness(Integer businessId){
        Business business = businessRepository.findById(businessId)
                .orElseThrow(
                        ResourceNotFoubdException::new
                );

        User user = business.getOwner();
        BusinessType businessType = business.getBusinessType();
        Currency currency = business.getCurrency();

        businessType.getBusinesses().remove(business);
        user.getBusinesses().remove(business);
        currency.getBusinesses().remove(business);

        userRepository.save(user);
        businessTypeRepository.save(businessType);
        currencyRepository.save(currency);

        businessRepository.delete(business);
    }


    public Business getBusinessById(Integer businessId){
        Business business = businessRepository.findById(
                businessId
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Business not found"
                )
        );

        return business;
    }

    public List<Business> getAllBusinessesByOwner(Integer userId){
        User user = userRepository.findById(userId)
                .orElseThrow(
                        ()-> new ResourceNotFoubdException(
                                "User not found"
                        )
                );
        return businessRepository.findAllByOwner(user).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Business for owner not found"
                )
        );
    }


    public List<Business> getAllBusinessesByBusinessType(Integer typeId){
        BusinessType businessType = businessTypeRepository.findById(typeId)
                .orElseThrow(
                        ()-> new ResourceNotFoubdException(
                                "User not found"
                        )
                );
        return businessRepository.findAllByBusinessType(businessType).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Business for owner not found"
                )
        );
    }


    public BusinessType addBusinessType(NewBusinessTypeRequest businessTypeRequest){
        BusinessType businessType = new BusinessType(
                businessTypeRequest.getName(),
                businessTypeRequest.getDescription(),
                new ArrayList<Business>()
        );

        return  businessTypeRepository.save(businessType);
    }

    public void removeBusinessType(Integer typeId ){
        BusinessType businessType = businessTypeRepository.findById(
                typeId
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Business Type not Found"
                )
        );

        businessTypeRepository.delete(businessType);
    }

    public void updateAmenities(BusinessAmenitUpdateReq amenitUpdateReq){
        Business business = businessRepository.findById(amenitUpdateReq.getBusinessId())
                .orElseThrow(
                        ()-> new ResourceNotFoubdException(
                                "User not found"
                        )
                );

        business.setAmenities(amenitUpdateReq.getAmenities());
        businessRepository.save(business);
    }


}
