package com.example.Thawaq.Service;

import com.example.Thawaq.Model.StoreAdmin;
import com.example.Thawaq.Repository.StoreAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreAdminService {
    private final StoreAdminRepository storeAdminRepository;

    public List<StoreAdmin> getAllStoreAdmins() {
        return storeAdminRepository.findAll();
    }

    public StoreAdmin getStoreAdminById(Integer id) {
        return storeAdminRepository.findStoreAdminById(id);
    }
}