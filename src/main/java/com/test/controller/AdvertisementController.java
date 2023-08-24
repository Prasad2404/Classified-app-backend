package com.test.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.model.Advertisement;
import com.test.service.AdvertisementService;

@RestController
@RequestMapping("/advertisements")
@CrossOrigin("*")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public List<Advertisement> getAllAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable Long id) {
        Advertisement advertisement = advertisementService.getAdvertisementById(id);
        return ResponseEntity.ok(advertisement);
    }

    @PostMapping("/")
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement) {
        advertisement.setPostDateTime(LocalDateTime.now());
        Advertisement createdAdvertisement = advertisementService.createAdvertisement(advertisement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdvertisement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advertisement> updateAdvertisement(
            @PathVariable Long id,
            @RequestBody Advertisement updatedAdvertisement
    ) {
        Advertisement advertisement = advertisementService.updateAdvertisement(id, updatedAdvertisement);
        return ResponseEntity.ok(advertisement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertisement(@PathVariable Long id) {
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/block")
    public ResponseEntity<Void> blockAdvertisement(@PathVariable Long id) {
        advertisementService.blockAdvertisement(id);
        return ResponseEntity.ok().build();
    }
}

