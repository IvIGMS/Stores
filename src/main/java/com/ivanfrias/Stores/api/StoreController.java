package com.ivanfrias.Stores.api;

import com.ivanfrias.Stores.services.StoreService;
import com.ivanfrias.stores.api.StoresApi;
import com.ivanfrias.stores.model.StoreDTO;
import com.ivanfrias.stores.model.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class StoreController implements StoresApi {

    private final StoreService storeService;

    @Override
    public ResponseEntity<Void> deleteStoreById(Long storeId) {
        return StoresApi.super.deleteStoreById(storeId);
    }

    @Override
    public ResponseEntity<StoreDTO> createStore(StoreRequestDTO storeRequestDTO) {
        return ResponseEntity.created(null).body(storeService.createStore(storeRequestDTO));
    }

    @Override
    public ResponseEntity<List<StoreDTO>> getStoreById(Long storeId) {
        return StoresApi.super.getStoreById(storeId);
    }

    @Override
    public ResponseEntity<List<StoreDTO>> getStores() {
        return ResponseEntity.ok(storeService.getStores());
    }

    @Override
    public ResponseEntity<Void> updateStoreById(Long storeId, StoreRequestDTO storeRequestDTO) {
        return StoresApi.super.updateStoreById(storeId, storeRequestDTO);
    }
}
