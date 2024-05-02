package com.college.lostandfound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LostItemController {

    // This method will handle POST requests to report lost items
    @PostMapping("/lost-items/report")
    public ResponseEntity<String> reportLostItem(@RequestBody LostItemRequest lostItemRequest) {
        // Perform validation on the received data (e.g., check for null values)
        if (lostItemRequest.getItemName() == null || lostItemRequest.getItemName().isEmpty() ||
                lostItemRequest.getCategory() == null || lostItemRequest.getCategory().isEmpty() ||
                lostItemRequest.getDescription() == null || lostItemRequest.getDescription().isEmpty()) {
            // If any required field is missing, return a bad request response
            return ResponseEntity.badRequest().body("Please provide all required information");
        }

        // If validation passes, save the lost item report to the database (or perform any other necessary operations)
        // For demonstration purposes, let's assume the lost item report is successfully saved
        // You can replace this with your actual logic to save the report

        // Return a success response
        return ResponseEntity.ok("Lost item report submitted successfully");
    }
}
