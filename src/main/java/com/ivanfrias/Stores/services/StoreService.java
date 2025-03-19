package com.ivanfrias.Stores.services;

import com.ivanfrias.Stores.exceptions.NotFoundException;
import com.ivanfrias.Stores.model.AddressEntity;
import com.ivanfrias.Stores.model.StoreEntity;
import com.ivanfrias.Stores.repositories.StoreRepository;
import com.ivanfrias.stores.model.AddressDTO;
import com.ivanfrias.stores.model.StoreDTO;
import com.ivanfrias.stores.model.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreDTO createStore(StoreRequestDTO storeRequestDTO) {
        // todo usar un mapper para esto:

        StoreEntity storeEntity = storeRepository.save(StoreEntity.builder()
                        .name(storeRequestDTO.getName())
                        .address(AddressEntity.builder()
                                .street(storeRequestDTO.getAddress().getStreet())
                                .city(storeRequestDTO.getAddress().getCity())
                                .country(storeRequestDTO.getAddress().getCountry())
                                .build())
                .build());

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(storeEntity.getId());
        storeDTO.setName(storeEntity.getName());
        storeDTO.setAddress(new AddressDTO());
        storeDTO.getAddress().setCity(storeEntity.getAddress().getCity());
        storeDTO.getAddress().setCountry(storeEntity.getAddress().getCountry());
        storeDTO.getAddress().setStreet(storeEntity.getAddress().getStreet());

        return storeDTO;
    }

    public List<StoreDTO> getStores() {
        List<StoreEntity> storeEntities = storeRepository.findAll();

        if(CollectionUtils.isEmpty(storeEntities)){
            throw new NotFoundException("No hay ninguna tienda registrada en la aplicación");
        }
        return List.of();
    }
}
