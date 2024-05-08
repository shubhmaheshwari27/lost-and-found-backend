package com.college.lostandfound.Controller;

import com.college.lostandfound.model.FoundItem;
import com.college.lostandfound.model.LostItem;
import com.college.lostandfound.service.ItemService ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class NewItemController {

    private final ItemService itemService;

    @Autowired
    public NewItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/found")
    public ResponseEntity<List<FoundItem>> getAllFoundItems() {
        List<FoundItem> foundItems = itemService.getAllFoundItems();
        return ResponseEntity.ok(foundItems);
    }

    @GetMapping("/lost")
    public ResponseEntity<List<LostItem>> getAllLostItems() {
        List<LostItem> lostItems = itemService.getAllLostItems();
        return ResponseEntity.ok(lostItems);
    }

    @GetMapping("/found/{id}")
    public ResponseEntity<FoundItem> getFoundItemById(@PathVariable("id") Long id) {
        Optional<FoundItem> foundItem = itemService.getFoundItemById(id);
        return foundItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/lost/{id}")
    public ResponseEntity<LostItem> getLostItemById(@PathVariable("id") Long id) {
        Optional<LostItem> lostItem = itemService.getLostItemById(id);
        return lostItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/found")
    public ResponseEntity<FoundItem> saveFoundItem(@RequestBody FoundItem foundItem) {
        FoundItem savedFoundItem = itemService.saveFoundItem(foundItem);
        return new ResponseEntity<>(savedFoundItem, HttpStatus.CREATED);
    }

    @PostMapping("/lost")
    public ResponseEntity<LostItem> saveLostItem(@RequestBody LostItem lostItem) {
        LostItem savedLostItem = itemService.saveLostItem(lostItem);
        return new ResponseEntity<>(savedLostItem, HttpStatus.CREATED);
    }

    @DeleteMapping("/found/{id}")
    public ResponseEntity<Void> deleteFoundItem(@PathVariable("id") Long id) {
        itemService.deleteFoundItem(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/lost/{id}")
    public ResponseEntity<Void> deleteLostItem(@PathVariable("id") Long id) {
        itemService.deleteLostItem(id);
        return ResponseEntity.noContent().build();
    }
}
