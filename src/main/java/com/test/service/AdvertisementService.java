package com.test.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.test.model.Advertisement;

public interface AdvertisementService {
    List<Advertisement> getAllAdvertisements();
    Advertisement getAdvertisementById(Long id);
    Advertisement createAdvertisement(Advertisement advertisement);
    Advertisement updateAdvertisement(Long id, Advertisement updatedAdvertisement);
    void deleteAdvertisement(Long id);
    void blockAdvertisement(Long id);
	void store(MultipartFile file);
	Advertisement getFile(long id);
}

