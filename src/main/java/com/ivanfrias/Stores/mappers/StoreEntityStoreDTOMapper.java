package com.ivanfrias.Stores.mappers;

import com.ivanfrias.Stores.model.StoreEntity;
import com.ivanfrias.stores.model.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface StoreEntityStoreDTOMapper {

    @Mapping(target = "createdAt", expression = "java(mapOffsetToZonedDateTime(storeDTO.getCreatedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetToZonedDateTime(storeDTO.getUpdatedAt()))")
    StoreEntity storeDTOToStoreEntity(StoreDTO storeDTO);

    @Mapping(target = "createdAt", expression = "java(mapZonedDateTimeToOffset(storeEntity.getCreatedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapZonedDateTimeToOffset(storeEntity.getUpdatedAt()))")
    StoreDTO storeEntityToStoreDTO(StoreEntity storeEntity);

    List<StoreEntity> storeDTOListToStoreEntityList(List<StoreDTO> storeDTOList);

    List<StoreDTO> storeEntityListToStoreDTOList(List<StoreEntity> storeEntityList);

    default ZonedDateTime mapOffsetToZonedDateTime(OffsetDateTime offsetDateTime) {
        return offsetDateTime != null ? offsetDateTime.toZonedDateTime() : null;
    }

    default OffsetDateTime mapZonedDateTimeToOffset(ZonedDateTime zonedDateTime) {
        return zonedDateTime != null ? zonedDateTime.toOffsetDateTime() : null;
    }
}