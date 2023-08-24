package com.test.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.model.Advertisement;
import com.test.repository.AdvertisementRepository;
import com.test.service.AdvertisementService;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    @Override
    public Advertisement getAdvertisementById(Long id) {
        return advertisementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Advertisement not found with id: " + id));
    }

    @Override
    public Advertisement createAdvertisement(Advertisement advertisement) {
    	System.out.println(advertisement);
        return advertisementRepository.save(advertisement);
    }

    @Override
    public Advertisement updateAdvertisement(Long id, Advertisement updatedAdvertisement) {
        Advertisement existingAdvertisement = getAdvertisementById(id);
        // Update existingAdvertisement properties with updatedAdvertisement properties
        // ...

        return advertisementRepository.save(existingAdvertisement);
    }

    @Override
    public void deleteAdvertisement(Long id) {
        Advertisement advertisement = getAdvertisementById(id);
        advertisementRepository.delete(advertisement);
    }

    @Override
    public void blockAdvertisement(Long id) {
        Advertisement advertisement = getAdvertisementById(id);
        advertisement.setStatus(false);
        advertisementRepository.save(advertisement);
    }

	@Override
	public void store(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Advertisement getFile(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}

