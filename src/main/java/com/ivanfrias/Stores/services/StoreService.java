package com.ivanfrias.Stores.services;

import com.ivanfrias.Stores.exceptions.DataBaseErrorException;
import com.ivanfrias.Stores.exceptions.NotFoundException;
import com.ivanfrias.Stores.mappers.AddressMapper;
import com.ivanfrias.Stores.mappers.StoreEntityStoreDTOMapper;
import com.ivanfrias.Stores.mappers.StoreEntityStoreRequestDTOMapper;
import com.ivanfrias.Stores.model.StoreEntity;
import com.ivanfrias.Stores.repositories.StoreRepository;
import com.ivanfrias.stores.model.StoreDTO;
import com.ivanfrias.stores.model.StoreRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final StoreEntityStoreDTOMapper storeEntityStoreDTOMapper;
    private final StoreEntityStoreRequestDTOMapper storeEntityStoreRequestDTOMapper;
    private final AddressMapper addressMapper;

    public StoreDTO createStore(StoreRequestDTO storeRequestDTO) {

        try{
            StoreEntity storeEntityToBeSaved = storeEntityStoreRequestDTOMapper.storeRequestDTOToStoreEntity(storeRequestDTO);
            StoreEntity storeEntitySaved = storeRepository.save(storeEntityToBeSaved);
            return storeEntityStoreDTOMapper.storeEntityToStoreDTO(storeEntitySaved);
        } catch (Exception e){
            throw new DataBaseErrorException("Error al introducir al nueva tienda en la base de datos");
        }
    }

    public List<StoreDTO> getStores() {
        List<StoreEntity> storeEntities = storeRepository.findAll();

        if(CollectionUtils.isEmpty(storeEntities)){
            throw new NotFoundException("No hay ninguna tienda registrada en la aplicación");
        }
        return storeEntityStoreDTOMapper.storeEntityListToStoreDTOList(storeEntities);
    }

    public StoreDTO getById(Long storeId) {
        Optional<StoreEntity> storeEntityOptional = storeRepository.findById(storeId);
        if (storeEntityOptional.isPresent()){
            return storeEntityStoreDTOMapper.storeEntityToStoreDTO(storeEntityOptional.get());
        } else {
            throw new NotFoundException("No existe una store con el id: {}", storeId);
        }
    }

    public void deleteById(Long storeId) {
        StoreDTO storeDTO = getById(storeId);
        try {
            storeRepository.deleteById(storeId);
        } catch (Exception e){
            throw new DataBaseErrorException("Error al eliminar la tienda de la base de datos");
        }
    }

    public StoreDTO updateById(Long storeId, StoreRequestDTO storeRequestDTO) {
        Optional<StoreEntity> storeEntityOptional = storeRepository.findById(storeId);
        StoreEntity storeEntity = new StoreEntity();
        if (storeEntityOptional.isPresent()){
            storeEntity = storeEntityOptional.get();
            storeEntity.setName(storeRequestDTO.getName());
            storeEntity.setAddress(addressMapper.addressDTOToAddressEntity(storeRequestDTO.getAddress()));

            storeRepository.save(storeEntity);
        } else {
            throw new NotFoundException("No existe una store con el id: {}", storeId);
        }
        return storeEntityStoreDTOMapper.storeEntityToStoreDTO(storeEntity);
    }
}
