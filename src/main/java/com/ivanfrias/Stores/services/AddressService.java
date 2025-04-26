package com.ivanfrias.Stores.services;

import com.ivanfrias.Stores.model.AddressEntity;
import com.ivanfrias.Stores.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public void deleteAddress(Long addressId){
        addressRepository.deleteById(addressId);
    }
}
