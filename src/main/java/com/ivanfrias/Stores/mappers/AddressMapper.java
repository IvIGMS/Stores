package com.ivanfrias.Stores.mappers;

import com.ivanfrias.Stores.model.AddressEntity;
import com.ivanfrias.stores.model.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressEntity addressDTOToAddressEntity(AddressDTO addressDTO);

    AddressDTO addressEntityToAddressDTO(AddressEntity addressEntity);
}