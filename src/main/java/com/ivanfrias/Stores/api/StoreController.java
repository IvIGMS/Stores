package com.ivanfrias.Stores.api;

import com.ivanfrias.Stores.services.StoreService;
import com.ivanfrias.stores.api.StoresApi;
import com.ivanfrias.stores.model.StoreDTO;
import com.ivanfrias.stores.model.StoreRequestDTO;
import jakarta.transaction.Transactional;
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
    @Transactional
    public ResponseEntity<Void> deleteStoreById(Long storeId) {
        storeService.deleteById(storeId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<StoreDTO> createStore(StoreRequestDTO storeRequestDTO) {
        return ResponseEntity.created(null).body(storeService.createStore(storeRequestDTO));
    }

    @Override
    public ResponseEntity<StoreDTO> updateStoreById(Long storeId, StoreRequestDTO storeRequestDTO) {
        return ResponseEntity.ok(storeService.updateById(storeId, storeRequestDTO));
    }

    @Override
    public ResponseEntity<StoreDTO> getStoreById(Long storeId) {
        return ResponseEntity.ok(storeService.getById(storeId));
    }

    @Override
    public ResponseEntity<List<StoreDTO>> getStores() {
        return ResponseEntity.ok(storeService.getStores());
    }
}
