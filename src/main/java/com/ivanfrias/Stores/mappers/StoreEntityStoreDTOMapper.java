package com.ivanfrias.Stores.mappers;

import com.ivanfrias.Stores.model.StoreEntity;
import com.ivanfrias.stores.model.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface StoreEntityStoreDTOMapper {

    StoreEntity storeDTOToStoreEntity(StoreDTO storeDTO);

    StoreDTO storeEntityToStoreDTO(StoreEntity storeEntity);

    List<StoreEntity> storeDTOListToStoreEntityList(List<StoreDTO> storeDTOList);

    List<StoreDTO> storeEntityListToStoreDTOList(List<StoreEntity> storeEntityList);
}
