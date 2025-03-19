package com.ivanfrias.Stores.mappers;

import com.ivanfrias.Stores.model.StoreEntity;
import com.ivanfrias.stores.model.StoreRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface StoreEntityStoreRequestDTOMapper {

    StoreEntity storeRequestDTOToStoreEntity(StoreRequestDTO storeDTO);

    StoreRequestDTO storeEntityToStoreRequestDTO(StoreEntity storeEntity);
}
