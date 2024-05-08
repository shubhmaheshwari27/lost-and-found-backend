package com.college.lostandfound.service;

import com.college.lostandfound.model.FoundItem;
import com.college.lostandfound.model.LostItem;
import com.college.lostandfound.repository.FoundItemRepository ;
import com.college.lostandfound.repository.LostItemRepository ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final FoundItemRepository foundItemRepository;
    private final LostItemRepository lostItemRepository;

    @Autowired
    public ItemService(FoundItemRepository foundItemRepository, LostItemRepository lostItemRepository) {
        this.foundItemRepository = foundItemRepository;
        this.lostItemRepository = lostItemRepository;
    }

    // Method to retrieve all found items
    public List<FoundItem> getAllFoundItems() {
        return foundItemRepository.findAll();
    }

    // Method to retrieve all lost items
    public List<LostItem> getAllLostItems() {
        return lostItemRepository.findAll();
    }

    // Method to find a found item by its ID
    public Optional<FoundItem> getFoundItemById(Long id) {
        return foundItemRepository.findById(id);
    }

    // Method to find a lost item by its ID
    public Optional<LostItem> getLostItemById(Long id) {
        return lostItemRepository.findById(id);
    }

    // Method to save a new found item
    public FoundItem saveFoundItem(FoundItem foundItem) {
        return foundItemRepository.save(foundItem);
    }

    // Method to save a new lost item
    public LostItem saveLostItem(LostItem lostItem) {
        return lostItemRepository.save(lostItem);
    }

    // Method to delete a found item
    public void deleteFoundItem(Long id) {
        foundItemRepository.deleteById(id);
    }

    // Method to delete a lost item
    public void deleteLostItem(Long id) {
        lostItemRepository.deleteById(id);
    }
}